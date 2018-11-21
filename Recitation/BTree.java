package Recitation;

import java.util.*;
public class BTree<E> {
	private Node<E> root;
	private class Node<E> {
		private Node<E> left;
		private Node<E> right;
		private E data;
		public Node(E data, Node<E> left, Node<E> right) {
			this.left = left;
			this.right = right;
			this.data = data;
			}
		public Node(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
			}
		}
	public BTree() {
			root = null;
			}
	public int count() {
				return count(this.root);
				}
			public int height() {
				return height(this.root);
				}
			private int count(Node<E> localroot) {
				if (localroot == null) {
					return 0;
					}
				return 1 + count(localroot.left) + count(localroot.right);
				}
			private int height(Node<E> localroot) {
				if (localroot.left == null && localroot.right == null) {
					return 1;
					}
				return 1 + Math.max(height(localroot.left), height(localroot.right));
				}
			public String toString() {}}
