import java.util.Map;
import java.util.Stack;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;

public class KeypadOnSafe {
	/*
	 * X 2 3
	 * 4 X 6
	 * 7 8 9
	 * */
	
	public static int numOfPasscodes(int n) {
		Map<Integer,List<Integer>> map = new HashMap<>();
		
		map.put(2, new LinkedList<Integer>());
		map.get(2).add(7);
		map.get(2).add(9);
		
		map.put(3, new LinkedList<Integer>());
		map.get(3).add(4);
		map.get(3).add(8);
		
		map.put(4, new LinkedList<Integer>());
		map.get(4).add(3);
		map.get(4).add(9);
		
		map.put(6, new LinkedList<Integer>());
		map.get(6).add(7);
		
		map.put(7, new LinkedList<Integer>());
		map.get(7).add(2);
		map.get(7).add(6);
		
		map.put(8, new LinkedList<Integer>());
		map.get(8).add(3);
		
		map.put(9, new LinkedList<Integer>());
		map.get(9).add(2);
		map.get(9).add(4);
		
		int count=0;
		
		Stack<String> s = new Stack<>();
		s.push(2+"");
		
		while(!s.isEmpty()) {
			String prevS = s.pop();
			if(prevS.length()==n) {
				count++;
			}
			else {
				int prevI = Integer.parseInt(prevS.substring(prevS.length()-1));
				List<Integer> list = map.get(prevI);
				for(Integer i : list) {
					s.push(prevS+i);
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(numOfPasscodes(5));
		System.out.println(System.currentTimeMillis());
		System.out.println(numOfPasscodes(25));
		System.out.println(System.currentTimeMillis());
	}
}
