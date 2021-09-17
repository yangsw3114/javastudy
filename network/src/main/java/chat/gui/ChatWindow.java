package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import chat.ChatClient;
import chat.ChatClientThread;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		/**
		 * 1. UI 초기화
		 */
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		/**
		 * 2. IOStream 가져오기 
		 */
		
		/**
		 * 3. Chat Client Thread 생성
		 * 
		 */
		
	}
	
	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메세지 보내는 프로토콜 구현:" + message);
		textField.setText("");
		textField.requestFocus();
		
		// Receive Thread 에서 서버로 부터 받은 메세지가 있다고 치고~(가짜데이터)
		updateTextArea("마이콜:" + message);
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private void finish() {
		System.out.println("소켓 닫기 or 방나가기 프로토콜 구현!");
		System.exit(0);
	}
	
	public class ChatClientThread extends Thread{
		private BufferedReader bufferedReader;
		private PrintWriter printwriter;
		private Socket socket;
		
		public ChatClientThread(Socket socket) {
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
						ChatClient.log("입력된 값이 없거나 잘못된 입력값......");
						break;
					}
					else {
						updateTextArea(receive);
						//System.out.println(receive);

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
}