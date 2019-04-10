import java.util.LinkedList;
import java.util.List;

public class PalindromicDecompositionOfString {

	public String[] palindromicDecomposition(String s) {
		List<String> list = palDec(s);
		String[] result = new String[list.size()];
		int i=0;
		for(String str : list)
			result[i++]=str;
		return result;
	}
	
	public List<String> palDec(String s) {
		List<String> result = new LinkedList<>();
		if(s.length()==1) {
			result.add(s);
			return result;
		}
		for(int i=1;i<=s.length();i++) {
			String iter=s.substring(0, i);
			if(isPal(iter)) {
				List<String> prev = palDec(s.substring(i));
				if(prev.size()==0)
					result.add(iter);
				for(String str : prev) {
					result.add(iter+"|"+str);
				}
			}	
		}
		return result;
	}

	public boolean isPal(String s) {
		if(s.length()==1)
			return true;
		if(s.length()==2 && s.charAt(0)==s.charAt(1))
			return true;
		if(s.charAt(0)==s.charAt(s.length()-1))
			return isPal(s.substring(1, s.length()-1));
		else 
			return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromicDecompositionOfString pds = new PalindromicDecompositionOfString();
		String[] result = pds.palindromicDecomposition("aa");
		for(String s : result)
			System.out.println(s);
	}

}
