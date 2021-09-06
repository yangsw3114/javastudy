package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
		int count=0;
		int a=0;
		while(true) {
			a+=1;
			for(int i=0; i<10; i++) {
				System.out.print((a+i)+" ");
			}
			System.out.println();
			if(a==5) {
				break;
			}
		}
	}
}
