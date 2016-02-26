package sort;

/*Insertion sort is a simple sorting algorithm that builds 
the final sorted array (or list) one item at a time. 

It is much less efficient on large lists than more advanced algorithms 
such as quicksort, heapsort, or merge sort. 

However, advantages of Insertion Sort are that it is efficient for (quite) small data sets,
adaptive for data sets that are already substantially sorted, 
stable (i.e. does not change the relative order of elements with equal keys), 
In-place ( i.e. only requires a constant amount O(1) of additional memory space) 
and online (i.e. can sort a list as it receives it).

Worst case performance : О(n2) comparisons, swaps
Best case performance : O(n) comparisons, O(1) swaps
Average case performance : О(n2) comparisons, swaps
*/


public class myInsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = { 5, 90, 35, 45, 150, 3 };
		sort(data);
	}

	private static void sort(int[] data) {
		// TODO Auto-generated method stub

		int n = data.length;
		int temp;

		System.out.print("pass  0 -> ");
		print(data);
		System.out.println();

		int j; // the number of items sorted so far
		int key; // the item to be inserted
		int i;

		for (j = 1; j < n; j++) // Start with 1 (not 0)
		{
			key = data[j];
			for (i = j - 1; (i >= 0) && (data[i] < key); i--) // small values
																// are moving up
			{
				data[i + 1] = data[i];
			}
			data[i + 1] = key; // Put the key in its proper location

			System.out.print("pass  " + (j) + " -> ");
			print(data);
			System.out.println();
		}

		System.out.println("final output as below");
		print(data);

	}

	private static void print(int[] data) {
		// TODO Auto-generated method stub
		for (int i : data) {
			System.out.print(i + " ");
		}
	}

}
