import java.util.ArrayList;


public class GenericSort{

	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		list.sort(null);

	}
	
	 public static void main(String[] args) {
		 // Create an Integer arraylist
		 ArrayList<Integer>  intArrayList = new ArrayList<>();
		 intArrayList.add(2); intArrayList.add(3); intArrayList.add(4);
	
		 // Create a Double array
		 ArrayList<Double>  doubleArrayList = new ArrayList<>();
		 doubleArrayList.add(3.4); doubleArrayList.add(1.2); doubleArrayList.add(-12.3);
	
		 // Create a String array
		 ArrayList<String>  stringArrayList = new ArrayList<>();
		 stringArrayList.add("Bob"); stringArrayList.add("Alice"); stringArrayList.add("Ted"); stringArrayList.add( "Carol");
	
		 // Sort the arrays
		 sort(intArrayList);
		 sort(doubleArrayList);
		 sort(stringArrayList);
	
		 // Display the sorted arrays
		 System.out.print("Sorted Integer objects: ");
		 printList(intArrayList);
		 System.out.print("Sorted Double objects: ");
		 printList(doubleArrayList);
		 System.out.print("Sorted String objects: ");
		 printList(stringArrayList);
	 }	 
	 /** Print an array of objects */
	 public static void printList(ArrayList list) {
		 for (int i = 0; i < list.size(); i++)
			 System.out.print(list.get(i) + " ");
		 System.out.println();
	 }

}

