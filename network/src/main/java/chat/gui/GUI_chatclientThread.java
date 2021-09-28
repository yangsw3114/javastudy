package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class GUI_chatclientThread extends Thread{
	private BufferedReader bufferedReader;
	private PrintWriter printwriter;
	private Socket socket;
	
	public GUI_chatclientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();
		//reader를 통해 읽은 데이터 콘솔에 출력하기 
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			printwriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
			
			while(true) {
				String receive = bufferedReader.readLine();
				
				if(receive == null) {
					System.out.println("값이 없어용");
					break;
				}
				else {
					//System.out.println(receive);
					ChatWindow.textArea.append(receive);
					ChatWindow.textArea.append("\n");

				}
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("error: " + e);
		} catch (IOException e) {
			System.out.println("채팅이 종료되었습니다.");
		}finally {
			try {
				if(socket != null && socket.isClosed() ==false) 
				{ 
					socket.close();
				}
			} catch (IOException e) {
				System.out.println("error: " + e);
			}
		}
	}
}
