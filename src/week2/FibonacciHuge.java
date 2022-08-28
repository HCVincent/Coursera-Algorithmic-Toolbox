package week2;

import java.util.Scanner;

public class FibonacciHuge {
	private static long getFibonacciHugeNaive(long n, long m) {
		long pisanoPeriod = getPisanoPeriod(m);
	     
	    n = n % pisanoPeriod;
		
		if(n == 0) return 0;
		if(n == 1) return 1;
		long pre = 0;
		long cur = 1;
		long temp = 0;
		for (int i = 0; i < n - 1; i++) {
			temp = cur;
			cur = (pre + cur) % m;
			pre = temp;
		}
		return cur % m;
	}

	private static int getPisanoPeriod(long m) {
		long pre = 0;
		long curr = 1;
		int res = 0;
		long temp = 0;
		
		for (int i = 0; i < m * m; i++) {
			temp = curr;
			curr = (pre + curr) % m;
			pre = temp;

			if (i != 0 && pre == 0 && curr == 1) {
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
