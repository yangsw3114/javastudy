package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.ClosedFileSystemException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Request;

import echo.EchoServer;

public class ChatServerThread extends Thread{
	private String nickname;
	private Socket socket;
	List<Writer> listWriters;
	BufferedReader BR;
	PrintWriter PW;
	
	public ChatServerThread(Socket socket, List<Writer> listWriters) { //소켓을 매개변수로 하는 생성자
		this.socket = socket;
		this.listWriters = listWriters;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		//원격 호스트 정보
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress(); // 원격호스트 정보 따오기
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress(); // 호스트 주소 정보
		int remoteHostPort = inetRemoteSocketAddress.getPort(); //호스트 port 번호
		
		ChatServer.log("connected by client [ " + remoteHostAddress +  "/" + remoteHostPort + "]");
		
		try {
			BR = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8")); //버퍼드리더 / input
			PW = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8")); //프린트라이터 /output
			
			while(true) { //loop문을 통한 처리
				String request = BR.readLine();
				if(request==null) {
					ChatServer.log("클라이언트로부터 연결 끊김");
					doQuit(PW);
					break;
				}
				else if(request == "quit") {
					
				}
				
				ChatServer.log("received:" + request);
				PW.println(request);
				
				
				String[] tokens = request.split(":");
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], PW);
				}
				else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				}
				else if("quit".equals(tokens[0])) {
					doQuit();
				}
				else {
					ChatServer.log("에러: 알수 없는 요청( " + tokens[0] +" )");
				}
			}
			

			
			
		} catch (UnsupportedEncodingException e) {
			ChatServer.log("에러: " + e );
		} catch(IOException e){
			ChatServer.log("에러: " + e );
		}finally {
			try {
				if(socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}



	private void doJoin(String nickName, Writer writer) { //닉네임을 등록하기 위한 요청 메서드
		this.nickname = nickName;
		
		String data = nickname +"님이 참여하였습니다.";
		broadcast(data);

		//writer pool에 현재 스레드의 writer인 printWriter를 저장해야한다
		addWriter(writer); // writer pool 에 저장
		
		PW.println("join:ok"); //방 참여가 성공했다는 것을 클라이언트에게 알려줘야한다.
		PW.flush();
	}
	
	private void addWriter(Writer writer) {
		synchronized (listWriters) { //synchronized는 여러 스레드가 하나의 공유 객체에 접근할때 동기화를 보장해준다.
			listWriters.add(writer); //list인 writer Pool 에 파라미터로 받은 writer를 추가한다.
		}
	}
	
	private void broadcast(String data) { // 스레드간 공유 객체인 listWriters에 접근하기때문에 동기화 처리를 해주어야함
		
		synchronized (listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
	
		}
	}
	
	private void doMessage(String message) { //메시지를 전달하기 위한 요청 메서드

	}
	
	private void doQuit(Writer writer) { //방을 나가기 위한 요청 메서드
		removeWriter(writer);
		
		String data = nickname + "님이 퇴장하였습니다.";
		broadcast(data);
	}
	private void removeWriter(Writer writer) { //현재 스레드의 writer를 Writer Pool에서 제거한다.
		
	}

}
