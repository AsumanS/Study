import java.util.Stack;
import java.util.List;
import java.util.LinkedList;

public class GenerateExpressionsWithGivenTarget {
	public String[] generateAllExpressions(String s, long target) {
		List<String> list = new LinkedList<>();
		printAllExp(s, 1, target, ""+s.charAt(0), list);
		String[] result = new String[list.size()];
		int i=0;
		for(String str : list)
			result[i++]=str;
		return result;
	}
	public void printAllExp(String s, int i, long target, String exp, List<String> list) {
		long sum = calculateSum(exp);
		if(sum==target && i==s.length()) {
			list.add(exp);
			return;
		}
		if(sum>target || i>s.length()-1)
			return;
		
		printAllExp(s, i+1, target, exp+"+"+s.charAt(i), list);
		printAllExp(s, i+1, target, exp+"*"+s.charAt(i), list);
		printAllExp(s, i+1, target, exp+s.charAt(i),list);
		
		
	}
	public long calculateSum(String exp) {
		Stack<Long> s =new Stack<>();
		long num=0;
		int i=0;
		while(i<exp.length()) {
			char c = exp.charAt(i);
			if(c=='+') {
				s.push(num);
				num=0;
				i++;
			}
			else if(c=='*') {
				i++;
				long next=0;
				while(i<exp.length() && exp.charAt(i)!='+' && exp.charAt(i)!='*') {
					next=next*10+Character.getNumericValue(exp.charAt(i));
					i++;
				}
				num*=next;
			}
			else {
				num*=10;
				num+=Character.getNumericValue(c);
				i++;
			}
			
		}
		
		while(!s.isEmpty()) {
			num+=s.pop();
		}
		return num;				
	}

	public static void main(String[] args) {
		GenerateExpressionsWithGivenTarget gen = new GenerateExpressionsWithGivenTarget();
		String[] result = gen.generateAllExpressions("050505", 5);
		for(String s:result)
			System.out.println(s);
	}
}
