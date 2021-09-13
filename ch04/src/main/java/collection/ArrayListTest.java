package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		
		list.add("둘리");
		list.add("마이콜");
		list.add("도우너");
		
		for(int i=0; i<list.size(); i++) {
			String s = list.get(i);
		}
		
		//삭제
		list.remove(2);
		
		//순회2
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		//순회3
		for(String s:list) {
			System.out.println(s);
		}
	}

}
