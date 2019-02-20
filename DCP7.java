/**
 * Daily Coding Problem: Problem #7
 * 
 * This problem was asked by Facebook.
 * 
 * Given the mapping a = 1, b = 2, ... z = 26, and an
 * encoded message, count the number of ways it can be
 * decoded.
 * 
 * For example, the message '111' would give 3, since it
 * could be decoded as 'aaa', 'ka', and 'ak'.
 *
 * You can assume that the messages are decodable. For example,
 * '001' is not allowed.
 */
public class DCP7 {

	/**
	 * Return whether the submessage is a valid encoding.
	 * 
	 * @param subMessage string submessage of length 2.
	 * @return returns true if submessage is a valid encoding, else false.
	 */
	public static boolean isChar(String subMessage){
		int num = Integer.valueOf(subMessage);
		return num > 0 && num <= 26;
	}

	/**
	 * Returns the number of ways an encoded message can be decoded.
	 *
	 * @param message encoded method to be counted
	 * @param number of ways the encoded message can be decoded.
	 */
	public static int getMessageCount(String message){
		int[] arr = new int[message.length()];
		for(int i = message.length()-1; i >= 0; i--){
			if(i == message.length()-1){
				arr[i] = 1;
			}else if(i == message.length()-2){
				if(isChar(message.substring(i, i+2))){
					arr[i] = 2;
				}else{
					arr[i] = 1;
				}
			}else{
				arr[i] = arr[i+1];
				if(isChar(message.substring(i, i+2))){
					arr[i] += arr[i+2];
				}
			}
		}
		return arr[0];
	}

	public static void main(String[] args){
		assert getMessageCount("111") == 3;
		assert getMessageCount("81") == 1;
		assert getMessageCount("11") == 2;
		assert getMessageCount("1111") == 5;
		assert getMessageCount("1311") == 4;

		System.out.println("Number of Encoded Messages for \"81\" = " + getMessageCount("81"));
		System.out.println("Number of Encoded Messages for \"11\" = " + getMessageCount("11"));
		System.out.println("Number of Encoded Messages for \"111\" = " + getMessageCount("111"));
		System.out.println("Number of Encoded Messages for \"1111\" = " + getMessageCount("1111"));
		System.out.println("Number of Encoded Messages for \"1311\" = " + getMessageCount("1311"));
	}
}