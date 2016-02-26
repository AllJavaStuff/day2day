package sort;

/*Quicksort or partition-exchange sort, is a fast sorting algorithm, which is using divide and conquer algorithm. Quicksort first divides a large list into two smaller sub-lists: the low elements and the high elements. Quicksort can then recursively sort the sub-lists.

Steps to implement Quick sort:

1) Choose an element, called pivot, from the list. Generally pivot can be the middle index element.
2) Reorder the list so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it (equal values can go either way). After this partitioning, the pivot is in its final position. This is called the partition operation.
3) Recursively apply the above steps to the sub-list of elements with smaller values and separately the sub-list of elements with greater values.
*/
public class myQuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int[] data = { 5, 90, 35, 45, 150, 3 };
		sort(data,0,data.length-1);
		print(data);
	
	}
	
	
	
	
	private static void sort(int[] data, int low, int high) {
		// TODO Auto-generated method stub
		int i = low; int j = high;
		// Get the pivot element from the middle of the list
		
		int pivot = data[(low+high)/2];
	
		while (i <= j){
			  // If the current value from the left list is smaller then the pivot
		      // element then get the next element from the left list
			while(data[i] < pivot){
				i++;
			}
			// If the current value from the right list is larger then the pivot
		      // element then get the next element from the right list
			while (data[j]>pivot){
				j--;
			}
			  // If we have found a values in the left list which is larger then
		      // the pivot element and if we have found a value in the right list
		      // which is smaller then the pivot element then we exchange the
		      // values.
		      // As we are done we can increase i and j
			if (i<=j){ 
			exchange(data, i , j );
			i++;
			j--;
			}
			 // Recursion
			if (low<j){
				sort(data,low,j);
			}
			if (i<high){
				sort(data,i,high);
				
			}
		}
		
	}




	private static void exchange(int[] data, int i, int j) {
		// TODO Auto-generated method stub
		int temp ;
		temp = data[i];
		data[i]= data[j];
		data[j]=temp;
		
	}




	private static void print(int[] data) {
		// TODO Auto-generated method stub
		for (int i : data) {
			System.out.print(i + " ");
		}
	}

}
