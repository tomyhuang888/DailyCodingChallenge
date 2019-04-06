/**
 * Daily Coding Problem: Problem #16
 * 
 * This problem was asked by Twitter.
 * 
 * You run an e-commerce website and want to record the last N 
 * order ids in a log. Implement a data structure to accomplish 
 * this, with the following API:
 * 
 * record(order_id):	adds the order_id to the log 
 * get_last(i): 		gets the ith last element from the log. 
 *						i is guaranteed to be smaller than or equal to N. 
 *						You should be as efficient with time and space as possible.
 */
public class DCP16 {
	
	private static class ECommerceLog {
		int[] log;
		int max_len;
		int len;
		int position;

		public ECommerceLog(int max_len) {
			this.log = new int[max_len];
			this.max_len = max_len;
			this.len = 0;
			this.position = 0;
		}

		public void record(int order_id) {
			if(len < max_len) {
				log[len] = order_id;
				position = len;
				len++;
			}else{
				if(position == max_len - 1){
					position = 0;
				}else{
					position++;
				}
				log[position] = order_id;
			}
		}

		public int get_last(int ith_last) {
			if(ith_last-1 > len) {
				return -1;
			}
			if((ith_last-1) > position){
				return log[position + (max_len - (ith_last-1))];
			}else{
				return log[position - (ith_last-1)];
			}
		}

		public void printLog(){
			for(int i = 0; i < len; i++){
				System.out.printf("%d ", log[i]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ECommerceLog eLog = new ECommerceLog(5);
		eLog.record(1);
		eLog.record(2);
		eLog.printLog();
		eLog.record(3);
		eLog.record(4);
		eLog.record(5);
		eLog.printLog();
		eLog.record(6);
		eLog.record(7);
		eLog.record(8);
		eLog.printLog();
		System.out.println("eLog.get_last(4) == " + eLog.get_last(4));
		System.out.println("eLog.get_last(1) == " + eLog.get_last(1));
	}
}