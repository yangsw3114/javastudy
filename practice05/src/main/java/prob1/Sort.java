package prob1;

import java.util.Arrays;

public class Sort {
	
	public static void main(String[] arg) {
	
		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int tmp;
		System.out.println( "Before sort." );
		
		for (int i = 0; i < array.length; i++) {
			System.out.print( array[ i ] + " " );
		}
		System.out.println("\n");
		//
		// 정렬 알고리즘이 적용된 코드를 여기에 작성합니다.
		
		for(int i=1; i<array.length;i++) {		
			for(int j=0; j<array.length-i; j++) {
				if(array[j]<array[j+1]) {
					tmp=array[j];
					array[j]=array[j+1];
					array[j+1]=tmp;
					System.out.println(Arrays.toString(array));
				}
			}
			System.out.println();
			
		}
		//

		
		// 결과 출력
		System.out.println( "\nAfter Sort." );
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}		
	}
}