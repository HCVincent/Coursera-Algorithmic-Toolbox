package week2;

import java.util.*;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        BigInteger previous = BigInteger.ZERO;
        BigInteger current  = BigInteger.ONE;
        int result = 0;

        for (int i = 0; i < n - 1; ++i) {
        	BigInteger tmp_previous = previous;
            previous = current;
            long startTime = System.nanoTime();
            current = tmp_previous.add(current);
            result = current.mod(BigInteger.TEN).intValue();
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Execution time in milliseconds: " + timeElapsed);
            
        }

        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

