/**
 * Daily Coding Problem: Problem #17
 * 
 * This problem was asked by Google.
 * 
 * Suppose we represent our file system by a string in the following manner:
 * 
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * 	dir
 *	   subdir1
 *	   subdir2
 *	       file.ext
 * 
 * The directory dir contains an empty sub-directory subdir1 and a sub-directory 
 * subdir2 containing a file file.ext.
 *
 * We are interested in finding the longest (number of characters) absolute path to 
 * a file within our file system.
 * 
 * Given a string representing the file system in the above format, return the length 
 * of the longest absolute path to a file in the abstracted file system. If there is no 
 * file in the system, return 0.
 */

import java.util.*;

public class DCP17 {

	public static int findLongestFilePath(String file_system) {
		int maxPathLen = 0;

		LinkedList<String> paths = splitPath(file_system);

		List<String> absolutePath = new ArrayList<String>();

		while(paths.size() > 0) {
			String path = paths.poll();
			int level = getLevel(path);
			if(level >= absolutePath.size()) {
				absolutePath.add(path.substring(level, path.length()));
			}else{
				int numTimes = absolutePath.size()-level;
				for(int j = 0; j < numTimes; j++) {
					absolutePath.remove(absolutePath.size()-1);
				}
				absolutePath.add(path.substring(level, path.length()));
			}
			if(path.contains(".ext")){
				int len = 0;
				for(int j = 0; j < absolutePath.size(); j++) {
					len += absolutePath.get(j).length();
				}
				len += level;
				if(len > maxPathLen) {
					for(int j = 0; j < absolutePath.size(); j++) {
					}
					maxPathLen = len;
				}
			}
		} 

		return maxPathLen;
	}

	public static LinkedList<String> splitPath(String file_system) {
		LinkedList<String> paths = new LinkedList<String>();
		int prev = 0;
		for(int i = 0; i < file_system.length(); i++) {
			if(file_system.charAt(i) == '\n') {
				paths.add(file_system.substring(prev, i));
				prev = i + 1;
			}
		}
		paths.add(file_system.substring(prev, file_system.length()));
		return paths;
	}

	public static int getLevel(String path) {
		int level = 0;
		int i = 0;
		while(i < path.length() && path.charAt(i) == '\t') {
			level++;
			i++;
		}
		return level;
	}

	public static void main(String[] args) {
		String s1 = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		String s2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println("dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext = " + findLongestFilePath(s1));
		System.out.println("dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext = " + findLongestFilePath(s2));
	}
}