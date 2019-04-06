/**
 * Daily Coding Problem: Problem #21
 * 
 * This problem was asked by Snapchat.
 * 
 * Given an array of time intervals (start, end) for classroom lectures (possibly 
 * overlapping), find the minimum number of rooms required.
 *
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */

public class DCP21 {

	class Pair() {

		final int start;
		final int end;

		Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static int getMinNumRooms(List<Pair> timeIntervals) {
		Map<Integer, Integer> startMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> endMap = new HashMap<Integer, Integer>();

		for(int i = 0; i < timeIntervals.size(); i++) {
			int start = timeIntervals.get(i).start;
			int end = timeIntervals.get(i).end;
			if(!startMap.contains(start)) {
				startMap.put(start, 0);
			}
			startMap.put(start, startMap.get(start)+1);
			if(!endMap.contains(end)) {
				endMap.put(end, 0);
			}
			endMap.put(end, endMap.get(end)+1);
		}
	}


	public static void main(String[] args) {
		List<Pair> timeIntervals = new ArrayList<Pair>();
		timeIntervals.add(new Pair(30, 75));
		timeIntervals.add(new Pair(0, 50));
		timeIntervals.add(new Pair(60, 150));
		getMinNumRooms(timeIntervals);
	}
}