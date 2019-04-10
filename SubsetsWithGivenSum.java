
public class SubsetsWithGivenSum {
	public void printSubsetsWithSum(int[] a, int sum) {
		int[] subsets = new int[a.length];
		printSWS(a, 0, subsets, 0, sum);
	}
	public void printSWS(int[] a, int i, int[] subsets, int j, int sum){
		if(sum==0) {
			print(subsets,j);
			return;
		}
		if(i==a.length) {
			//print(subsets,j);
			return;
		}
		printSWS(a, i+1, subsets, j, sum);
		subsets[j]=a[i];
		printSWS(a, i+1, subsets, j+1, sum-a[i]);
	}
	public void print(int[] s,int j) {
		System.out.print("{");
		for(int i=0;i<j;i++)
			System.out.print(s[i]+",");
		System.out.println("}");
	}
	public static void main(String[] args) {
		SubsetsWithGivenSum swgs = new SubsetsWithGivenSum();
		swgs.printSubsetsWithSum(new int[] {1,2,3,4,5,6,7,8,9},10);
	}
}
