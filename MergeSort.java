
public class MergeSort {

	public int[] merge(int[] a, int[] b) {
		if(a==null ||a.length==0) return b;
		if(b==null ||b.length==0) return a;
			
		int[] result = new int[a.length+b.length];
		int r=0;
		int i=0;
		int j=0;
		
		while(i<a.length || j<b.length) {
			if(i>=a.length)
				result[r++]=b[j++];
			else if(j>=b.length)
				result[r++]=a[i++];
			else if(a[i]<=b[j])
				result[r++]=a[i++];
			else result[r++]=b[j++];				
		}
		
		return result;
	}
	
	public int[] mergeSort(int[]arr) {
		if(arr==null ||arr.length<=1)
			return arr;
		
		int mid=arr.length/2;
		
		int[] left = new int[mid];
		for(int i=0;i<mid;i++) {
			left[i]=arr[i];
		}
		int[] right = new int[arr.length-mid];
		for(int i=mid;i<arr.length;i++) {
			right[i-mid]=arr[i];
		}
	    
		left = mergeSort(left);
	    right = mergeSort(right);
		
		return merge(left,right);
		
 	}

	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = ms.mergeSort(new int[] {4,7,2,3,9,1,0});
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
	
}
