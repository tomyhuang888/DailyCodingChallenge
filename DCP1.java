import java.util.*;

/**
* Daily Coding Problem: Problem #1
*
* This problem was recently asked by Google.
*
* Given a list of numbers and a number k, return 
* whether any two numbers from the list add up to k.
* 
* For example, given [10, 15, 3, 7] and k of 17, 
* return true since 10 + 7 is 17.
*
* Bonus: Can you do this in one pass?
*/

public class DCP1{

	/**
	* Traverses through the int array and find 
	* whether a pair of int sums up to integer, k.
	*
	* @param arr unsorted array of nums.
	* @param k the desired sum to be found.
	*/	
	public static boolean twoNumSum(int[] arr, int k){
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++){
			int num = arr[i];
			if(set.contains(k-num)){
				return true;
			}else{
				set.add(num);
			}
		}
		return false;
	}

	/**
	* Main method that creates an int array and an int, k,
	* and calls twoNumSum to test whether there are any int pairs
	* in arr that adds up to k.
	* @param args unused
	*/
	public static void main(String[] args){
		int[] arr = {10, 15, 3, 7};
		int k = 17;

		if(twoNumSum(arr, k)){
			System.out.println("True");
		}else{
			System.out.println("False");
		}
	}
}