package Search;


/*A binary search or half-interval search algorithm finds the position of a 
 * specified value (the input "key") within a sorted array. 
 * 
 * In each step,the algorithm compares the input key value with the key value of the middle element of the array. 
 * If the keys match, then a matching element has been found so its index, or position, is returned. 
 * Otherwise, if the sought key is less than the middle element's key, 
 * then the algorithm repeats its action on the sub-array to the left of the middle element 
 * or,
 * if the input key is greater, on the sub-array to the right.
 * If the remaining array to be searched is reduced to zero,
 * then the key cannot be found in the array and a special "Not found" indication is returned.
 * Every iteration eliminates half of the remaining possibilities.
 * This makes binary searches very efficient - even for large collections.
 * 
 * Binary search requires a sorted collection.
 * 
 * Also, binary searching can only be applied to a collection that allows random access (indexing).
 * 
 * Worst case performance: O(log n)
 * 
 * Best case performance: O(1)
*/

public class myBinarySearchByDivideConquer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// sorted array data
		int[] data = {2,4,6,8,10, 12, 14, 16};
		int position = search(data,12);
		System.out.println("key found at index :"+position);
	}

	private static int search(int[] data, int i) {
		// TODO Auto-generated method stub
		int keyindex = -1 ;
		
		int start =0;
		int end = data.length -1;
		
		while (start<=end){
			
			int middle = (start+end)/2;
			System.out.println("start ="+start+" ,middle ="+middle+" ,end ="+end);
			if(i == data[middle]){
				keyindex = middle;
				
			}
			
			if (i < data[middle]){
				end = middle -1;
			}
			else {
				start = middle +1;
			}
		}
		
		return keyindex;
	}

}
