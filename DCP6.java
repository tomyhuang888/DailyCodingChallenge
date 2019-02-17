/**
 * Daily Coding Problem: Problem #6
 * 
 * This problem was asked by Google.
 * 
 * An XOR linked list is a more memory efficient doubly 
 * linked list. Instead of each node holding next and prev 
 * fields, it holds a field named both, which is an XOR of
 * the next node and the previous node. Implement an XOR
 * linked list; it has an add(element) which adds the element
 * to the end, and a get(index) which returns the node at index.
 */

/**
 * XORNode Generic Class for XORLinkedList Class
 */ 
class XORNode<T>{
	int both_addr;
	T element;

	XORNode(T element, int addr){
		this.element = element;
		this.both_addr = addr;
	}

	void setAddr(int addr){
		this.both_addr = addr;
	}

	void setElement(T element){
		this.element = element;
	}

	int getAddr(){
		return this.both_addr;
	}

	T getElement(){
		return this.element;
	}
}

/**
 * XORLinkedList Class using a XORNode array to simulate memory addressing
 */
class XORLinkedList<T>{
	int head;
	int tail;
	XORNode[] mem_arr;
	int size;

	XORLinkedList(){
		this.head = -1;
		this.tail = -1;
		this.mem_arr = new XORNode[128];
		for(int i = 0; i < 128; i++){
			this.mem_arr[i] = null;
		}
		this.size = 0;
	}

	/**
	 * Get the next sequential available address from the requested address.
	 * @param 	addr requested address
	 * @return 	next available address from the requested address
	 */
	private int getNextAvailAddr(int addr){
		while(this.mem_arr[addr] != null){
			addr++;
		}
		return addr;
	}

	/**
	 * Add new element to XORLinkedList while keeping track of
	 * head and tail of the XORLnkedList
	 * @param 	element new element
	 */
	void add(T element){
		if(this.head == -1){
			int addr = getNextAvailAddr(0);
			this.mem_arr[addr] = new XORNode(element, addr);
			this.head = addr;
			this.tail = addr;
			this.size++;
			return;
		}
		int prev = this.tail;
		int next = getNextAvailAddr(prev);
		int both = prev + next;
		this.mem_arr[prev].setAddr(both);
		this.mem_arr[next] = new XORNode(element, prev);
		this.tail = next;
		this.size++;
	}

	/**
	 * Returns the element at the specified position of the XORLinkedList
	 * @param	index specified position
	 * @return 	element at the specfied position of the XORLinkedList
	 */
	T get(int index){
		if(index >= this.size){
			return null;
		}
		int next = this.head;
		for(int i = 0; i < index; i++){
			int both = this.mem_arr[next].getAddr();
			next = both - next;
		}
		return (T)this.mem_arr[next].getElement();
	}


}
public class DCP6{

	public static void main(String[] args){
		XORLinkedList<Integer> xorll = new XORLinkedList<Integer>();
		xorll.add(0);
		xorll.add(1);
		xorll.add(2);
		xorll.add(3);
		System.out.println(xorll.get(3));
		System.out.println(xorll.get(2));
		System.out.println(xorll.get(1));
		System.out.println(xorll.get(0));

	}
}