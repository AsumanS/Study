
public class MergeTwoSortedArraysRecursively {
	
	public int[] merge(int[] a, int[] b) {
		int sa=0;
		int sb=0;
		
		int[] result = new int[a.length+b.length];
		
		return mergeHelper(a, b, sa, sb, result);
	}
	
	public int[] mergeHelper(int[] a, int[] b, int sa, int sb, int[] result) {
		//if one of the arrays is exhausted, copy the remaining part of the other array to the result
		if(a.length==0 || sa==a.length) {
			for(int i=b.length-1, ind = result.length-1 ; i>=sb; i--, ind--) {
				result[ind]=b[i];
			}
			return result;
		}
		if(b.length==0 || sb==b.length) {
			for(int i=a.length-1, ind = result.length-1 ; i>=sa; i--, ind--) {
				result[ind]=a[i];
			}
			return result;
		}
		//if both arrays still has elements, compare them and keep the smallest
		int small;
		if(a[sa]<=b[sb]) {
			small=a[sa];
			sa++;
		}
		else {
			small=b[sb];
			sb++;
		}
		result = mergeHelper(a, b, sa, sb, result);
		result[sa+sb-1]=small;
		
		return result;
		
		
	}
	
	public static void main(String[] args) {
		MergeTwoSortedArraysRecursively mr = new MergeTwoSortedArraysRecursively();	
		int[] result = mr.merge(new int[] {1, 4, 7}, new int[] {2,3,6,9});
		for(int i : result) {
			System.out.print(i+" ");
		}
	}
}
