package ch03;

import java.util.Arrays;

public class ArrayUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {10, 20, 30, 40};
		
		double[] arr2 = ArrayUtil.intToDouble(arr1);
		System.out.println("aar2: "+arr2.toString());
		int[] arr3 = ArrayUtil.doubleToInt(arr2);
		System.out.println("aar3: "+arr3.toString());
		
		System.out.println(Arrays.toString(arr1));
	}

}
