package queues;

import java.util.NoSuchElementException;

public class QueueLL<E> {

		public class Node<E> {
			// Data fields
			private E data;
			Node<E> next;
			//Constructor
			Node(E item) {
				data=item;
				next=null;
			}
			Node(E item,Node<E> next) {
				data=item;
				this.next=next;
			}
		}
		// Data fields
		Node<E> front;
		Node<E> rear;
		int size=0;
		
		// Constructor
		QueueLL() {
			front=null;
			rear=null;
			size=0;
		}
		
		// Methods
		
		/**
		 * Returns entry at front of queue without removing it. If the
		   queue is empty, throws NoSuchElementException
		 * @return
		 */
		public E element() {
			if(size == 0) {
				throw new NoSuchElementException();
			}
			else {
				return front.data;
			}
		}
		
		/**
		 * Insert an item at the rear of a queue
		 * @param item
		 * @return
		 */
		public boolean offer(E item) {
			if(front == null) {
				front = new Node<E>(item);
				rear = front;
			} else {
				rear.next = new Node<E>(item);
				rear = rear.next;
			}
			size++;
			return true;
		}
		/**
		 * Removes an entry from the front of the 
		 * queue if it is not empty. If the
		   queue is empty, throws NoSuchElementException
		 * @return
		 */
		public E remove() {
			E temp = front.data;
			if(front == null) {
				rear = null;
				throw new NoSuchElementException();
			} else {
				front = front.next;
				return temp;
			}
		}
		
		/**
		 * Returns the size of the queue
		 * @return
		 */
		public int size() {
			return size;
		}
}
		
