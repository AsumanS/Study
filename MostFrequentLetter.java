
public class MostFrequentLetter {
	public static String characterMode(String string) {

        int count[] = new int[26];
        int len = string.length();
        int maxCount = 0;
        
        for (int i=0; i<len; i++){
        	int ind = string.charAt(i)-97;
            count[ind]++;     
            if(count[ind]>maxCount)
            	maxCount=count[ind];
        }

        
        String str = new String();
        
        for(int i = 0;i<26;i++){
        	if(count[i]==maxCount){
        		str+=(char)(i+97);
        	}
        }
        return str;
    }


    public static void main(String args[]) {

    	String s = "hellonn";
    	System.out.println(characterMode(s));

    }

}

