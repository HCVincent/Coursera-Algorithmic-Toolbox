package week2;

import java.util.Scanner;

public class Fibonacci {

	private static long calc_fib(int n) {
		if (n <= 1) {
			return n;
		} else {
			int[] li = new int[n + 1];
			li[0] = 0;
			li[1] = 1;
			for (int i = 2; i < n + 1; i++) {
				li[i] = li[i - 1] + li[i - 2];
			}
			return li[n];
		}

	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(calc_fib(n));
	}
}
