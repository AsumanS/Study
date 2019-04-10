
public class MergeSort2 {
	
	public static int[] merge(int[]a, int[]b) {
		int[] result = new int[a.length+b.length];
		int i = 0;
		int j = 0;
		for(int ind=0;ind<result.length;ind++) {
			if(i==a.length)
				result[ind] = b[j++];
			else if(j==b.length)
				result[ind] = a[i++];
			else if(a[i]<=b[j])
				result[ind]=a[i++];
			else
				result[ind]=b[j++];
		}
		return result;
	}
	
	public static void mergeSort(int[] arr, int start, int end) {
		if(start>=end || arr.length==1)
			return;
		
		int mid = (end+start)/2;
		
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		
	}
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = ms.mergeSort(new int[] {4,7,2,3,9,1,0});
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
	
}
