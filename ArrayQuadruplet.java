	import java.io.*;
	import java.util.*;
	
public class ArrayQuadruplet {
  
	  public static int[] findArrayQuadruplet(int[] arr, int s) {
	    int[] result = new int[4]; 
	    if(arr==null || arr.length<4) 
	       return result;
	    
	    Arrays.sort(arr);
	    
	    for(int i=0;i<arr.length-3;i++){
	      for(int j = i+1;j<arr.length-2;j++){
	       
	    	int rem = s-(arr[i]+arr[j]);
	    	int third = 0; 
	        int fourth = 0; 
	        boolean found = false;
	        
	        HashSet<Integer> set = new HashSet<>();
	        for(int k=j+1;k<arr.length;k++){
	           if(set.contains(rem-arr[k])){ 
	             third=rem-arr[k];
	             fourth=arr[k]; 
	             found=true;
	             break;
	           }
	           else 
	        	 set.add(arr[k]); 
	        }
	        
	        if(found){ //This is ook
	          result[0]=arr[i];
	          result[1]=arr[j];
	          result[2]=third;  //third and fourth do not garantee order
	          result[3]=fourth;
	          return result;
	        }
	        
	      }
	    }
	   return null; 
	  }

	  public static void main(String[] args) {
	      int[] arr = {4,4,4,2};
	      int[] result = findArrayQuadruplet(arr, 16);
	    
	    System.out.println(Arrays.toString(result));
	  }

	}


	//ANSWER
	/*

	function findArrayQuadruplet(arr, s):
	    n = arr.length

	    # if there are fewer than 4 items in arr, by
	    # definition no quadruplet exists whose sum is s
	    if (n < 4):
	        return []

	    # sort arr in an ascending order
	    arr.sort()

	    for i from 0 to n - 4:
	        for j from i + 1 to n - 3:
	            # r stores the complementing sum
	            r = s - (arr[i] + arr[j])

	            # check for sum r in subarray arr[j+1…n-1]
	            low = j + 1, high = n - 1;

	            while (low < high):
	                if (arr[low] + arr[high] < r):
	                    low++

	                else if (arr[low] + arr[high] > r):
	                    high--

	                # quadruplet with given sum found
	                else:
	                    return [arr[i], arr[j], arr[low], arr[high]]

	    return []
	*/


