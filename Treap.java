//I pledge my honor that I have abided by the Stevens Honor System
//Colby Chaffin

package treap;

import java.util.Random;

public class Treap<E extends Comparable<E>> {

	private static class Node<E> {
		// Data fields for Node class
		public E data;
		public int priority;
		public Node<E> left;
		public Node<E> right;

		// Constructor
		/**
		 * Creates a new Node with the given data and priority with children being null.
		 * 
		 * @param data The data of type E
		 *            
		 * @param priority The priority number
		 *            
		 **/
		public Node(E data, int priority) {
			if (data == null) {
				throw new NullPointerException("Data in a node can not be null");
			}
			this.data = data;
			this.priority = priority;
		}

		// Methods
		/**
		 * Rotates the Treap to the right and updates the priority and data accordingly.
		 * 
		 **/
		void rotateRight() {
			Node<E> temp = new Node<E>(this.data, this.priority);
			if (this.left != null) {
				if (this.right != null) {
					temp.right = this.right;
				}
				if (this.left.right != null) {
					temp.left = this.left.right;
				}

				this.data = this.left.data;
				this.priority = this.left.priority;

				this.right = temp;
				if (this.left.left != null) {
					this.left = this.left.left;
				} 
				else {
					this.left = null;
				}
			}
		}

		/**
		 * Rotates the Treap to the left and updates the priority and data accordingly.
		 * 
		 **/
		void rotateLeft() {
			Node<E> temp = new Node<E>(this.data, this.priority);
			if (this.right != null) {
				if (this.left != null) {
					temp.left = this.left;
				}
				if (this.right.left != null) {
					temp.right = this.right.left;
				}

				this.data = this.right.data;
				this.priority = this.right.priority;

				this.left = temp;
				if (this.right.right != null) {
					this.right = this.right.right;
				} 
				else {
					this.right = null;
				}
			}
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	// Data fields for Treap
	private Random priorityGenerator;
	private Node<E> root;
	
	// Data fields for Other methods
	protected boolean addReturn;
	protected boolean deleteReturn;

	// Constructors
	/**
	 * Creates an empty Treap
	 * 
	 **/
	public Treap() {
		this.priorityGenerator = new Random();
		root = null;
	}

	/**
	 * Creates an empty Treap and uses seed in priorityGenerator
	 * 
	 * @param seed The seed key  
	 * 
	 **/
	public Treap(long seed) {
		this.priorityGenerator = new Random(seed);
		root = null;
	}

	// Treap Class Methods
	/**
	 * Creates a new Node with data and a random priority and puts it into 
	 * the correct place in the Treap
	 * 
	 * @param key The key to be added to the Treap          
	 * 
	 * @return True or False depending if a key was added to the Treap successfully
	 * 
	 **/
	
	public boolean add(E key) {
		return add(key, priorityGenerator.nextInt());
	}
	
	public Node<E> add(Node<E> root, Node<E> new_leaf) {
		if (root == null) {
			addReturn = true;
			if(this.root == null) {
				this.root = new_leaf;
			} else {
				root = new_leaf;
			}
			return new_leaf;
		} 
		else if (new_leaf.data.compareTo(root.data) < 0) {
			root.left = add(root.left, new_leaf);
			if (root.left.priority > root.priority) {
				root.rotateRight();
			}

		} 
		else if (new_leaf.data.compareTo(root.data) > 0) {
			root.right = add(root.right, new_leaf);
			if (root.right.priority > root.priority) {
				root.rotateLeft();
			}

		} 
		else {
			addReturn = false;
		}
		return root;
	}
	
	public boolean add(E key, int priority) {
		Node<E> leaf = new Node<E>(key, priority);
		add(this.root, leaf);
		return addReturn;
	}

	/**
	 * Deletes the node constraining the key and rearranges the Treap
	 * to maintain the structure
	 * 
	 * @param key The key to be removed from the Treap
	 * 
	 * @return True or False depending if a key was deleted from the Treap
	 * 
	 **/
	public boolean delete(E key) {
		root = deleting(root, key);
		return deleteReturn;
	}

	// Helper for delete
	private Node<E> deleting(Node<E> root, E key) {
		if (root == null) {
			deleteReturn = false;
			return null;
		} 
		else if (key.compareTo(root.data) < 0) {
			root.left = deleting(root.left, key);
		} 
		else if (key.compareTo(root.data) > 0) {
			root.right = deleting(root.right, key);
		} 
		else {
			deleteReturn = true;
			if (root.left == null && root.right == null) {
				return null;
			} 
			else if (root.right == null) {
				root.rotateRight();
				root.right = deleting(root.right, key);
			} 
			else if (root.left == null) {
				root.rotateLeft();
				root.left = deleting(root.left, key);
			} 
			else {
				if (root.left.priority < root.right.priority) {
					root.rotateRight();
					root.right = deleting(root.right, key);
				} 
				else {
					root.rotateLeft();
					root.left = deleting(root.left, key);
				}
			}
		}
		return root;
	}

	/**
	 * Finds a node with the given key in the Treap and returns the key.
	 * 
	 * @param key The key to be found from the Treap
	 * 
	 * @return The found key or null if the key is not found
	 * 
	 **/
	public E find(E key) {
		if (key == null) {
			throw new NullPointerException("key cannot be null");
		}
		return find(root, key);
	}

	// Helper for find
	private E find(Node<E> root, E key) {
		E foundKey = null;
		if (root.data == key) {
			return key;
		}
		if (root.left != null) {
			foundKey = find(root.left, key);
		}
		if (root.right != null && foundKey == null) {
			foundKey = find(root.right, key);
		}
		return foundKey;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}
	
	//Helper for toString
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		for (int i = 1; i < depth; i++) {
			sb.append("  ");
		}
		if (node == null) {
			sb.append("null\n");
		} 
		else {
			sb.append("(key=");
			sb.append(node.toString());
			sb.append(", ");
			sb.append("priority=");
			sb.append(node.priority);
			sb.append(")");
			sb.append("\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}	
	public static void main(String args[]) {
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4,19);
		testTree.add(2,31);
		testTree.add(6,70);;
		testTree.add(1,84);
		testTree.add(3,12);
		testTree.add(5,83);
		testTree.add(7,26);
		System.out.println(testTree.toString());
		
		Treap<String> testString = new Treap<String>();
		testString.add("p",99);
		testString.add("g",80);
		testString.add("a",60);
		testString.add("j",65);
		testString.add("r",40);
		testString.add("u",75);
		testString.add("z",47);
		testString.add("w",32);
		testString.add("v",21);
		testString.add("x",25);
		System.out.println(testString);
		testString.delete("z");
		System.out.println(testString);
	}
}



