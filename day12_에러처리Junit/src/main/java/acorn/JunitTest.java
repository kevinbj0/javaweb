package acorn;

import java.util.ArrayList;

public class JunitTest {

	public int add(int a, int b) {
		return a + b;
	}
	public int sub(int a, int b) {
		return a - b;
	}
	public int mul(int a, int b) {
		return a * b;
	}
	public int div(int a, int b) {
		return a/b;
	}
	
	public ArrayList<Integer> measure(int a) {
		ArrayList<Integer>  list = new ArrayList<>();
		for(int i = 1; i<(a/2+1); i++) {
			if(a%i == 0) {
				list.add(i);
			}
		}
		list.add(a);
		System.out.println(list);
		
		return list;
	}

	public static void main(String[] args) {
		JunitTest test = new JunitTest();
		int add = test.add(5, 3);
		int sub = test.sub(5, 3);
		int mul = test.mul(5, 3);
		int div = test.div(5, 3);

		test.measure(13);
		
		System.out.println(test.add(5, 3));
	}
}
