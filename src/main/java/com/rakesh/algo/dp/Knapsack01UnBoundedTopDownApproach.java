package com.rakesh.algo.dp;

public class Knapsack01UnBoundedTopDownApproach {

	public static void main(String[] args) {
		int[] weightArray = new int[] { 2, 4, 1, 3, 10, 1, 1 };
		int[] valueArray = new int[] { 11, 4, 20, 16, 5, 17, 19 };
		int maxWeight = 7;
		int[][] dp = new int[weightArray.length][maxWeight + 1];
		int maxValue = getMaxValueKnapsack(weightArray, valueArray, maxWeight, 0, dp);
		System.out.println(maxValue);

	}

	private static int getMaxValueKnapsack(int[] weightArray, int[] valueArray, int capacity, int index, int[][] dp) {
		if (index > (weightArray.length - 1)) {
			return 0;
		}
		if (dp[index][capacity] != 0) {
			return dp[index][capacity];
		}
		int maxVal = 0;
		// if current item is included
		int val1 = 0;
		if (capacity >= weightArray[index]) {
			val1 = valueArray[index] + getMaxValueKnapsack(weightArray, valueArray, capacity - weightArray[index], index, dp);
		}
		// if current item is not included
		int val2 = getMaxValueKnapsack(weightArray, valueArray, capacity, index + 1, dp);

		maxVal = Math.max(val1, val2);
		return maxVal;
	}

}
