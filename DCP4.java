
/**
 * Daily Coding Problem: Problem #4
 * 
 * This problem was asked by Stripe.
 * 
 * Given an array of integers, find the first missing positive 
 * integer in linear time and constant space. In other words, find
 * the lowest positive integer that does not exist in the array. The
 * array can contain duplicates and negative numbers as well.
 * 
 * For example, the input [3, 4, -1, 1] should give 2. The input 
 * [1, 2, 0] should give 3.
 */
public class DCP4 {

	/**
	 * Return the positive pivot point of the positive and negative  
	 * integers.  Pivot point is a positive integer as well.
	 * 
	 * @param	arr unsorted array of positive and negative integers.
	 * @return 	i positive pivot point.
	 */
	public static int getPositiveSubArray(int[] arr){
		int i = 0;
		int j = arr.length - 1;
		while(i < j){
			if(arr[i] <= 0 && arr[j] > 0){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}else if(arr[i] <= 0){
				j--;
			}else{
				i++;
			}
		}

		if(arr[i] <= 0){
			i--;
		}

		return i;
	}

	/**
	 * Return the lowest missing positive integer within the array. 
	 * First, the array is split into positive integers, to the left
	 * of and including the pivot, and the negative integers, to the right
	 * of the pivot. Next, the positive range is check for missing integers
	 * by using any existing positive integer of array as the index and
	 * setting the value of the index of the array negative.
	 * @param	arr unsorted array of positive and negative integers.
	 * @return 	lowest missing positive integer.
	 */
	public static int findLowestMissingPositiveInteger(int[] arr){
		if(arr.length == 0){
			return 1;
		}

		int pivot = getPositiveSubArray(arr);

		if(pivot == 0){
			return 1;
		}

		for(int i = 0; i <= pivot; i++){
			if(arr[i] < pivot){
				if(arr[i] > 0 && arr[arr[i]-1] > 0){
					arr[arr[i]-1] *= -1;
				}else if(arr[i] < 0 && arr[(arr[i] * -1) - 1] > 0){
					arr[arr[i] * -1 - 1] *= -1;
				}
				
			}
		}
		
		for(int j = 0; j <= pivot; j++){
			if(arr[j] > 0){
				return j+1;
			}
		}

		return pivot;
	}

	public static void main(String[] args){
		int[] arr1 = {3, 4, -1, 1}; 		// Test: Lowest missing integer in the middle of the range
		int[] arr2 = {1, 2, 0}; 			// Test: Lowest missing integer to the right of the range
		int[] arr3 = {1, 2, 5};				// Test: Lowest missing integer in the middle of the range with multiple integer missing
		int[] arr4 = {1};					// Test: Single integer array
		int[] arr5 = {-1, -2};				// Test: Negative integer only
		int[] arr6 = {};					// Test: Empty array
		int[] arr7 = {3, 2, 1, 2, 3, 5};	// Test: Duplicate Integers in array
		System.out.println(findLowestMissingPositiveInteger(arr1));
		System.out.println(findLowestMissingPositiveInteger(arr2));
		System.out.println(findLowestMissingPositiveInteger(arr3));
		System.out.println(findLowestMissingPositiveInteger(arr4));
		System.out.println(findLowestMissingPositiveInteger(arr5));
		System.out.println(findLowestMissingPositiveInteger(arr6));
		System.out.println(findLowestMissingPositiveInteger(arr7));
	}
}