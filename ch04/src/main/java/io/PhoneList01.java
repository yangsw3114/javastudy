package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br =null;
		try {
			File file = new File("phone.txt");
			
			if(!file.exists()) {
				System.out.println("file not found");
				return;
			}
			
			System.out.println("================= 파일 정보 ===================");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			
			System.out.println(new SimpleDateFormat("yyyy-MM--dd hh:mm:ss").format(new Date(file.lastModified())));
			
			System.out.println(file.lastModified());
			
			System.out.println("================= 전화번호  ===================");
			//1. 기반 스트림(표준입력, stdin,System,in)
			FileInputStream fis = new FileInputStream(file);
			
			//2. 보조 스트림1(byte|byte|byte -> char)
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			//3. 보조 스트림2(char1|char2|char3|char4|\n -> "char1char2char3char4"
			br = new BufferedReader(isr);
			
			String line = null;
			while((line = br.readLine()) != null) { //br->버퍼드리더에서 받는걸 스트링으로 readline이 받아 출력
				StringTokenizer st = new StringTokenizer(line, "\t");
				
				while(st.hasMoreElements()){
					String token = st.nextToken();
					System.out.print(token + ":");
				}
				System.out.println();
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("error: " + e);
		}
		catch (IOException e) {
			System.out.println("error: " + e);
		}
		finally {
			try {
				if(br != null) {
					br.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
