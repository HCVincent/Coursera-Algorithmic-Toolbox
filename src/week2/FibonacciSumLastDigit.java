package week2;

import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSum(long n) {
        if (n <= 1)
            return n;

        long sum = 0;

        for (long i = 0; i < n + 1; ++i) {
            int last = getFibonacciLastDigitNaive(i);
            sum += last;
            sum %= 10;
            System.out.println(sum);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
    
	private static int getFibonacciLastDigitNaive(long n) {
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
}

