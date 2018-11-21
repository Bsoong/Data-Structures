package Recitation;

import java.util.ArrayList;
import java.util.NoSuchElementException;
public class SortedList<E extends Comparable<E>> {
	private Node<E> head;
	private int size;

	private static class Node<E> {
		private E data;
		private Node<E> next;

		/**
		 * Constructor for Node<E>
		 * @param data - the value of the new data.
		 */
		public Node(E data) {
			if (data == null) {
				throw new IllegalArgumentException();
			}
			this.data = data;
			this.next = null;
		}


	public Node(E data, Node<E> next) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
			this.data = data;
			this.next = next;
		}
	}
	/**
	 * Constructor for Sorted List
	 */
	public SortedList() {
		this.head = null;
		this.size = 0;
	}

	public boolean add(Node <E> elem) {
	if(head == null) {
		head = elem;
		size++;
		return true;
	} else {
		while(head.next != null) {
			if(head.next == null) {
				head.next = elem;
			}
			else {
				head = head.next;
			}
		}
		return true;
	}
	

	}

	/**
	 * Getter method for the size of the SortedList
	 * @return integer for the size of the List.
	 */
	public int size() {
		return this.size;
	}
	/**
	 * @return boolean for whether SortedList is empty or not.
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	// Group Exercise
	// Remember to account for SortedList's size data element.


	public E remove(int index) {
		if(head ==  null) {
			throw new NoSuchElementException();
		}
		while()
	}

	public E get(int index) {
		// TODO: Get item using the index. Ie: index = 3  => get data of the 4th node.

	}

	public E getLast() {
		// TODO: Get the element of the last node.

	}

	// ** CHALLENGES: EXAM LEVEL QUESTIONS **

	public void removeAdjacentDuplicates() {
		// TODO: Remove all adjacent Duplicates

	}

	public boolean match(E[] pattern) {
		// TODO: Return true or false if the pattern is a subsequence in the sortedlist. Assume there are no repeats.
		//		 Ie: match( [0,1,2] , 0=>1=>2=>3 ) ==> true	 ||   match( [1,2] , 0=>3=>5 ) ==> false

	}

	@Override
	public String toString() {
		Node<E> current = head;
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		while (current != null) {
			sb.append(current.data.toString());
			sb.append(" ");
			current = current.next;
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		Integer test1 = new Integer(1000);
		Integer test2 = new Integer(1000);
		System.out.println(test1 == test2);



	}

}
