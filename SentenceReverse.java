import java.util.Arrays;

public class SentenceReverse {

	static void reverse(char[] arr, int start, int end){
		    while(start<end){
		      char temp = arr[start];
		      arr[start] = arr[end];
		      arr[end]=temp;
		      start++;
		      end--;
		    }
		    return ;
		  }
		  
		  static char[] reverseWords(char[] arr) {
		    // your code goes here
		    //hello world
		    reverse(arr, 0, arr.length-1);
		    //dlrow olleh
		    int start=0;
		    while(start<arr.length){
		      int end=start;
		      if(arr[start]!=' '){
		        while(end<arr.length && arr[end]!=' ')
		          end++;
		        reverse(arr, start, end-1);
		        start=end+1;
		      }
		      else
		        start++;
		    }
		    
		    return arr;
		  }

	
	
	public static void main(String[] args) {
		char[] arr = {'p','e','r','f','e','c','t',' ','m','a','k','e','s',' ','p','r','a','c','t','i','c','e'};
		reverseWords(arr);
		System.out.println(Arrays.toString(arr));

	}

}
