package queues;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class QueueCL<E> {
	 // data fields
	private E[] data;
	private int front, rear;
	private int size;
	private int capacity;
	private static final int INITIAL_CAPACITY=10;
	
	// Constructor
	QueueCL(){
		data = (E[]) new Object[INITIAL_CAPACITY];
		capacity = INITIAL_CAPACITY;
		front=0;
		rear = capacity-1;
		size=0;
	}
	
	public E element() {
		if(size == 0) {
			throw new NoSuchElementException();
		} else {
			size++;
			return data[0];
		}
	
	}
	
	public E remove() {
		E temp = data[0];
		if(size == 0) {
			throw new NoSuchElementException();
		} else {
			front = 1;
			size--;
			return temp;
		}
		
	}

	
	public boolean offer(E item) {
	
	}
	
	public int size() {
	}
	 
	public String toString() {
	}
	
	   
}
