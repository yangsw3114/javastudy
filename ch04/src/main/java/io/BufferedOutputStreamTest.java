package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("test.txt");//기반 스트림
			bos = new BufferedOutputStream(fos); //보조 스트림
			
			for(int i=97; i<=122; i++) {
				bos.write(i);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Can't Open: "+e);
		}catch(IOException e){
			System.out.println("error:"+e);
		}
		finally {
			if(bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
