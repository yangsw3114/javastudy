package ch03;

public class GoodsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods goods = new Goods();
		goods.setName("Nikon");
		goods.setPrice(2000);
		goods.setCountStock(10);
		goods.setCountSold(20);
		goods.showInfo();
		int discountPrice=goods.calcDiscountPrice(50);
		System.out.println(discountPrice);
		
		System.out.println(Goods.countOfGoods);
	}

}
