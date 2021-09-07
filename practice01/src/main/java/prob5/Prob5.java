package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		for(int i=1; i<100; i++) {
			int ten=i/10;
			int num=i%10;
			int count=0;
			
			if(ten==3||ten==6||ten==9) 
				count++;
			if(num==3||num==6||num==9) 
				count++;
			if(count!=0) {
				System.out.print(i+" ");
				for(int j=0; j<count; j++) {
					System.out.print("짝");
				}
				System.out.println();
			}
			

	}
	}
}
