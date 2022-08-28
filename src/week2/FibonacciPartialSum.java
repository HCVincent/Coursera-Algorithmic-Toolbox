package week2;

import java.util.*;

public class FibonacciPartialSum {
	private static long getFibonacciPartialSum(long from, long to) {
		long sum = 0;
		from %= 60;
		to %= 60;
		if (from > to) {
			sum += getFibonacciSum(to);
			sum += (10 - (getFibonacciSum(from-1)));
		} else if (from == to) {
			sum = getFibonacciLastDigitNaive(Long.valueOf(from).intValue());
		} else {
			if(from == 0) from ++;
			sum = getFibonacciSum(to) - getFibonacciSum(from - 1);
		}
		if (sum < 0)
			sum += 10;
		sum %= 10;
		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long from = scanner.nextLong();
		long to = scanner.nextLong();
		System.out.println(getFibonacciPartialSum(from, to));
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

	private static long getFibonacciSum(long n) {
		int period = getPisanoPeriod(10);
		int new_n = Long.valueOf(n % period).intValue();
		if (n == 0 || new_n == 0)
			return 0;
		if (n == 1 || new_n == 1)
			return 1;

		long pre = 0;
		long temp = 0;
		long cur = 1;
		long res = 1;
		for (int i = 0; i < new_n - 1; i++) {
			temp = cur;
			cur = (pre + cur) % 10;
			pre = temp;
			res += cur;
			res %= 10;
		}
		return res;

	}
	
	private static int getFibonacciLastDigitNaive(int n) {
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
}
