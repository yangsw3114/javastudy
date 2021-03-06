package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer { //서버 -> 소켓을 열어두고 들어오는 클라이언트들을 허가한다. 허가후 각각의 스레드들의 생성 및 실행
	private static final int PORT = 6000; //포트 번호 설정
	private static List<Writer> listWriters = new ArrayList<Writer>();
	
	
	public static void main(String[] args) {
		ServerSocket serversocket = null;
		try {
			//1.서버 소켓 생성
			serversocket = new ServerSocket();
			
			//2. 바인딩
//			String hostAddress = InetAddress.getLocalHost().getHostAddress();
//			serversocket.bind(new InetSocketAddress(hostAddress, PORT));
			serversocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("연결 기다림:" + PORT);
			
			//3. 요청 대기
			while(true) { //무한루프를 통해 클라이언트의 요청을 계속 받아들이고, 요청이 오면 새로운 쓰레드를 생성하여 각 클라이언트와의 통신
				Socket socket = serversocket.accept();
				new ChatServerThread(socket, listWriters).start(); //채팅서버스레드 실행
			}
			
			
		} catch (IOException e) {
			log("error" + e);
		}finally {
			try {
				if(serversocket != null && serversocket.isClosed() == false) {
					serversocket.close(); //서버소켓 닫기
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String log) {
		System.out.println("[ChatServer] " + log);
	}

}
