package com.chitkara.greedycont;

import java.util.Arrays;

public class BinarySearchBuiltInDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1, 2, 5, 10, 20, 50};
		
		int search = 15;
		
		int ind = Arrays.binarySearch(arr, search);
		System.out.println(ind);
		ind = Math.abs(ind) - 1;
		int searchSeSmaller = arr[ind];
		System.out.println(searchSeSmaller);
		
		/*
		If element not present
		ind = -(search ki expected position) - 1
		
		immediate small element than searched el
		abs(ind) - 2
		
		immediate larger element
		abs(ind) - 1
		*/
	}

}
