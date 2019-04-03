package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;

/**
 * Simple sorting algorithm with complexity O(n^2)
 * @author Minh Phuong
 */
public class InsertionSort {
	/**
	 * Sort a list of Integer in ascending order using insertion sort algorithm
	 * @param input - list to sort
	 */
	public static void insertionSort(ListADT<Integer> input) {
		int N = input.size();
		
		for (int i=1; i<N; i++) {
			int testValue = input.getIndex(i);
			for (int j=i-1; j>=0; j--) {
				//basically a swap up that will break when testValue > input[j].
				if (testValue < input.getIndex(j)) {
					input.setIndex(j+1, input.getIndex(j));
				} else break;
				input.setIndex(j, testValue);				
			}
			
		}
	}
}