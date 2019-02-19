/**
 * Daily Coding Problem: Problem #9
 * 
 * This problem was asked by Airbnb.
 * 
 * Given a list of integers, write a function that returns
 * the largest sum of non-adjacent numbers. Numbers can be
 * 0 or negative.
 * 
 * For example, [2, 4, 6, 8] should return 12, since we pick
 * 4 and 8. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 */
public class DCP9{

	/**
	 * Private method that uses dynamic programming o find the
	 * largest sum of non-adjacent numbers.
	 * @param 	arr array of integers
	 * @param 	position position of array
	 * @param 	sumArr array of largest sum of non-adjacent numbers
	 *			 at each position
	 */
	private static void findNonAdjLargeSum(int[] arr, int position, int[] sumArr){
		if(position >= arr.length){
			return;
		}
		int value;
		if(position == 0){
			value = arr[0];
		}else if(position == 1){
			value = arr[0] > arr[1] ? arr[0] : arr[1];
		}else{
			value = sumArr[position-2] + arr[position];
		}
		sumArr[position] = value;
		findNonAdjLargeSum(arr, position+1, sumArr);
	}

	/**
	 * Public method to find the largest sum of non-adjacent numbers.
	 * @param 	arr array of integers
	 * @return 	largest sum of non-adjacent numbers.
	 */
	public static int nonAdjLargeSum(int[] arr){
		int[] sumArr = new int[arr.length];
		findNonAdjLargeSum(arr, 0, sumArr);
		if(sumArr.length == 1 || sumArr[sumArr.length-1] > sumArr[sumArr.length-2]){
			return sumArr[sumArr.length-1];
		}else{
			return sumArr[sumArr.length-2];
		}
	}

	public static void main(String[] args){
		int[] arr1 = {2, 4, 6, 8};
		int[] arr2 = {5, 1, 1, 5};
		System.out.println(nonAdjLargeSum(arr1));
		System.out.println(nonAdjLargeSum(arr2));
	}
}