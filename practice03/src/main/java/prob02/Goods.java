package prob02;

public class Goods {
	private String name;
	private int price;
	private int CountStock;
	
	public Goods() {

	}
	
	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCountStock() {
		return CountStock;
	}
	public void setCountStock(int countStock) {
		CountStock = countStock;
	}
}
