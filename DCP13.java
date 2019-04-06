/**
 * Daily Coding Problem: Problem #13
 * 
 * This problem was asked by Amazon.
 * 
 * Given an integer k and a string s, find the length of the longest substring that
 * contains at most k distinct characters.
 * 
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 * 
 */

import java.util.*;

public class DCP13 {
	
	/**
	 * Use parent string, s, and k distinct characters to obtain the maximum length of a substring.
	 * @param 	s parent string of the substrings.
	 * @param 	k Max num of distinct characters of substring.
	 * @return 	Max length of substring.
	 */
	private static int getLongestKDistinctSubStringLength(String s, int k) {

		if(k < 1){
			return 0;
		}

		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();

		int beg = 0;
		int numDistinct = 0;
		int maxLen = 0;
		int maxA = 0;
		int maxB = 0;

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!frequencyMap.containsKey(c) || frequencyMap.get(c) == 0) {
				if(numDistinct >= k){
					while(numDistinct >= k){
						char prevC = s.charAt(beg);
						int count = frequencyMap.get(prevC)-1;
						frequencyMap.put(prevC, count);
						if(count == 0){
							numDistinct--;
						}
						beg++;
					}
				}
				frequencyMap.put(c, 1);
				numDistinct++;
			}else{
				frequencyMap.put(c, frequencyMap.get(c)+1);
			}

			//Get Max Length
			int len = i - beg + 1;
			if(len > maxLen){
				maxA = beg;
				maxB = i;
				maxLen = len;
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String s1 = "abcba";
		String s2 = "abccbba";
		String s3 = "abcbbbabbcbbadd";
		String s4 = "abcbbbaaaaaaaaaabbcbbadd";
		String s5 = "abcbbbaaaaaaaaaabbcbbadd";

		System.out.println(String.format("s=\"%s\", k=%d, maxLen=%d", s1, 2, getLongestKDistinctSubStringLength(s1, 2)));
		System.out.println(String.format("s=\"%s\", k=%d, maxLen=%d", s2, 2, getLongestKDistinctSubStringLength(s2, 2)));
		System.out.println(String.format("s=\"%s\", k=%d, maxLen=%d", s3, 2, getLongestKDistinctSubStringLength(s3, 2)));
		System.out.println(String.format("s=\"%s\", k=%d, maxLen=%d", s4, 1, getLongestKDistinctSubStringLength(s4, 1)));
		System.out.println(String.format("s=\"%s\", k=%d, maxLen=%d", s5, 3, getLongestKDistinctSubStringLength(s5, 3)));
	}
}