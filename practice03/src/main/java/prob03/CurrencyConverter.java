package prob03;

public class CurrencyConverter {
	private static double rate;
	
	public static double toDollar(double won) {
		won=won/rate;
		return won;
		//한국 원화를 달러로 변환
	}
	public static double toKRW(double dollar) {
		dollar=dollar*rate;
		return dollar;
		//달러를 한국 원화로 변환
	}
	public static void setRate(double r) {
		//환율 설정(KRW/$)
		rate=r;
	}
}
