package week2;

import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long result = 0;
        result = getFibonacciLastDigitNaive(n) * (getFibonacciLastDigitNaive(n - 1) +getFibonacciLastDigitNaive(n));
        result %= 10;
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
    
	private static int getFibonacciLastDigitNaive(long n) {
		if (n <= 1)
			return Math.toIntExact(n);

		int previous = 0;
		int current = 1;

		for (int i = 0; i < n - 1; ++i) {
			int tmp_previous = previous;
			previous = current;
			current = (tmp_previous + current) % 10;
		}

		return current % 10;
	}
}

