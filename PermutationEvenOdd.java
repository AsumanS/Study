
public class PermutationEvenOdd {
	public void permutation(int[] a) {
		perm(a, 0, 1);
	}
	public void perm(int[] a, int start, int evenOdd) {
		if(start==a.length-1) {
			print(a);
			return;
		}
		for(int i=start;i<a.length;i++) {
			if(a[i]%2==evenOdd) {
				swap(a, start, i, evenOdd);
				perm(a, start+1, evenOdd==1?0:1);
				swap(a, start, i, -1);
			}
		}
	}
	public void swap(int[] a, int i, int start, int evenOdd) {
		if(evenOdd==-1) {
			int temp = a[i];
			a[i]=a[start];
			a[start]=temp;
		}
		else {
			for(int j=start;j<a.length;j++) {
				if(a[j]%2==evenOdd) {
					int temp = a[i];
					a[i]=a[j];
					a[j]=temp;
					break;
				}
			}
		}
	}
	public void print(int[] a) {
		for(int i : a)
			System.out.print(i+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		PermutationEvenOdd peo = new PermutationEvenOdd();
		peo.permutation(new int[] {1,3,2,4});
	}
}
