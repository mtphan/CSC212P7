package edu.smith.cs.csc212.p7;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.DoublyLinkedList;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class TestSorting {
	/**
	 * This is useful for testing whether sort algorithms work!
	 * @param items - the list of integers.
	 * @return true if it is sorted, false if not.
	 */
	private static boolean checkSorted(ListADT<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.getIndex(i) > items.getIndex(i+1)) {
				System.err.println("items out of order: "+items.getIndex(i)+", "+items.getIndex(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Here's some data!
	 */
	private static int[] data = {9,8,7,6,5,4,3,2,1};
	
	@Test
	public void testBubbleSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		System.out.println(sortMe.toJava());
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), data.length);
	}
	
	@Test
	public void testClassBubbleSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		Assert.assertEquals(sortMe.size(), 9);
	}
	
	@Test
	public void testSelectionSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		System.out.println(sortMe.toJava());
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));		
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), data.length);
		// check it is the original size
		Assert.assertEquals(sortMe.size(), 9);

	}

	@Test
	public void testClassSelectionSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		Assert.assertEquals(sortMe.size(), 9);
	}
	
	@Test
	public void testInsertionSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		InsertionSort.insertionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		System.out.println(sortMe.toJava());
		InsertionSort.insertionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));		
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), data.length);
	}

	@Test
	public void testClassInsertionSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		InsertionSort.insertionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		Assert.assertEquals(sortMe.size(), 9);
	}
	
	@Test
	public void testSlice() {
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		int mid = sortMe.size()/2;
		ListADT<Integer> leftSlice = sortMe.slice(0, mid);
		ListADT<Integer> rightSlice = sortMe.slice(mid, sortMe.size());
		
		Assert.assertEquals(leftSlice.toJava(), Arrays.asList(35, 88, 11, 47));
		Assert.assertEquals(rightSlice.toJava(), Arrays.asList(14, 24, 41, 62, 27));
		
		Assert.assertEquals(14, (int) rightSlice.removeFront());
		Assert.assertEquals(4, rightSlice.size());
		Assert.assertEquals(27, (int) rightSlice.removeBack());
		Assert.assertEquals(3, rightSlice.size());
	}
	
	@Test
	public void testCombine() {
		ListADT<Integer> lhs = new DoublyLinkedList<>(Arrays.asList(11, 14, 35, 47, 88));
		ListADT<Integer> rhs = new DoublyLinkedList<>(Arrays.asList(24, 27, 41, 62));
		Assert.assertTrue(checkSorted(lhs));
		Assert.assertTrue(checkSorted(rhs));
		ListADT<Integer> sorted = MergeSort.combine(lhs, rhs);
		Assert.assertEquals(new DoublyLinkedList<>(Arrays.asList(11, 14, 24, 27, 35, 41, 47, 62, 88)), sorted);
		Assert.assertTrue(checkSorted(sorted));
	}

	@Test
	public void testRecursiveMergeSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		sortMe = MergeSort.recursiveMergeSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		System.out.println(sortMe.toJava());
		sortMe = MergeSort.recursiveMergeSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));		
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), data.length);
	}
	
	@Test
	public void testClassRecursiveMergeSort() {
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		sortMe = MergeSort.recursiveMergeSort(sortMe);
		Assert.assertEquals(sortMe.toJava(), (new JavaList<>(Arrays.asList(11, 14, 24, 27, 35, 41, 47, 62, 88)).toJava()));
		Assert.assertTrue(checkSorted(sortMe));
		Assert.assertEquals(sortMe.size(), 9);
	}
	
	@Test
	public void testIterativeMergeSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		sortMe = MergeSort.iterativeMergeSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		System.out.println(sortMe.toJava());
		sortMe = MergeSort.iterativeMergeSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));		
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), data.length);
	}
	
	@Test
	public void testClassIterativeMergeSort() {
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27, 35));
		
		sortMe = MergeSort.iterativeMergeSort(sortMe);
		Assert.assertEquals(sortMe.toJava(), (new JavaList<>(Arrays.asList(11, 14, 24, 27, 35, 35, 41, 47, 62, 88)).toJava()));
		Assert.assertTrue(checkSorted(sortMe));
		Assert.assertEquals(sortMe.size(), 10);
	}
}
