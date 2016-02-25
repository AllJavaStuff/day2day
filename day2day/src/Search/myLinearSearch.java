package Search;

/*Linear search or sequential search is a method for finding a
 *particular value in a list, that consists of checking every one
 *of its elements, one at a time and in sequence, until the desired one is found.
 *Best case : o(1)
 *Worst case : o(n)
*/
public class myLinearSearch {

	public static void main(String[] args){
		
		int[] data = {10,34,43,12,3,41,41,23,234,42};
		int position = search(data,12);
		System.out.println("key found at index :"+position);
	}

	private static int search(int[] data, int i) {
		// TODO Auto-generated method stub
		int keyindex = -1 ;
		for (int j = 0 ; j < data.length ; j++){
			if (data[j]== i)
			{
				keyindex = j;
			}
		}
		
		return keyindex;
	}
}
