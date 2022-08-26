package week2;

import java.util.Scanner;

public class Fibonacci {
//	private static long calc_fib(int n) {
//		if (n <= 1)
//			return n;
//
//		return calc_fib(n - 1) + calc_fib(n - 2);
//	}

	private static long calc_fib(int n) {
		int[] li = new int[n];
		li[0] = 1;
		li[1] = 1;
		for(int i = 2; i < n; i++) {
			li[i] = li[i - 1] + li[i - 2];
		}
		return li[n-1];
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		System.out.println(calc_fib(n));
	}
}
