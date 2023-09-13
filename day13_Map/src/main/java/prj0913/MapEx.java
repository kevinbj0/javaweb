package prj0913;

import java.util.ArrayList;
import java.util.HashMap;

public class MapEx {
	public static void main(String[] args) {
		//Map
		//키, value의 형태로 데이터를 저장
		HashMap<String, String> map = new HashMap<>();
		
		map.put("key1", "apple");
		map.put("key2", "banana");
		map.put("key3", "mango");

		String result = map.get("key1");
		String result2 = map.get("key2");
		String result3 = map.get("key3");
		
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
		
		//ArrayList Map 활용
		HashMap<String, ArrayList<String>> map2 = new HashMap<>();
		
		ArrayList<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("mango");
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("아메리카노");
		list2.add("라떼");
		list2.add("바닐라라떼");

		map2.put("fruit", list);
		map2.put("beverage", list2);
		
		ArrayList<String> resultList1 = map2.get("fruit");
		ArrayList<String> resultList2 = map2.get("beverage");
		
		System.out.println(resultList1);
		System.out.println(resultList2);
	}
}
