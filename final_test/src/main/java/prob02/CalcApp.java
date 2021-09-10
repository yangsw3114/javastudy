package prob02;
import java.util.*;
public class CalcApp {

	public static void main(String[] args) {
		Add plus = new Add();
		Div div = new Div();
		Mul mul = new Mul();
		Sub minus = new Sub();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하시오 >> ");
		
		String input = sc.nextLine();
		String[] sp = input.split(" ");
		
		int front = Integer.parseInt(sp[0]);
		int back = Integer.parseInt(sp[1]);
		
		int value = 0;
		switch(sp[2]) {
		case "+":
			value = plus.calculate(front, back);
			break;
		case "-":
			value = minus.calculate(front, back);
			break;
		case "/":
			value = div.calculate(front, back);
			break;
		case "*":
			value = mul.calculate(front, back);
			break;
			
		default:
			System.out.println("연산자 재입력");
			break;
		}
		
		
		System.out.println(value);
		sc.close();
	}

}
