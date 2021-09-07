package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		int count=1;
		int input=0;

		
		while( true ) {
			
			/* 게임 작성 */
			int row=1;
			int high=100;
			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			System.out.println(correctNumber);
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			////
			while(input!=correctNumber) {
				System.out.println(row+" - "+high);
				System.out.print(count+">>");
				input=scanner.nextInt();
				count++;
				if(input>correctNumber) {
					System.out.println("더 낮게");
					high=input;
				}
				else if(input<correctNumber) {
					System.out.println("더 높게");
					row=input;
				}
				else if(input==correctNumber) {
					System.out.println("맞았습니다.");

				}
			}
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
			else {
				count=1;
			}

		}
	}

}