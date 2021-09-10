package prob04;

public class StringUtilTest {

	public static void main(String[] args) {
		StringUtil SU = new StringUtil();
        String[] strArr = {"SuperMan", "BatMan", "SpiderMan"}; 
        String resultStr = SU.concatenate( strArr );

        
        System.out.println( "결과 문자열 : " + resultStr ); 
	}

}
