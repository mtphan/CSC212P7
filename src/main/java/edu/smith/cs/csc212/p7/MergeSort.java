package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.ListSlice;
import edu.smith.cs.csc212.adtr.real.DoublyLinkedList;
import edu.smith.cs.csc212.adtr.real.JavaList;
/**
 * My favorite sorting algorithm, complexity O(n^2)
 * @author Minh Phuong
 */
public class MergeSort {
	
	/**
	 * Combined to sorted lists. Recommended data structure is Array/ArrayList.
	 * @param lhs - left hand side list
	 * @param rhs - right hand side list
	 * @return a list merged in order.
	 */
	public static ListADT<Integer> combine(ListADT<Integer> lhs, ListADT<Integer> rhs) {
		ListADT<Integer> result = new JavaList<Integer>();
		int ri = 0;
		int li = 0;
		while (li<lhs.size() && ri<rhs.size()) {
			if (lhs.getIndex(li) < rhs.getIndex(ri)) {
				result.addBack(lhs.getIndex(li++));
			} else {
				result.addBack(rhs.getIndex(ri++));
			}
		}
		
		if (li<lhs.size()) {
			result.addAll(new ListSlice<Integer>(lhs, li, lhs.size()));
		} else if (ri<rhs.size()) {
			result.addAll(new ListSlice<Integer>(rhs, ri, rhs.size()));
		}
		return result;
	}
	
	/**
	 * Sorting a list using recursive merge sort.
	 * @param input - list to sort. Recommended data structure is Array/ArrayList
	 * @return list sorted in ascending order
	 */
	public static ListADT<Integer> recursiveMergeSort(ListADT<Integer> input) {
		if (input.size()<=1) {
			return input;
		}
		ListADT<Integer> lhs = new ListSlice<Integer>(input, 0, input.size()/2);
		ListADT<Integer> rhs = new ListSlice<Integer>(input, input.size()/2, input.size());
		
		// O(n/2)
		lhs = recursiveMergeSort(lhs);
		// O(n/2)
		rhs = recursiveMergeSort(rhs);
		
		// O(n)
		return combine(lhs, rhs);
	}
	
	/**
	 * Sorting a list using iterative merge sort.
	 * @param input - list to sort. Recommended data structure is Array/ArrayList
	 * @return list sorted in ascending order
	 */
	public static ListADT<Integer> iterativeMergeSort(ListADT<Integer> input) {
		DoublyLinkedList<ListADT<Integer>> data = new DoublyLinkedList<>();
		
		for (int item : input) {
			DoublyLinkedList<Integer> subList = new DoublyLinkedList<Integer>();
			subList.addBack(item);
			data.addBack(subList);
		}
		
		while (!data.isEmpty() && data.getBack() != data.getFront()) {
			ListADT<Integer> a = data.removeFront();
			
			ListADT<Integer> b = data.removeFront();
			ListADT<Integer> combined = combine(a,b);
			data.addBack(combined);
		}

		return data.getFront();
	}
}
