package week2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciHuge {
	private static long getFibonacciHugeNaive(long n, int m) {
		// Getting the period
	    long pisanoPeriod = getPisanoPeriod(m);
	     
	    n = n % pisanoPeriod;
	     
	    long prev = 0;
	    long curr = 1;
	    long temp = 0;
	     
	    if (n == 0)
	        return 0;
	    else if (n == 1)
	        return 1;
	     
	    for(int i = 0; i < n - 1; i++)
	    {
	        temp = curr;
	        curr = (prev + curr) % m;
	        prev = temp;
	    }
	    return curr % m;
		
	}
	
	private static long getPisanoPeriod(long m) {
		long prev = 0;
	    long curr = 1;
	    long res = 0;
	    long temp = 0;
	     
	    for(int i = 0; i < m * 2; i++)
	    {
	        temp = curr;
	        curr = (prev + curr) % m;
	        prev = temp;
	         
	        if (prev == 0 && curr == 1 && i != 0) {
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
