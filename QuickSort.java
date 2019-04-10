
public class QuickSort {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void quickSort(int[] arr, int start, int end) {
		if(start>end)
			return;
		
		int pivot = arr[end];
		
		int low = start-1;
		
		for(int high=start;high<end;high++) {
			if(arr[high]<pivot) {
				low++;
				swap(arr,low,high);
			}
		}
		swap(arr, low+1, end);
		
		quickSort(arr, start,low);
		quickSort(arr, low+2,end);
		
	}
	
	public static void main(String[] args) {
		int[] arr = {4,7,2,8,9,1,3,5,6};
		quickSort(arr,0,8);
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
	
}
