
public class PossibleToAchieveTargetSum {
    public static boolean findSum(long[] arr, int i, long sum, long target){
    	if(sum==target)
            return true;
        if(i>=arr.length)
            return false;
        return findSum(arr, i+1, sum, target)||findSum(arr, i+1, sum+arr[i], target);
    }
    public static void main(String[] args) {
    	System.out.println(findSum(new long[]{3,-4,-2,4,-1,-4,3,3,2,-4,1,4,0,-1,4,2,1,2}, 1, 3, -14)); 
    	//System.out.println(findSum(new long[]{1,1}, 1, 1, 0)); 
    }
}
