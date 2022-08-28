package week2;

import java.util.*;

public class FibonacciSumLastDigit {
	private static long getFibonacciSum(long n) {
		int period = getPisanoPeriod(10);
		int new_n = Long.valueOf(n % period).intValue();
		if(n == 0 || new_n == 0) return 0;
		if(n == 1 || new_n == 1) return 1;

		long pre = 0;
		long temp = 0;
		long cur = 1;
		long res = 1;
		for (int i = 0; i < new_n - 1 ; i++) {
			temp = cur;
			cur = (pre + cur) % 10;
			pre = temp;
			res += cur;
			res %= 10;
		}
		return res;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long s = getFibonacciSum(n);
		System.out.println(s);
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

}
