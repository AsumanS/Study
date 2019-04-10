import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    /*
     * Complete the mergeArrays function below.
     */
    public int[] mergeArrays(int[][] arr) {
        /*
         * Write your code here.
         */
        if(arr==null || arr[0]==null)
            return new int[]{};
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        if(arr[0][0]>arr[0][1]) {
            heap = new PriorityQueue<>(arr[0].length, new Comparator<Integer>(){
                @Override
                public int compare(Integer a, Integer b){
                    return b-a;
                }
            } );
        }

        Map<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i][0], new int[]{i,0});
            heap.offer(arr[i][0]);
        }
        
        int[]result = new int[arr.length*arr[0].length];
        for(int i=0;i<result.length;i++){
            int element=heap.poll();
            result[i]=element;
            int[] rc = map.get(element);
            map.remove(element);
            rc[1]++;
            if(rc[1]<arr[0].length){
                int newElement = arr[rc[0]][rc[1]];
                map.put(newElement, rc);
                heap.offer(newElement);
            }
        }
        
        return result;
        
    }

    public static void main(String[] args) {
    	MergeKSortedArrays mksa = new MergeKSortedArrays();
    	int[][] input = {{25,17,3},{16,12,5},{48,35,13}};
    	int[] result = mksa.mergeArrays(input);
    	for(int i:result)
    		System.out.print(i+" ");
    }

}
