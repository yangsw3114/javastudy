package prob01;
import java.lang.*;
import java.util.*;

public class gugudan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		int[] arr = new int[9];
		int front = r.nextInt(9)+1;
		int back = r.nextInt(9)+1;
		int correct = front*back;
		int input=0;
		
		System.out.println(front + " X " + back + " = ? \n");
		
		for(int i=0; i<9; i++) {
			arr[i]=front*back;
			
			front = r.nextInt(9)+1;
			back = r.nextInt(9)+1;
		}
		shuffle(arr);
		
		int count=0;
		for(int s:arr) {// 랜덤값을 3 x 3 형태로 출력
			System.out.print(s+"\t");
			count++;
			if(count%3==0) {
				System.out.println();
			}
		}
		
		System.out.print("answer: ");
		input=sc.nextInt();
		
		String what = (input==correct) ? "정답" : "오답";
		System.out.println(what);
	}
	
	public static int[] shuffle(int[] arr) {
		int r1, r2;
		int tmp;
		for (int i = 0; i < arr.length; i++) {
			//for문이 돌아갈때마다 바뀌는 난수 r1, r2생성
			r1 = (int) (Math.random()*arr.length);
			r2 = (int) (Math.random()*arr.length);
			//변수에 배열 r1번의 값을 담기 -> swap용
			tmp = arr[r1];
			//r1번째 값을 r2번째 값으로 바꿔주기
			arr[r1] = arr[r2];
			//r2번째 값에 swap용변수(r1)번 값 담아주기 
			arr[r2] = tmp;
		}
		return arr;
		
	}
}
