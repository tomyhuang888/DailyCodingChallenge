/**
 * Daily Coding Problem: Problem #20
 * 
 * This problem was asked by Google.
 * 
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 * 
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 * 
 * In this example, assume nodes with the same value are the exact same node objects.
 * 
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */

import java.util.*;
import java.rmi.UnexpectedException;

public class DCP20 {

	public static int findIntersectingNode(LinkedList<Integer> list1, LinkedList<Integer> list2)  throws IllegalStateException, UnexpectedException {

		int list1_length = list1.size();
		int list2_length = list2.size();

		if (list1_length == 0 || list2_length == 0) {
			throw new IllegalStateException("list cannot be empty");
		}

		int diff;

		Iterator<Integer> longerList;
		Iterator<Integer> shorterList;
		if(list1_length > list2_length) {
			longerList = list1.iterator();
			shorterList = list2.iterator();
			diff = list1_length - list2_length;
		} else {
			longerList = list2.iterator();
			shorterList = list1.iterator();
			diff = list2_length - list1_length;
		}

		for(int i = 0; i < diff; i++) {
			longerList.next();
		}

		do {
			int l_num = longerList.next();
			int s_num = shorterList.next();
			if(l_num == s_num) {
				return l_num;
			}
		} while(longerList.hasNext() && shorterList.hasNext());

		throw new UnexpectedException("There are no intersecting nodes between the list");
	}

	public static void main(String[] args) throws IllegalStateException, UnexpectedException {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(98);
		list1.add(3);
		list1.add(7);
		list1.add(8);
		list1.add(10);
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(99);
		list2.add(1);
		list2.add(8);
		list2.add(10);
		System.out.println(findIntersectingNode(list1, list2));
	}
}