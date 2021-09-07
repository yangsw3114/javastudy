package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		char[] arr = str.toCharArray();
		char[] reverse = new char[arr.length];
		for(int i=0; i<arr.length; i++) {
			reverse[arr.length-1-i]=arr[i];
		}

		return reverse;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		String reverseStr= new String(array);
		System.out.println( array );
	}
}