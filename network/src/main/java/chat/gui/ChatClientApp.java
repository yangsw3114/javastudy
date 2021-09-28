package chat.gui;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;


public class ChatClientApp {
	public static void main(String[] args) {
		String chat_name = null;
		String nickname = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket =null;
		
		while( true ) {
			System.out.println("채팅방의 이름을 정해주세요.");
			System.out.print(">> ");
			chat_name = scanner.nextLine();
			
			if (chat_name.isEmpty() == false ) {
				break;
			}
			System.out.println("채팅방의 이름은 한글자 이상 입력해야 합니다.\n");
		}
		
		
		

		try {
			System.out.print("닉네임>> ");
			nickname = scanner.nextLine();
			
			//1. create socket
			socket = new Socket();
			
			//2. connect to server
			socket.connect(new InetSocketAddress("127.0.0.1", 6000));
			
			//3. get iostream
			//BufferedReader BR = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter PW = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
			//4. join
			nickname = "join:"+ nickname;
			PW.println(nickname); // system.out.println과 동일하게 출력을 해주는 메서드이며
			PW.flush();						// 현재 버퍼에 저장되어 있는 내용을 클라이언트나 서버로 전송하고 버퍼를 지운다.
			//   String line = br.readLine();
			
		} catch (IOException e) {
			System.out.println("error: " + e);
		}
		finally {
			scanner.close();
		}

		String line = "JOIN:OK";
		if("JOIN:OK".equals(line)) {
			new ChatWindow(chat_name, socket).show();
		}
	}

}
