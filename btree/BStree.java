package btree;

public class BStree<E extends Comparable <E>> extends BinTree<E> {
	BStree() {
		super();
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	private boolean find(E key, Node<E>n) {
		if(n == null) {
			return false;
		} else {
			int comparison = n.data.compareTo(key);
			if (comparison == 0) {
				return true;
			} else {
				if(comparison < 0) {
					return find(key, n.right);
				} else  {
					return find(key, n.left);
				}
			}
		}
	}
	private E max(Node<E> n) {
		if(n.right == null) {
			return n.data;
		} else {
			return max(n.right);
			
			}
		}
	public E max() {
		if(root == null) {
			throw new IllegalStateException();
		} else {
			return max(root);
		}
		
	}
	private Node<E> add(E key, Node<E>n) {
		if(n == null) {
			return new Node<E>(key);
			
		} else {
			int comparison = key.compareTo(n.data);
			if(comparison == 0) {
				throw new IllegalArgumentException();
			} else {
				if(comparison < 0) {
					add(key, n.right);
				} else {
					add(key, n.left);
				}
			}
		}
	}
	public E removeMax() {
		if(root == null) {
			throw new IllegalStateException();
		} else {
			if(root.right == null) {
				E temp = root.data;
				root = root.left;
				return temp;
			}
		}
	}
	public void add(E key) {
		add(key, root);
	}
	
	public boolean find(E key) {
		return find(key, root);
	}
}
