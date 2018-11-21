package Recursion;

import java.nio.charset.MalformedInputException;

public class Practice<E> {
	private class Node<E> {
		// Data fields
		private E data;
		private Node<E> next;
		// Constructors
		Node(E data) {
			this.data=data;
			this.next=null;
		}
		Node(E data, Node<E> next) {
			this.data=data;
			this.next=next;
		}
	}
	// Data fields
	private Node<E> head;
	private int size;
	
	Practice() {
		head = null;
		size = 0;
	}
	public void removeAdjacentDuplicates() {
		while(head.next != null) {
		if(head.data == head.next.data) {
			head.next.data = null;
			size--;
		}
		else {
			head = head.next;
		}
		}
	}
		public static void main(String[]  args) {
			Node<E> n1 = new Node<E>();
			
		}
	}

