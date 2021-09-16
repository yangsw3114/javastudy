package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {
	private static final String Server_IP = "127.0.0.1";
	private static final int Server_PORT = 5000;
	public static void main(String[] args) {
		//1. 소켓 생성
		Socket sk = new Socket();
		try {

			//2. 서버 연결
			sk.connect(new InetSocketAddress(Server_IP,Server_PORT));
			
			//3. IO스트림 받아오기
			 InputStream is = sk.getInputStream();
			 OutputStream os = sk.getOutputStream();
			 
			 //4. 쓰기
			 String data = "hello world";
			 os.write(data.getBytes("utf-8"));
			 

			 //5. 데이터 읽기
			 byte[] buffer = new byte[256];
			 int readByteCount = is.read(buffer); //blocking
			 if(readByteCount == -1) {
				 // 클라이언트가 정상적으로 종료(close() 호출)
				 System.out.println("[client] closed by server");

			 } 
			 
			 data = new String(buffer, 0, readByteCount, "utf-8");
			 System.out.println("[cleint] received: "+data);

				 
		}
		catch (SocketException e) {
			System.out.println("[client] suddenly closed by server");
		}
		catch (IOException e) {
			System.out.println("[client] error: " + e);
		}
		finally
		{
			 try {
				 if(sk != null && sk.isClosed() == false)
					 sk.close();
				 
			 }catch(IOException e) {
				 e.printStackTrace();
			 }
		}
	}

}
