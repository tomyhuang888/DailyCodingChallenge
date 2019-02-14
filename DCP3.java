/**
 * Daily Coding Problem: Problem #3
 * 
 * This problem was asked by Google.
 * 
 * Given the root to a binary tree, implement serialize(root),
 * which serializes the tree into a string, and deserialize(s),
 * which deserializes the string back into the tree.
 */

/**
 * Binary Tree Node Class
 */

class Node{
	char val;
	Node left;
	Node right;

	Node(char val){
		this.val = val;
		this.left = null;
		this.right = null;
	}

	Node(char val, Node left, Node right){
		this.val = val;
		this.left = left;
		this.right = right;
	}

	void setVal(char c){
		this.val = c;
	}
}

/**
 * Counter to store character position of string for recursion.
 */
class DCP3Counter{
	int x;

	DCP3Counter(){
		this.x = 0;
	}
}

public class DCP3{

	/**
	 * Serializes binary tree into string.
	 * @param 	node node of tree.
	 * @return 	s serialized string of node and its children.
	 */
	public static String serialize(Node node){
		if(node == null){
			return "";
		}

		String s = "";
		s += node.val;
		if(node.left != null || node.right != null){
			s += "(";
			if(node.left != null){
				s += serialize(node.left);
			}else{
				s += "/";
			}
			if(node.right != null){
				s += serialize(node.right);
			}else{
				s += "/";
			}
			s+= ")";
		}
		return s;
	}

	/**
	 * Private recursion method to deserialize from string into a 
	 * binary tree
	 * 
	 * @param 	s serialized binary tree string.
	 * @param 	counter internal counter to keep track of current char 
	 *			position of string s.
	 * @return	node binary tree node and its children.
	 */
	private static Node recurseDeserialize(String s, DCP3Counter counter){
		if(counter.x >= s.length()){
			//throw error incorrect string?
		}

		Node node = new Node(s.charAt(counter.x));
		counter.x++;

		if(s.charAt(counter.x) == '('){
			counter.x++;
			node.left = recurseDeserialize(s, counter);
			node.right = recurseDeserialize(s, counter);
			if(s.charAt(counter.x) == ')'){
				counter.x++;
			}
		}
		
		return node;
	}

	/**
	 * Public method to deserialize from string into a binary tree
	 * 
	 * @param 	s serialized binary tree string.
	 * @return	binary tree node and its children.
	 */
	public static Node deserialize(String s){
		if(s == ""){
			return null;
		}
		DCP3Counter counter = new DCP3Counter();
		return recurseDeserialize(s, counter);

	}

	/**
	 * Prints binary tree using PreOrder Traversal.
	 * 
	 * @param 	node node of binary tree.
	 */
	public static void printTreePreOrder(Node node){
		if(node != null){
			System.out.println(String.format("%c ", node.val));
			printTreePreOrder(node.left);
			printTreePreOrder(node.right);
		}
	}

	public static void main(String[] args){
		Node root = new Node('A');
		Node left = new Node('B', new Node('C'), null);
		Node right = new Node('D');
		root.left = left;
		root.right = right;
		String serial = serialize(root);
		System.out.println(serial);
		Node head = deserialize(serialize(root));
		printTreePreOrder(head);
		
	}
}