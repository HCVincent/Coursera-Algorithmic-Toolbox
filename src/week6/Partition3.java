package week6;

import java.util.*;
import java.io.*;

public class Partition3 {
	private static int partition3(int[] A) {
		int arrLength = A.length;
		if (arrLength < 3) {
			return 0;
		}
		int[] temp = new int[A.length];
		int sum = Arrays.stream(A).sum();
		if (sum == 0 || sum % 3 != 0)
			return 0;
		int result = isSubsetExist(A, arrLength - 1, sum / 3, sum / 3, sum / 3, temp) ? 1 : 0;
		return result;
	}

	public static boolean isSubsetExist(int[] S, int n, int a, int b, int c, int[] arr) {
		if (a == 0 && b == 0 && c == 0) {
			return true;
		}

		if (n < 0) {
			return false;
		}

		boolean A = false;
		if (a - S[n] >= 0) {
			arr[n] = 1; 
			A = isSubsetExist(S, n - 1, a - S[n], b, c, arr);
		}

		boolean B = false;
		if (!A && (b - S[n] >= 0)) {
			arr[n] = 2; 
			B = isSubsetExist(S, n - 1, a, b - S[n], c, arr);
		}

		boolean C = false;
		if ((!A && !B) && (c - S[n] >= 0)) {
			arr[n] = 3; 
			C = isSubsetExist(S, n - 1, a, b, c - S[n], arr);
		}

		return A || B || C;
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
