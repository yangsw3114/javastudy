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
			socket.connect(new InetSocketAddress("0.0.0.0", 6000)); //IP와 포트 입력
			ChatServer.log("connected");
			
			BufferedReader BR = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter PW = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
			
			PW.println("Join: "+ nickname);
			PW.flush();
			
			new ChatClientThread().start(); //스레드 시작
			
			while(true) {
				System.out.print(">> ");
				String input = sc.nextLine();
				
				if("quit".equals(input)==true) {
					//Quit프로토콜 처리
					break;
				}
				else {
					
				}
				
			}
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			ChatServer.log("error " +e);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
 
}
