package sort;

/*The selection sort is a combination of searching and sorting.
 During each pass, the unsorted element with the smallest (or largest) value is moved
 to its proper position in the array. 

 The number of times the sort passes through the array is one less than the number of items 
 in the array. In the selection sort,
 the inner loop finds the next smallest (or largest) value and the outer loop places 
 that value into its proper location.
 */
public class mySelectionSort {

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

		for (int i = 0; i < n - 1; i++) {
			int smallestIndex = 0;
			for (int j = i + 1; j < n; j++) {

				if (data[j] < data[i]) {
					smallestIndex = j;
				}

				temp = data[smallestIndex];
				data[smallestIndex] = data[i];
				data[i] = temp;
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
