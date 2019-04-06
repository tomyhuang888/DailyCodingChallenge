/**
 * Daily Coding Problem: Problem #18
 *
 * This problem was asked by Google.
 *
 * Given an array of integers and a number k, where 1 <= k <= length of the array, 
 * compute the maximum values of each subarray of length k.
 * 
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
 * 
 * 		10 = max(10, 5, 2)
 * 		7 = max(5, 2, 7)
 * 		8 = max(2, 7, 8)
 * 		8 = max(7, 8, 7)
 * 
 * Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need
 * to store the results. You can simply print them out as you compute them.
 */

import java.util.*;

public class DCP18 {

	public static ArrayList<Integer> findMaxOfKSubArray(int[] array, int k) {
		if(k == 0 || k > array.length) {
			return new ArrayList<Integer>();
		}

		LinkedList<Integer> kQueue = new LinkedList<Integer>();
		ArrayList<Integer> kArray = new ArrayList<Integer>();
		int maxPos = 0;
		for(int i = 0; i < array.length; i++) {
			// Remove head if:
			// 		1. Size of kQueue is greater than equal to k
			//		2. The number of items between array[i] and array[maxPos] is greater than or equal to k
			//		3. kQueue is not empty and array[i] is greater than or equals to head of kQueue
			while(kQueue.size() >= k || i - maxPos >= k || (!kQueue.isEmpty() && array[i] >= kQueue.getFirst())) {
				kQueue.poll();
				maxPos++;
			}

			kQueue.add(array[i]);

			if(i - k >= -1) {
				kArray.add(kQueue.getFirst());
			}
		}
		return kArray;
	}

	public static void printArray(ArrayList<Integer> array) {
		System.out.println(array.toString());
	}

	public static void main(String[] args) {
		int[] array1 = {10, 5, 2, 7, 8, 7};
		int[] array2 = {5, 2};
		int[] array3 = {10, 5, 2, 7, 8, 7, 3, 6, 3, 11, 3, 1, 1};
		int k1 = 3;
		int k2 = 2;
		int k3 = 4;

		ArrayList<Integer> kArray1 = findMaxOfKSubArray(array1, k1);
		printArray(kArray1);

		ArrayList<Integer> kArray2 = findMaxOfKSubArray(array2, k2);
		printArray(kArray2);

		ArrayList<Integer> kArray3 = findMaxOfKSubArray(array3, k3);
		printArray(kArray3);
	}
}