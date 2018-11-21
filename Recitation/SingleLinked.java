package Recitation;

public class SingleLinked<E> {
	private Node<E> head;
	private int size;
	
	class Node<E>{
		private E data;
		private Node<E> next;
		Node (){
			data = null;
			next = null;}
		Node (E item){
			data = item;
			next = null;}
		Node (E item, Node<E> next){
			data = item;
			this.next = next;}}
	SingleLinked (){
		head = null;}	
	//Setter
	SingleLinked (Node<E> node){
		head = node;}
	//Setter
	SingleLinked (E item){
		head = new Node<E>(item);}
	//Getters
	public int size() {
		return this.size;}
	//Getters
	public E headData() {
		return head.data;}
	
	
	public boolean append(E item) {
		Node<E> current = head;
		Node<E> add = new Node<E>(item);
		while (current.next != null) {
			current = current.next;
		}
		current.next = add;
		add.next = null;
		size ++;
		return true;
	}
	
	public boolean append(Node<E> node) {
		Node<E> current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;
		node.next = null;
		size ++;
		return true;
	}
	
	public boolean add(E item) {
		Node<E> add = new Node<E>(item);
		Node<E> headTemp = head;
		add.next = headTemp;
		head = add;
		size++;
		return true;
	}
	
	public boolean add(Node<E> node) {
		Node<E> headTemp = head;
		node.next = headTemp;
		head = node;
		size ++;
		return true;
	}
	
	public boolean add(int index, E item) {
		if (index > size || index <0) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			return this.add(item);
		} else if (index == size) {
			return this.append(item);
		} else {
			Node<E> current = head;
			Node<E> add = new Node<E>(item);
			for (int i = 1; i<index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next.next;
			current.next = add;
			add.next = current.next.next;
			add.next = temp;
			size ++;
			return true;
		}
		
	}
	
	public boolean isSingleton(Node<E> node) {
		return node.next==null;
	}
	public boolean allEven (Node<Integer> node) {
		if (node==null) {
			return true;
		}
		if (node.data%2==0) {
			return allEven(node.next);
		} else {
			return false;
		}
	}
	
	public int sumL(Node<Integer> node) {
		Node<Integer> current = node;
		int sum = 0;
		while (current != null) {
			sum += current.data;
			current = current.next;

		}
		return sum;
	}
	
	public String toString() {
		Node<E> current = head;
		String list = "";
		while (current != null) {
			list += current.data;
			if (current.next != null) {
				list += ", ";
			}
			current = current.next;
		}
		return list;
	}
	public static void main(String[] args) {
		SingleLinked<Integer> lst = new SingleLinked<Integer>(1);
		lst.append(2);
		lst.append(3);
		lst.append(4);
		lst.append(5);
		lst.add(10);
		lst.add(3,50);
		System.out.println(lst);	
}
	
		
		
}


