
public class LongestCommonSubString {
	   public static int LCSubStr(String x, String y){  
	    
	        // Create a table to store lengths of longest common suffixes of 
	        // substrings. Note that LCSuff[i][j] contains length of longest 
	        // common suffix of X[0..i-1] and Y[0..j-1]. The first row and 
	        // first column entries have no logical meaning, they are used only 
	        // for simplicity of program 
		    int m = x.length();
		    int n = y.length();
		    
		    char[] X=x.toCharArray();
		    char[] Y=y.toCharArray();
		    
	        int LCStuff[][] = new int[m + 1][n + 1]; 
	        int result = 0;  // To store length of the longest common substring 
	          
	        // Following steps build LCSuff[m+1][n+1] in bottom up fashion 
	        for (int i = 0; i <= m; i++)  
	        { 
	            for (int j = 0; j <= n; j++)  
	            { 
	                if (i == 0 || j == 0) 
	                    LCStuff[i][j] = 0; 
	                else if (X[i - 1] == Y[j - 1]) 
	                { 
	                    LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1; 
	                    result = Integer.max(result, LCStuff[i][j]); 
	                }  
	                else
	                    LCStuff[i][j] = 0; 
	            } 
	        } 
	        return result; 
	    }
	   
	   public static void main(String[] args) {
		   System.out.println(LCSubStr("9874abcd9088","23abcd43549"));
	   }
}
