/**
 * Daily Coding Problem: Problem #114
 * 
 * This problem was asked by Facebook.
 * 
 * Given a string and a set of delimiters, reverse the words in 
 * the string while maintaining the relative order of the delimiters.
 * For example, given "hello/world:here", return "here/world:hello"
 * 
 * Follow-up: Does your solution work for the following cases: "hello/world:here/", 
 * "hello//world:here"
 */

import java.util.*;

public class DCP114 {
	
	private static class ReverseWordsWithDelimiter {

		public static String reverse(String sentence) {
			LinkedList<String> wordStack = new LinkedList<String>();
			LinkedList<String> delimiterQueue = new LinkedList<String>();

			boolean startWord = true;;

			int i = 0;
			while(i < sentence.length()) {
				boolean findWord;
				int end = i;
				if(isPartOfWord(sentence.charAt(i))) {
					findWord = true;
				} else {
					findWord = false;
				}
				do {
					end++;
				} while(end < sentence.length() && !(isPartOfWord(sentence.charAt(end)) ^ findWord));
				if(findWord) {
					wordStack.push(sentence.substring(i, end));
				}else{
					delimiterQueue.add(sentence.substring(i, end));
				}
				i = end;
			}

			String reversedString = "";
			if(!isPartOfWord(sentence.charAt(0))){
				reversedString += delimiterQueue.remove();
			}
			while(delimiterQueue.size() > 0 && wordStack.size() > 0) {
				reversedString += wordStack.pop();
				reversedString += delimiterQueue.remove();
			}
			if(wordStack.size() > 0){
				reversedString += wordStack.pop();
			}
			if(delimiterQueue.size() > 0){
				reversedString += delimiterQueue.remove();
			}
			return reversedString;
		}

		private static boolean isPartOfWord(char c){
			return (65 <= c && c <= 90) || (97 <= c && c <= 122) || c == 39 || c == 45;
		}
	}

	public static void main(String[] args) {
		String s1 = "hello/world:here";
		String s2 = "here/world:hello";
		String s3 = "hello/world:here/";
		String s4 = "hello//world:here";
		System.out.println(ReverseWordsWithDelimiter.reverse(s1));
		System.out.println(ReverseWordsWithDelimiter.reverse(s2));
		System.out.println(ReverseWordsWithDelimiter.reverse(s3));
		System.out.println(ReverseWordsWithDelimiter.reverse(s4));

	}
}