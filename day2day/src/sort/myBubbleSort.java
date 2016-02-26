package sort;

/*Bubble sort, also referred to as sinking sort, is a simple sorting algorithm that 
 works by repeatedly stepping through the list to be sorted, 
 comparing each pair of adjacent items and swapping them if they are in the wrong order. 

 The pass through the list is repeated until no swaps are needed,
 which indicates that the list is sorted.

 The algorithm gets its name from the way smaller elements "bubble" to the top of the list.
 Because it only uses comparisons to operate on elements,
 it is a comparison sort. Although the algorithm is simple,
 most of the other sorting algorithms are more efficient for large lists.


 Bubble sort has worst-case and average complexity both О(n2),
 where n is the number of items being sorted.
 There exist many sorting algorithms with substantially 
 better worst-case or average complexity of O(n log n).

 Even other О(n2) sorting algorithms, such as insertion sort, tend to have better performance
 than bubble sort.

 Therefore, bubble sort is not a practical sorting algorithm when n is large.

 Performance of bubble sort over an already-sorted list (best-case) is O(n). 
 */

public class myBubbleSort {

	/**
	 * @param args
	 */
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

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < (n - i - 1); j++) {

				if (data[j] > data[j + 1]) {
					temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}

			}
			System.out.print("pass  " + (i + 1) + " -> ");
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
