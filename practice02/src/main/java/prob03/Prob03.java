package prob03;

import java.util.Arrays;

public class Prob03 {
	public static String str;
	public static void main(String args[]) {
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };
		str=String.valueOf(c);
		
		// 원래 배열 원소 출력
		printCharArray(c);

		// 공백 문자 바꾸기
		replaceSpace(c);

		// 수정된 배열 원소 출력
		printCharArray(c);
		
	}
	public static void printCharArray(char a[]) {
		System.out.println(str);
	}
	public static void replaceSpace(char a[]) {
		str = str.replace(" ", ",");
		System.out.println(str);
	}

}
