package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {
		int number=0;
		int share=0;
		int odd_num=1;
		int sum=0;
		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		System.out.print("숫자를 입력하세요: ");
		number=scanner.nextInt();
		
		if(number%2==1) {
			share=number/2;
			for(int i=0; i<=share; i++) {
				sum= sum+odd_num;
				odd_num+=2;
				
			}
			System.out.println("결과 값: "+sum);
		}
		else if(number%2==0) {
			
		}
		scanner.close();
	}
}
