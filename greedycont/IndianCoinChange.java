package com.chitkara.greedycont;

import java.util.Arrays;

public class IndianCoinChange {

	// amount = 39
	private static int minCoinsCount(int[] denominations, int amount) {
		// TODO Auto-generated method stub
		int count = 0;

		while (amount > 0) {
			int idx = Arrays.binarySearch(denominations, amount); // 39, idx -> -6
			System.out.println(idx);

			if (idx < 0) { // ki amount array mein ni mila
				// amount se choti value nikalo
				idx = Math.abs(idx) - 2; // idx -> 4
			}

			amount = amount - denominations[idx]; // amounnt = 39 - 20 = 19
			count++; // coins = 1
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] denominations = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

		// Arrays.sort(denominations);
		System.out.println("min coins hai " + minCoinsCount(denominations, 50));

	}

}
