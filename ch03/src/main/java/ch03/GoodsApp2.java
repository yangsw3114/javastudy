package ch03;

import mypkg.Goods2;

public class GoodsApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods2 g = new Goods2();
		g.name = "camera"; // public 접근제한이 없다.
		
		//g.price=1000; //protected는 같은 패키지에서 접근이 가능하다 and 자식에서도 접근이 가능하다
		
		//g.countStock=10; //디폴트 ㅡ 같은 패키지에서만 접근 가능
		
		//g.countSold=10; private은 같은 클래스에서만 접근이 가능하다.
	}

}
