/**
* Daily Coding Problem: Problem #2
* 
* This problem was asked by Uber.
* 
* Given an array of integers, return a new array such 
* that each element at index i of the new array is the 
* product of all the numbers in the original array except 
* the one at i.
* 
* For example, if our input was [1, 2, 3, 4, 5], the 
* expected output would be [120, 60, 40, 30, 24]. If our 
* input was [3, 2, 1], the expected output would be [2, 3, 6].
*
* Follow-up: what if you can't use division?
*/

public class DCP2{

	/**
	 * Divide method
	 * 
	 * Multiplying all the elements in the original array then 
	 * at individually dividing that number by each element at index
	 * i to create a new int array where each element at index i is 
	 * the product of all the numbers in the original array except the 
	 * one at i.
	 *
	 * @param	arr list of integers
	 * @return	a new array where each element at index i is the 
	 * 			product of all the numbers in the original array
	 *			except the one at i.
	 */
	public static int[] divide(int[] arr){
		int total = 1;
		for(int i = 0; i < arr.length; i++){
			total *= arr[i];
		}

		int[] newArr = new int[arr.length];
		for(int j = 0; j < arr.length; j++){
			newArr[j] = total / arr[j];
		}

		return newArr;
	}

	/**
	 * Without Using Divide Method
	 * 
	 * Using two list traversals, one starting from the left and 
	 * one starting from the right to create two list, the left list 
	 * consists of elements which are the product of the elements to 
	 * the left of the index and the right list consists of elements 
	 * which are the product of the elements to the right of the index.
	 *
	 * @param	arr list of integers
	 * @return	a new array where each element at index i is the 
	 * 			product of all the numbers in the original array
	 *			except the one at i.
	 */
	public static int[] noDivide(int[] arr){
		int[] leftArr = new int[arr.length];
		int[] rightArr = new int[arr.length];

		leftArr[0] = 1;
		for(int i = 1 ; i < arr.length; i++){
			leftArr[i] = leftArr[i-1] * arr[i-1];
		}
		rightArr[arr.length-1] = 1;
		for(int j = arr.length-2; j >= 0; j--){
			rightArr[j] = rightArr[j+1] * arr[j+1];
		}
		int[] newArr = new int[arr.length];
		for(int k = 0; k < arr.length; k++){
			newArr[k] = leftArr[k]*rightArr[k];
		}
		return newArr;
	}

	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5};
		int[] arr2 = {3, 2, 1};

		int[] newArr = divide(arr);
		for(int i = 0; i < newArr.length; i++){
			System.out.println(newArr[i]);
		}
		
		int[] newArr2 = noDivide(arr);
		for(int i = 0; i < newArr2.length; i++){
			System.out.println(newArr2[i]);
		}
	}
}