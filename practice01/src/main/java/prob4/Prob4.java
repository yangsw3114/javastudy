package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		int leng=0;
		char[] arr=text.toCharArray();
		leng=text.length();
		
		for(int j=0; j<leng; j++) {
			for(int i=0; i<=j; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}


		
		
		scanner.close();
	}

}
