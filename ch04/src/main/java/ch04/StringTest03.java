package ch04;

public class StringTest03 {

	public static void main(String[] args) {
		// String s1 = "Hello " + "World" + " Java " + 1.8;
		String s1 = new StringBuffer("Hello ")
			.append("World")
			.append(" Java ")
			.append(1.8)
			.toString();
		
	
		System.out.println(s1);
		
		String s2 = "";
		for(int i = 0; i < 1000000; i++) {
			// s2 = s2 + i;
			// s2 = new StringBuffer(s2).append(i).toString();
		}
		
		StringBuffer sb2 = new StringBuffer("");
		for(int i = 0; i < 1000000; i++) {
			sb2.append(i);
		}
		String s3 = sb2.toString();
		System.out.println(s3.length());
		
		
		//String metho들
		
		String s4= "aBcAbCabcACBC";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.substring(3,5));

		String s5 = "	ab	cd	";
		String s6 = "efg,hij,klm,nop,qrs";
		
		String s7 = s5.concat(s6);
		System.out.println(s7);
		
		System.out.println("-----"+s5.trim()+"------");
		System.out.println("----"+s5.replace(" ",""));
		
		String[] tokens=s6.split(",");
		
		for(String s:tokens) {
			System.out.println(s);
		}
		
		String[] tokens2 = s6.split(" ");
	}

}