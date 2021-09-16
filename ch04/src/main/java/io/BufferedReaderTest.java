package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("./src/main/java/io/BufferedReaderTest.java");//기반 스트림
			
			br = new BufferedReader(fr);  //보조스트림
			
			int index = 0;
			String line=null;
			while((line = br.readLine())!=null) { //readeline()은 BufferedReader만 할수있다.
				index++;
				System.out.print(index+" : ");
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + e);
		}
		catch (IOException e) {
			System.out.println("File Not Found: " + e);
		}
		finally {
			try {
				if(br!=null) {
					br.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
