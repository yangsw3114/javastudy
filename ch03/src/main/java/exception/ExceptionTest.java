package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a= 10;
		int b=10-a;
		
		System.out.println("some code1....");
		try {
			System.out.println("some code2....");
			int result=(1+2+3)/b; //0으로 나누면 무한대임 divise zero
			System.out.println("some code3....");
			System.out.println("some code4....");
		}
		catch(ArithmeticException e){
			//예외처리
			//1.예외에 대한 사과
			System.out.println("Sorry...");
			//2.로깅
			System.out.println("error: " + e);
			//3. 정상종료
			return;
		}
		finally {
			System.out.println("자원 정리");
		}
		

	}

}
