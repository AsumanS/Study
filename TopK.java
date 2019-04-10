import java.util.PriorityQueue;

public class TopK {

    /*
     * Complete the function below.
     */
    static int[] topK(int[] arr, int k) {
        if(arr==null ||arr.length==0 || k<=0)
            return new int[]{};
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int i=0;
        while(i<arr.length && heap.size()<k){
            if(!heap.contains(arr[i]))
                heap.offer(arr[i]);
                i++;
        }
        while(i<arr.length){
            if(!heap.contains(arr[i])){
                heap.offer(arr[i]);
                heap.poll();
            }
            i++;
        }
        int len = Math.min(k,heap.size());
        int[] result = new int[len];
        for(int j=0;j<len;j++)
            result[j]=heap.poll();
        
        return result;    
            
    }
    
    public static void main(String[] args) {
    	TopK tk = new TopK();
    	int[] result = tk.topK(new int[] {1,4,7,9,2,9,6,2,0,8,4},15);
    	for(int i:result)
    		System.out.println(i+" ");
    }

}
