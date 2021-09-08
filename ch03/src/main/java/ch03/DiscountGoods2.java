package ch03;

import mypkg.Goods2;

public class DiscountGoods2 extends Goods2 {
	private float discountRate = 0.5f;
	public float getDiscountPrice() {
		return discountRate*price; //protected는 자식에서 접근할수있다.
	}
}
