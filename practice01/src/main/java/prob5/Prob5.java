package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		for(int i=1; i<100; i++) {
			if((i/10)%3==0) {
				
				System.out.print(i+" 짝a");
				if((i%10)%3==0) {
					System.out.println("짝");
			}
			}
			else{
				if((i%10)%3==0) {
					System.out.println(i+" 짝");
				}
			}

		}
	}
}
