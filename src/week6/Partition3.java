//package week6;

import java.util.*;
import java.io.*;

public class Partition3 {
	private static int partition3(int[] A) {
		int arrLength = A.length;
		if (arrLength < 3) {
			return 0;
		}
		int sum = Arrays.stream(A).sum();
		if (sum == 0 || sum % 3 != 0)
			return 0;
		int[][] nums = new int[sum / 3 + 1][arrLength + 1];
		int count = 0;
		for (int i = 1; i < sum / 3 + 1; i++) {
			for (int j = 1; j < arrLength + 1; j++) {
				nums[i][j] = nums[i][j - 1];
				if (A[j - 1] <= i) {
					int temp = nums[i - A[j - 1]][j - 1] + A[j - 1];
					if (temp > nums[i][j]) {
						nums[i][j] = temp;
					}
				}
				if (nums[i][j] == sum / 3) {
					count++;
				}
			}
		}
		if(count < 3) return 0;
		else return 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		System.out.println(partition3(A));
	}
}
