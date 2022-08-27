package week2;

import java.util.*;

public class FibonacciLastDigit {
	private static int getFibonacciLastDigitNaive(int n) {
		// 0 ¡Ü n ¡Ü 10^5
		if (n <= 1)
			return n;

		int previous = 0;
		int current = 1;

		for (int i = 0; i < n - 1; ++i) {
			int tmp_previous = previous;
			previous = current % 10;
			current = tmp_previous + current % 10;

		}

		return current % 10;
	}
	
	private static int getFibonacciLastDigitNaive(long n) {
		// 0 ¡Ü n ¡Ü 10^5
		if (n <= 1)
			return Math.toIntExact(n);

		int previous = 0;
		int current = 1;

		for (int i = 0; i < n - 1; ++i) {
			int tmp_previous = previous;
			previous = current % 10;
			current = tmp_previous + current % 10;

		}

		return current % 10;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		int c = getFibonacciLastDigitNaive(n);
		System.out.println(c);
	}
}
