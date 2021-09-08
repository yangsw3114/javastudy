package ch03;

public class Goods {
	public static int countOfGoods=0;
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods() {
		System.out.println("call!!");
	}
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
	public void showInfo() {
		System.out.println(
				"name:" + name + 
				", price:" + price + 
				", countStock:" + countStock + 
				", countSold:" + countSold);
	}

	public int calcDiscountPrice(int percentage) {
		return price*percentage/100;
	}

}
