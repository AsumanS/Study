import java.util.LinkedList;
import java.util.List;

public class GenerateAllSubsets {
	public String[] generateAllSubsets(String s) {
		List<String> list = new LinkedList<>();
		genSubsets(s , "", 0, list);
		String[] result = new String[list.size()];
		int i=0;
		for(String str : list)
			result[i++]=str;
		return result;		
	}
	
	public void genSubsets(String str, String suffix, int i, List<String> list) {
		if(i==str.length()) {
			list.add(suffix);
			return;
		}
		genSubsets(str, suffix, i+1, list);
		genSubsets(str, suffix+str.charAt(i),  i+1, list);

	}
	
	public static void main(String[] args) {
		GenerateAllSubsets genSet = new GenerateAllSubsets();
		String[] result = genSet.generateAllSubsets("asu");
		for(String s: result)
			System.out.println(s);
	}
	
}
