package ch04;

public class WrapperClassTest02 {
	public static void main(String[] args) {
		String s1 = "123456";
		int i = Integer.parseInt(s1);
		
		//cf1 반대로
		String s2 = String.valueOf(i);
		//cf2 반대로
		String s3 = ""+i;
		
		System.out.println(s1+":"+s2+":"+s3);
		
		char c = 'A';
		int a = Character.getNumericValue('A');
		System.out.println((int)c);
		
		String s4 = Integer.toBinaryString(15);
		System.out.println(s4);
		
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
	}
}
