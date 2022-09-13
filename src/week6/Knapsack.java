package week6;

import java.util.Scanner;

public class Knapsack {

	static int optimalWeight(int W, int[] w) {
		// write you code here
		int result = 0;
		int[][] nums = new int[w.length + 1][W + 1];
		for (int i = 1; i <= w.length; i++) {
			for (int j = 1; j <= W; j++) {
				if (w[i - 1] > j) {
					nums[i][j] = nums[i - 1][j];
				} else {
					nums[i][j] = Math.max(w[i - 1] + nums[i - 1][j - w[i - 1]], nums[i - 1][j]);
				}
			}
		}
		result = nums[w.length][W];
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int W, n;
		W = scanner.nextInt();
		n = scanner.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = scanner.nextInt();
		}
		System.out.println(optimalWeight(W, w));
	}
}
