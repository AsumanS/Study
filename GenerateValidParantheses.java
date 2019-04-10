import java.util.ArrayList;

public class GenerateValidParantheses {
    public static String[] find_all_well_formed_brackets(int n) {
    	ArrayList<String> list = findAll(n);
        String[] result = new String[n];
        int i=0;
        for(String s : list)
            result[i++]=s;
        return result;
    }
    public static ArrayList<String> findAll(int n){
    	ArrayList<String> result = new ArrayList<>();
        if(n==0)
            return result;
        if(n==1)
            result.add("()");
        else{
        	ArrayList<String> prev = findAll(n-1);
            if(n==2){
            	 result.add("("+prev.get(0)+")");
            	 result.add(prev.get(0)+"()");
            }
            else{
                for(int i=0;i<prev.size();i++){
                	String s = prev.get(i);
                	result.add("("+s+")");
                	result.add(s+"()");
                    if(!result.contains("()"+s))
                    	result.add("()"+s);
                }
            }
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> result = findAll(3);
		for(String s:result)
			System.out.println(s);
	}

}
