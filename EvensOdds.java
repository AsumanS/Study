
public class EvensOdds {

    static int[] solve(int[] arr) {
        if(arr==null ||arr.length==0)
            return arr;
        int i=0;
        int j=arr.length-1;
        while(i<j){
            while(i<arr.length && arr[i]%2==0) i++;
            while(j>=0 && arr[j]%2==1) j--;
            if(i<j) 
            	swap(arr,i,j);
        }
        return arr;
    }
    static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
    	EvensOdds eo = new EvensOdds();
    	int[] result = eo.solve(new int[]{4,6,8,2,0});
    	for(int i:result)
    		System.out.println(i+" ");
    }
}
