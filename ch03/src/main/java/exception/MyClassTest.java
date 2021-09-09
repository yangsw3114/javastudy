package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		MyClass MC = new MyClass();
		try {
			MC.danger();
		} catch (IOException e) {
			System.out.println("error: " + e);
		}
	}

}
