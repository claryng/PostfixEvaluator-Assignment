/**
 * Single node in a linked list
 *
 * @author ponbarry
 * @version 27 Feb 2020
 */

public class LinkedListNode<T> {

	/** Variable to hold the data in the node */
	private T data;

	/** Variable to hold the node that comes after this one */
	private LinkedListNode<T> next;

	/**
	 * Constructor; creates an empty node with no data
	 */
	public LinkedListNode() {}


	/**
	 * Constructor; creates a node with data
	 *
	 * @param d the data
	 */
	public LinkedListNode(T d) {
		data = d;
	}

	public T getData() {
		return data;
	}

	public LinkedListNode<T> getNext() {
		return next;
	}

	public void setData(T d) {
		data = d;
	}

	public void setNext(LinkedListNode<T> n) {
		next = n;
	}

	public String toString() {
		return data.toString();
	}
}
