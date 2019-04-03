package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;

/**
 * Simple sorting algorithm with time complexity O(n^2)
 * @author Minh Phuong
 */
public class SelectionSort {
	
	/**
	 * Sort a list of Integer in ascending order using selection sort algorithm
	 * @param input - list to sort
	 */
	public static void selectionSort(ListADT<Integer> input) {
		int N = input.size();
		
		for (int i=0; i<N-1; i++) {
			int iMin = i;
			for (int j=i+1; j<N; j++) {
				if (input.getIndex(iMin) > input.getIndex(j)) {
					iMin = j;
				}
			}	
			input.swap(iMin, i);
		}	
	}

}