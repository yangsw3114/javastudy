package collection;
import java.util.*;


public class VectorTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new Vector<>();
		
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
		
	}

}
