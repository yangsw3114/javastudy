package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serversocket = null;
		try {
			//1.서버 소캣 생성
			 serversocket = new ServerSocket();
			 
			 //2.바인딩(binding)
			 //	Socket에 InetSocketAddress(IPAddress + port)
			 // IPAdress : 0.0.0.0. : 모든 IP로부터의 연결을 허용
			 serversocket.bind(new InetSocketAddress("0.0.0.0",5000));
			 
			 //3.accept
			 //	클라이언트로부터 연결 요청을 기다린다.
			 Socket socket = serversocket.accept(); //blocking
			 InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			 String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			 int remoteHostPort = inetRemoteSocketAddress.getPort();
			 
			 System.out.println("[server] connected by client["+remoteHostAddress+":"+remoteHostPort+"]");
			 
			 try {
				 //4. IO Stram 받아오기
				 InputStream is = socket.getInputStream();
				 OutputStream os = socket.getOutputStream();
				 
				 while(true) {
					 //5. 데이터 읽기
					 byte[] buffer = new byte[256];
					 int readByteCount = is.read(buffer); //blocking
					 if(readByteCount == -1) {
						 // 클라이언트가 정상적으로 종료(close() 호출)
						 System.out.println("[server] closed by client");
						 break;
					 } 
					 
					 String data = new String(buffer, 0, readByteCount, "utf-8");
					 System.out.println("[server] received: "+data);
					 
					 //6. 데이터 쓰기
					 os.write(data.getBytes("utf-8"));
				 }
			 }
			 catch(SocketException e){
				 System.out.println("[server] suddenly closed by client");
			 }
			 catch(IOException e){
				 System.out.println("[server]error"+e);
			 }finally {
				 try {
					 if(socket != null && socket.isClosed() == false)
						 socket.close();
					 
				 }catch(IOException e) {
					 e.printStackTrace();
				 }
				 
			 }

		} catch (IOException e) {
			System.out.println("[server error]"+e);
		}finally {
			try {
				if(serversocket != null && serversocket.isClosed() == false) {
					serversocket.close();
				}
				
			} catch (IOException e) {
				
			}
		}
	}

}
