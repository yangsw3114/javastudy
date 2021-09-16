package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

import javax.xml.ws.WebEndpoint;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT = "./webapp";
	private Socket socket;
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();

			
			//input
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
					
			String request = null;
			while(true) {
				String line = br.readLine();
				
				//브라우저가 연결을 끊으면
				if(line == null) {
					break;
				}
				
				//SimpleHttpServer에서는 요청의 헤더만 읽음
				if("".equals(line)) {
					break;
				}
				//헤더의 첫번째 라인만 읽기위해서 설정해봄
				if(request == null) {
					request = line;
					break;
				}
				//consoleLog(line);
			}
			
			consoleLog(request);
			
			
			String[] tokens = request.split(" ");
			if("GET".equals(tokens[0])) {
				consoleLog("request: " + tokens[1]);
				responseStaticResource(outputStream, tokens[1], tokens[2]);
			}
			else {
				System.out.println("이거아닌교?"+tokens[0]);
				//methods: POST, PUT, DELETE, HEAD, CONNECT
				//SimpleHttpServer 에서는 무시(400 Bad Request 처리)
				response400Error(outputStream, tokens[1], tokens[2]);
				

			}
			
			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
//			outputStream.write( "HTTP/1.1 200 OK\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "\r\n".getBytes() );
//			outputStream.write( "<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) );

		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}

	private void responseStaticResource(OutputStream outputStream, String url, String protocol) throws IOException{
		//welcome file set
		if("/".equals(url)) {
			url = "/index.html";
		}
		
		File file = new File(DOCUMENT_ROOT + url);
		if(!file.exists()){
			response400Error(outputStream, url, protocol);
			return;
		}
		
		//nio
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());

		outputStream.write( (protocol + " 200 OK\r\n").getBytes( "UTF-8" ) );
		outputStream.write( ("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\r\n".getBytes() );
		outputStream.write(body);
	}

	private void response400Error(OutputStream outputStream, String url, String protocol) {

		url = "/error/400.html";

		
		File file = new File(DOCUMENT_ROOT + url);
		
		//nio
		byte[] body;
		try {
			body = Files.readAllBytes(file.toPath());
			outputStream.write( (protocol + " 400 Bad Request\r\n").getBytes( "UTF-8" ) );
			outputStream.write("Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
			outputStream.write( "\r\n".getBytes() );
			outputStream.write(body);
		} catch (IOException e) {
			System.out.println("오류");
		}
	}

	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
}
