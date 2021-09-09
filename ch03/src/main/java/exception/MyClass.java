package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException {
		System.out.println("some code1...");
		System.out.println("some code2...");
		
		
		
		if(10-10==0) {
			throw new IOException();
		}
		System.out.println("some code3...");
		System.out.println("some code4...");
		System.out.println("some code5...");
		
	}
}
