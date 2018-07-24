
import java.util.ArrayList;

//Brandon Soong
//I pledge my honor that I have abided by the Stevens Honor System. -Bsoong

/** 
 * @param <E> The data type for Node.
 */
public class IDLList<E> {
	private static class Node<E> {
		//Create the static variable for the Node
		E data;
		Node<E> prev;
		Node<E> next;
		
		Node(E elem) {
			//Sets the Node values of data prev and next to default
			data = elem;
			prev = null;
			next = null;
		}
		

		/**
		 * 
		 * @param elem The <E> value name
		 * @param prev The Node for the previous function
		 * @param next The Node for the next function
		 */
		Node(E elem, Node<E> prev, Node<E> next) {
			this.data = elem;
			this.prev = prev;
			this.next = next;
		}
		
		/**
		 * @return What A String should look like for a node.
		 */
		public String toString() {
			//toString Method for the Node Function
			if (this.data == null) {
				return (String) null;
			}
			else {
				return this.data.toString();
			}
		}
	}

	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices;
	
	public IDLList() {
		//Constructor
		head = null;
		tail = null;
		indices = new ArrayList<Node<E>>();
		size = 0;
	}
	
	/**
	 * @param index The Location of where the Element should go
	 * @param elem The Element that is being added to the array
	 * @return True Only true if the function completes.
	 */
	public boolean add(int index, E elem) {
		//Add Function that adds an element at a specific index.
		if (index > size || index < 0 || elem == null) {
			throw new IllegalArgumentException();
		}
		
		else if (index == size) {
			append(elem);
			return true;
		}
		
		else if (index == 0) {
			add(elem);
			return true;
		}
		
		else {
			Node<E> previous = indices.get(index-1);
			Node<E> a0 = new Node<E>(elem, previous, previous.next);
			previous.next.prev = a0;
			previous.next = a0;
			indices.add(index, a0);
			size++;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param elem The Element being added to the list. 
	 * @return True True Only if the function completes.
	 */
	public boolean add(E elem) {
		//Adds an Element to the Front of the array
		if (size == 0) {
			Node<E> a1 = new Node<E>(elem);
			head = a1;
			tail = head;
			size++;
			indices.add(0, a1);
			return true;
		} else {
			Node<E> a2 = new Node<E>(elem);
			a2.next = head;
			head.prev = a2;
			head = a2;
			size++;
			indices.add(0, a2);
			return true;
		}
	}
	
	/**
	 * @param elem The Element that is added to the list
	 * @return True Returns True only if the method runs successfully.
	 */
	public boolean append(E elem) {
		//Adds an Element to the end of the list.
		if (elem == null) {
			throw new IllegalArgumentException();
		}
		else if (tail == null) {
			add(elem);
		}
		else {
			Node<E> a2 = tail;
			tail = new Node<E>(elem, tail, null);
			a2.next = tail;
			indices.add(tail);
			size++;
		}
		
		return true;
	}
	
	/**
	 * @param index The Location of where the Element should go
	 * @return The Elements data at the specific index
	 */
	public E get(int index) {
		//Returns the element at a specific index
		if(index > size) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			return indices.get(index).data;
		}
		}
		
	
	/**
	 * @return Returns the data of the head of the list
	 */
	public E getHead() {
		//Returns the value of the head
		return head.data;
	}
	
	/**
	 * @return Returns the data of the tail in the list
	 */
	public E getLast() {
		//Returns the value of the tail
		return tail.data;
	}
	
	/**
	 * @return Returns the size of the List
	 */
	public int size() {
		//Returns the size of the list
		return size;
	}
	
	/**
	 * @return Returns the first element that was removed
	 */
	public E remove() {
		//Removes the first element in the array
		if (head == null) {
			throw new IllegalArgumentException();
		}
		
		else if(head == tail) {
			Node<E> temp = head;
			head = null;
			tail = null;
			indices.clear();
			size--;
			return temp.data;
		} else {
			Node<E> temp = head;
			head = head.next;
			indices.remove(0);
			size--;
			return temp.data;
		}
		}
		
	
	/**
	 * @return Returns the last element in the array
	 */
	public E removeLast() {
		//Removes the last element in the array
		if (tail == null) {
			throw new NullPointerException();
		}
		
		else if (head == tail) {
			Node<E> temp = tail;
			head = null;
			tail = null;
			indices.clear();
			size--;
			return temp.data;
		}
		
		else {
			Node<E> temp = tail;
			tail = tail.prev;
			tail.next = null;
			indices.remove(size - 1);
			size--;
			return temp.data;
		}
	}
	/**
	 * @param index The location of the element that is to be removed
	 * @return Returns the element removed
	 */	
	public E removeAt(int index) {
		//Removes the element at a specific location
		if (head == null || tail == null) {
			throw new NullPointerException();
		}
		
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		else if (index == size - 1) {
			E elem = removeLast();
			return elem;
		}
		
		else if (index == 0) {
			E elem = remove();
			return elem;
		}
		else {
			Node<E> temp = indices.get(index);
			Node<E> prev = temp.prev;
			Node<E> next = temp.next;
			prev.next = next;
			next.prev = prev;			
			indices.remove(index);
			size--;
			return temp.data;
		}
	}
	
	/**
	 * @param elem The Element that will be removed
	 * @return True Returns True only if the element is in the array. 
	 */
	public boolean remove(E elem) {
		//Removes the element by going through the array and finding it.
		if (head == null) {
			throw new NullPointerException();
		}
		
		int index = 0;
		boolean loop = false;
		
		while(index < size && !loop) {
			if (indices.get(index).data.equals(elem)) {
				removeAt(index);
				loop = true;
			}
			else {
				index++;
			}
		}
		
		return loop;
	}
	
	/**
	 * @return Creates a string in the form of a double linked lists
	 */
	public String toString() {
		//Creates a string in the form of Double linked lists
		String out = "[";
		Node<E> current = this.head;
		while (current.next != null) {
			out += current.data.toString() + ",";
			current = current.next;
		}
		out += current.data + "]" ;
		return out;
	}
	public static void main(String[] args){
		
}
	 
}