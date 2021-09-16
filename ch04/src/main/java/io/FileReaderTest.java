package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class FileReaderTest {
	public static void main(String[] args) {
		FileReader in = null;
		InputStream is = null;
		try {
			in = new FileReader("1234.txt");

			int data = -1;
			while((data=in.read()) != -1) {
				System.out.print((char)data);
			}
			
			is = new FileInputStream("1234.txt"); //filereader와 읽는 방식이 다름 inputstream은 바이트단위처리, filereader는 문자단위로 처리
			while((data = is.read()) != -1) {
				System.out.print((char)data);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found:" + e);
		}
		catch (IOException e) {
			System.out.println("File Not Found:" + e);
		}
		finally {

			try {
				if(in != null) {
				in.close();
				}
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
