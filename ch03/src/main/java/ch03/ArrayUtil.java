package ch03;
import java.util.*;
import java.util.stream.IntStream;
public class ArrayUtil {
	
	public static double[] intToDouble(int[] source) {
		double[] double_source = intToDouble(source);
		return double_source;
	}
	
	public static int[] doubleToInt(double[] source) {
		int[] int_source=doubleToInt(source);
		return int_source;
	}
	
	public static int[] concat(int[] s1, int[] s2) {
		
		int[] concate = IntStream.concat(IntStream.of(s1), IntStream.of(s2)).toArray();
		return concate;
	}

}
