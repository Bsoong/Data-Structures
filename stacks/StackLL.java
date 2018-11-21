package stacks;

import java.util.EmptyStackException;

public class StackLL<E> implements StackInt<E> {

		public class Node<E> {
			// Data fields
			private E data;
			private Node<E> next;
			
			// Constructors
			Node(E item) {
				data=item;
				next=null;
			}
			
			Node(E item, Node<E> next) {
				data=item;
				this.next=next;
			}
		}
		// Data fields
		private Node<E> topmost;
		private int size;
		
		// Constructor
		StackLL() {
			topmost=null;
			size=0;
		}
		
		// Methods
		
		public E push (E item) {
			topmost = new Node<E>(item,topmost);
			size++;
			return item;
		}

		public E top() {
			if (empty()) {
				throw new EmptyStackException();
			}
			return topmost.data;
		}
		
		public E pop() {
			E temp=top();
			topmost=topmost.next;
			size--;
			return temp;
		}
		
		public boolean empty() {
			return topmost==null;
		}
		
		public static void main(String[] args) {
			StackInt<Integer> s = new StackLL<Integer>();
			
			s.push(1);
			s.push(2);
			s.push(3);
			
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
			
		}
		
		
}
