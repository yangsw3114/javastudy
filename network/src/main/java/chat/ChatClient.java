package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Socket socket = null;
		
		try {
			//1. 키보드 연결
			System.out.print("닉네임>> ");
			String nickname = sc.nextLine();
			
			//2. 소켓 생성
			socket  = new Socket();
			
			//3. 연결
			socket.connect(new InetSocketAddress("127.0.0.1", 6000)); //IP와 포트 입력
			log("connected");
			
			//BufferedReader BR = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter PW = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
			
			PW.println("join: "+ nickname); // system.out.println과 동일하게 출력을 해주는 메서드이며,
			PW.flush();						// 현재 버퍼에 저장되어 있는 내용을 클라이언트나 서버로 전송하고 버퍼를 지운다.
			
			new ChatClientThread(socket).start(); //스레드 시작
			
			while(true) {
				System.out.print(">>");
				String input = sc.nextLine();
				if("quit".equals(input.toLowerCase())) { //입력값을 소문자로 치환한 후에 quit과 동일한지 검사
					//Quit프로토콜 처리
					PW.println("quit");
					PW.flush();
					break;
				}
				else { //입력하는 메시지들 처리
					PW.println("message:" + input);
					PW.flush();
				}
				
			}
			
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("error: " + e);
		} catch (IOException e) {
			
			log("error " +e);
		}
		finally {
			try {
				if(socket != null && socket.isClosed() ==false) 
				{ 
					socket.close();
				}
				if(sc != null) {
					sc.close();
				}
				
				
			} catch (IOException e) {
				System.out.println("error: " + e);
			}
			
		}
	}
	public static void log(String log) {
		System.out.println("[ChatClient] " +  log);
	}
 
}
