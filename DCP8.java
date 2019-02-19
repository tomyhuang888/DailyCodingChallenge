/**
 * Daily Coding Problem: Problem #8
 * 
 * This problem was asked by Google.
 * A unival tree (which stands for "universal value") is a tree 
 *where all nodes under it have the same value.
 *
 * Given the root to a binary tree, count the number of unival subtrees.
 *
 * For example, the following tree has 5 unival subtrees:
 *   0
 *  / \
 * 1   0
 *    / \
 *   1   0
 *  / \
 * 1   1
 */

//PostOrder

/**
 * Binary Tree Node Class
 */
class Node{
	int value;
	Node left;
	Node right;

	Node(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}

	Node(int value, Node left, Node right){
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

/**
 * Counter class
 */
class Counter{
	int counter;

	Counter(){
		this.counter = 0;
	}

	void inc(){
		this.counter++;
	}

	void reset(){
		this.counter = 0;
	}

	int getCounter(){
		return this.counter;
	}
}

public class DCP8{

	/**
	 * Private method to recursively find number of unival trees under the node.
	 * @param node tree node
	 * @param counter counting number of unival trees
	 */
	private static String recurseNumUnival(Node node, Counter counter){
		if(node == null){
			return "";
		}

		String left = recurseNumUnival(node.left, counter);
		String right = recurseNumUnival(node.right, counter);
		if(left.equals(right)){
			counter.inc();
		}

		return left + node.value + right;

	}

	/**
	 * Public method to recursively find number of unival trees under the node.
	 * @param head head of tree node
	 */
	public static int numUnival(Node head){
		Counter counter = new Counter();
		recurseNumUnival(head, counter);
		return counter.getCounter();
	}

	public static void main(String[] args){
		Node head = new Node(0, new Node(1), new Node(0, new Node(1, new Node(1), new Node(1)), new Node(0)));
		
		System.out.println(numUnival(head));
	}
}