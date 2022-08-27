//package week2;

import java.util.Scanner;

public class FibonacciHuge {
	private static long getFibonacciHugeNaive(long n, int m) {
		n %= getPisanoPeriod(m);
		
		if(n == 0) return 0;
		if(n == 1) return 1;
		long res = 0;
		long pre = 0;
		long cur = 1;
		long temp = 0;
		for (int i = 0; i < n - 1; i++) {
			temp = pre;
			pre = cur;
			cur = (temp + cur) % m;
			res = cur;
		}
		return res;
	}

	private static long getPisanoPeriod(long m) {
		long res = 0;
		long pre = 0;
		long cur = 1;
		long temp = 0;
		for (int i = 0; i < m * 2; i++) {
			temp = pre;
			pre = cur;
			cur = (temp + cur) % m;

			if (i != 0 && pre == 0 && cur == 1) {
				res = i + 1;
				break;
			}
		}
		return res;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		int m = scanner.nextInt();
		System.out.println(getFibonacciHugeNaive(n, m));
	}

//	private static long calc_fib(long n) {
//		if (n <= 1) {
//			return n;
//		} else {
//			long[] li = new long[(int) (n + 1)];
//			li[0] = 0;
//			li[1] = 1;
//			for (int i = 2; i < n + 1; i++) {
//				li[i] = li[i - 1] + li[i - 2];
//			}
//			return li[(int) n];
//		}
//	}

}
