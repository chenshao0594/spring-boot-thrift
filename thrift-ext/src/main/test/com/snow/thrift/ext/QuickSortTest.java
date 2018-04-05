package com.snow.thrift.ext;

import java.util.Arrays;

public class QuickSortTest {

	public static void quickSort(int[] a, int low, int high) {
		if (low >= high) {
			return;
		}
		int middle = partition(a, low, high);
		quickSort(a, low, middle - 1);
		quickSort(a, middle + 1, high);
	}

	public static int partition(int[] a, int low, int high) {
		int boundary = low;
		int pivot = a[high];
		for (int i = low; i < high; i++) {
			if (a[i] < pivot) {
				exchange(a, i, boundary);
				boundary = boundary + 1;
			}
		}
		exchange(a, boundary, high);
		return boundary;

	}

	public static void exchange(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] s = new int[] { 99, 1, 34, 5, 5, 2, 34, 99, 342, 6 };
		long t = System.currentTimeMillis();
		QuickSortTest.quickSort(s, 0, s.length - 1);
		System.out.println(System.currentTimeMillis() - t);
		System.out.println(Arrays.toString(s));

	}

}
