/**
 * Daily Coding Problem: Problem # 113
 * 
 * This problem was asked by Google.
 * 
 * Given a string of words delimited by spaces, reverse the words in string. 
 * For example, given "hello world here", return "here world hello"
 * 
 * Follow-up: given a mutable string representation, can you perform this operation in-place?
 * 
 */
public class DCP113 {

	public static class ReverseWords {
		/**
		 * Simulated in place sentence word reversal (since in place character
		 * swapping in String is ot possible).  reverse() first flips the whole
		 * string backwards then sequentially flips each individual words back to
		 * it's original order.
		 *
		 * @param 	sentence sentence to be reversed
		 * @return 	reversed word order
		 */
		public static String reverse(String sentence){
			//Step 1: Flip whole string in place
			char[] sCArray = sentence.toCharArray();
			int sLen = sCArray.length;
			for(int i = 0; i < sLen/2; i++){
				char temp = sCArray[i];
				sCArray[i] = sCArray[(sLen - 1) - i];
				sCArray[(sLen - 1) - i] = temp;
			}

			//Step 2: Flip individual words in place
			int start = 0;
			while(start < sLen){
				while(!isPartOfWord(sCArray[start])){
					start++;
				}
				int end = start;
				while(end < sLen-1 && isPartOfWord(sCArray[end+1]) && !Character.isWhitespace(sCArray[end+1])){
					end++;
				}

				for(int j = start; j <= (end+start)/2; j++){
					if(j == (end+start) -j){
						continue;
					}
					char temp = sCArray[j];
					sCArray[j] = sCArray[(end+start) - j];
					sCArray[(end+start) - j] = temp;
				}
				start = end + 1;
			}
			return new String(sCArray);
		}

		private static boolean isPartOfWord(char c){
			return (66 <= c && c <= 90) || (97 <= c && c <= 122) || c == 8217 || c == 39 || c == 45;
		}
	}
	public static void main(String[] args) {
		String s = "hello world here";
		String s2 = "When you are in the LEFT side, as an employee or self-employed person, you are either poor or middle class, because your hours are limited, and you can’t scale your time to get rich";
		System.out.println(ReverseWords.reverse(s));
		System.out.println(ReverseWords.reverse(s2));

	}
}