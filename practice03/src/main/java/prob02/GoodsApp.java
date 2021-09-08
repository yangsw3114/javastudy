package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		String[] arr = new String[3];
		System.out.println("상품 3가지를 입력하세요: ");

		// 상품 입력
		for(int i=0; i<3; i++) {
			String input = scanner.nextLine();
			arr = input.split(" ");
			
			goods[i]=new Goods();
			goods[i].setName(arr[0]);
			goods[i].setPrice(Integer.parseInt(arr[1]));
			goods[i].setCountStock(Integer.parseInt(arr[2]));
		}
		
		
		
		// 상품 출
		for(int j=0; j<3; j++) {
			System.out.println(goods[j].getName()+"(가격:"+goods[j].getPrice()+"원)이 "+goods[j].getCountStock()+"개 입고 되었습니다.");			
		}
		// 자원정리
		scanner.close();
	}
}
