package Recitation;

import java.util.ArrayList;
import java.util.List;

public class Sorting<E extends Comparable<E>> {
	
	public static int count = 0;

	public List<E> quickSort(ArrayList<E> l) {
		quickSortHelper(l, 0, l.size() - 1);
		return l;
	}

	private void quickSortHelper(ArrayList<E> l, int first, int last) {
		if (first < last) {
			int pivot = partition(l, first, last);
			quickSortHelper(l, first, pivot - 1);
			quickSortHelper(l, pivot + 1, last);
		}

	}

	private int partition(ArrayList<E> l, int first, int last) {
		count++;
		int mid = first + (last - first) / 2;
		bubbleSortThree(l, first, mid, last);
		int up = first;
		int down = last;

		do {
			while (up < last && l.get(first).compareTo(l.get(up)) >= 0) {
				up++;
			}
			while (down > first && l.get(first).compareTo(l.get(down)) < 0) {
				down--;
			}
			if (up < down) {
				swap(l, up, down);
			}

		} while (up < down);
		
		swap(l, first, down);
		
		return down;
	}

	private void bubbleSortThree(ArrayList<E> list, int f, int m, int l) {
		if (list.get(f).compareTo(list.get(m)) > 0) {
			swap(list, f, m);
		}
		if (list.get(m).compareTo(list.get(l)) > 0) {
			swap(list, m, l);
		}
		if (list.get(f).compareTo(list.get(m)) < 0) {
			swap(list, f, m);
		}
	}

	private void swap(ArrayList<E> l, int a, int b) {
		E temp = l.get(a);
		l.set(a, l.get(b));
		l.set(b, temp);
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		Sorting<Integer> s = new Sorting<Integer>();

		A.add(20);
		A.add(7);
		A.add(4);
		A.add(3);
		A.add(102);
		A.add(81);
		A.add(27);
		A.add(22);
		A.add(17);
		A.add(13);
		A.add(39);
		A.add(57);
		
		A.add(10);
		A.add(9);
		A.add(8);
		A.add(7);
		A.add(6);
		A.add(5);
		A.add(4);
		A.add(3);
		A.add(2);
		A.add(1);

		System.out.println(A);

		s.quickSort(A);

		System.out.println(A);
		
 		System.out.println("Number of partitions: " + count);

	}

}
