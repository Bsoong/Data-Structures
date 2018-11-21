package Recitation;

import java.util.ArrayList;

/**
 * Class that builds a Single Linked List representation.
 * @author Nburg
 *
 * @param <E>
 */
public class RSLL2<E> {
	
	/**
	 * A private class that builds a single Node object 
	 * for a Linked List.
	 * @author Nburg
	 *
	 * @param <E>
	 */
	private static class Node<E> {
		E data;
		Node<E> next;

		/**
		 * Constructor for a Node that sets the data and 
		 * the next reference.
		 * @param data
		 * @param next
		 */
		Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}

		/**
		 * Constructor for a Node that sets the data and sets the 
		 * next reference to null.
		 * @param data
		 */
		Node(E data) {
			this.data = data;
			this.next = null;
		}

		/**
		 * Returns a string representation of a Node.
		 * @return A string representation of a Node.
		 */
		public String toString() {
			if (data == null) {
				return "null"; 		// Must check for null. Returning null.toSTring() produces an error.
			} else {
				return data.toString();
			}
		}
	}

	private Node<E> head = null;
	private int size = 0;

	/**
	 * Adds an item to the front of the LinkedList.
	 * @param item
	 */
	public void addFirst(E item) {
		head = new Node<E>(item, head);		//Right-hand side of the equals is evaluated before the
		size++;								//assignment is performed. We don't lose the reference to head.
	}

	/**
	 * Removes the node directly following the argument.
	 * @param node
	 * @return The node reoved.
	 */
	private E removeAfter(Node<E> node) {
		//creates a temporary pointer to the next node.
		Node<E> temp = node.next;
		
		//If our linkedlist is a->b->c  it sets a->c and returns b 
		node.next = temp.next; 
		size--;
		return temp.data;
	}

	/**
	 * Removes the node at the head of the LinkedList.
	 * @return The node removed.
	 */
	public E removeFirst() {
		if (head == null) {
			return null;
		}

		Node<E> temp = head.next;
		head = head.next;
		size--;
		return temp.data;
	}

	/**
	 * Adds a node at the given index, shifting all the following nodes by 1 index.
	 * @param item
	 * @param index
	 */
	public void add(E item, int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			addFirst(item);
		}

		else {
			Node<E> temp = this.get(index - 1);
			temp.next = new Node<E>(item, temp.next);
			size++;
		}
	}

	/**
	 * Retrieves the node at the given index.
	 * @param index
	 * @return The node at the given index.
	 */
	private Node<E> get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> current = head;

		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}
	
	/**
	 * Returns the LinkedList in the reverse order.
	 * @return The reverse order of the LinkedList.
	 */
	public Node<E> reverse() {
		if (head == null) {
			throw new IllegalArgumentException();
		}
		if (head.next == null) {
			return head;
		}
		
		Node<E> prev = null;
		Node<E> curr = head;
		Node<E> next = curr.next;
		
		while (next != null) {
			// moves prev, curr, and next pointers by 1 node.
			prev = curr;
			curr = next;
			next = next.next;
			
			//sets the current node's pointer to the previous node.
			curr.next = prev;
		}
		
		//sets the last node's pointer to the previous node.
		curr.next = prev;
		
		//sets what used to be the head node's pointer to null
		//since it is now our last node.
		head.next = null;
		
		//sets the head reference to the current node.
		head = curr;
		
		return head;
	}
	
	/**
	 * Returns true if the list is only one element; false otherwise.
	 * @param node
	 * @return True if the list is only one element; false otherwise.
	 */
	public boolean isSingleton(Node<E> node) {
		return node!=null && node.next == null;
	}
	
	/**
	 * Returns true if all the numbers in the list are negative;
	 * false otherwise.
	 * @param start
	 * @return True if all the numbers in the list are negative;
	 * false otherwise.
	 */
	public boolean allNegative() {
		return allNegative((Node<Integer>) head);
	}
	
	/**
	 * Helper function for allNegative() that returns true if all the 
	 * numbers in the list are negative false otherwise.
	 * @param start
	 * @return True if all the numbers in the list are negative;
	 * false otherwise.
	 */
	private boolean allNegative(Node<Integer> start) {
		if (start == null) {
			throw new IllegalArgumentException();
		}
		Node<Integer> cur = start;

		while (cur != null) {
			if (cur.data > 0) {
				return false;
			} else {
				cur = cur.next;
			}
		}
		return true;
	}
	
	/**
	 * Sums up all the data in a list.
	 * @param node
	 * @return The sum of the data in the list.
	 */
	public Integer sumL(Node<Integer> node) {
		if (node == null) {
			throw new IllegalArgumentException();
		}
		Node<Integer> curr = node;
		int sum = 0;

		while (curr.next != null) {
			sum += curr.data;
			curr = curr.next;
		}

		return sum;
	}
	
	/**
	 * Returns true if all the data in the list is even; false otherwise.
	 * @param start
	 * @return True if all the data in the list is even; false otherwise.
	 */
	private boolean allEven(Node<Integer> start) {
		if (start == null) {
			throw new IllegalArgumentException();
		}
		Node<Integer> cur = start;

		while (cur != null) {
			if (cur.data % 2 != 0) {
				return false;
			} else {
				cur = cur.next;
			}
		}
		return true;
	}
	
	/**
	 * Returns true if the lost has a cycle; false otherwise.
	 * @return True if the lost has a cycle; false otherwise.
	 */
	public boolean hasCycle() {
		return hasCycle(head);
	}
	
	/**
	 * Returns true if the lost has a cycle; false otherwise.
	 * @return True if the lost has a cycle; false otherwise.
	 */
	private boolean hasCycle(Node<E> node) {
		ArrayList<Node<E>> basket = new ArrayList<Node<E>>();
		Node<E> curr = node;

		while (curr != null) {
			if (basket.contains(curr)) {
				return true;
			} else {
				basket.add(curr);
				curr = curr.next; 
			}
		}

		return false;
	}

	/**
	 * Returns a string representation of a LinkedList.
	 * @return A string representation of a LinkedList.
	 */
	public String toString() {
		String s = "[";

		Node<E> current = head;

		if (current != null) {
			while (current.next != null) {
				s += current.data.toString();
				s += ",";
				current = current.next;
			}

			s += current.data.toString() + "]";
		}

		return s;
	}

	public static void main(String[] args) {
		RSLL<Integer> l = new RSLL<Integer>();

		l.addFirst(4);
		l.addFirst(2);
		l.addFirst(1);
		l.add(3, 2);
		

		System.out.println(l);
		
		System.out.println(l.get(3));
		
		l.reverse();

		System.out.println(l);
	}

}