package week3;

import java.util.Scanner;
import java.util.stream.IntStream;

public class LargestNumber {
	private static String largestNumber(String[] a) {
		// write your code here
		String result = "";
		for (int i = 0; i < a.length; i++) {
			int maxNum = Integer.valueOf(a[i]);
			for (int j = i; j < a.length; j++) {
				if (isBetter(Integer.valueOf(a[j]), maxNum)) {
					maxNum = Integer.valueOf(a[j]);
					a[j] = a[i];
					a[i] = String.valueOf(maxNum);
				}
			}
			result += a[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.next();
		}
		System.out.println(largestNumber(a));
	}

	public static boolean isBetter(int a, int b) {
		if (a == 1000)
			return false;
		if (b == 1000)
			return true;
		if (a == b)
			return true;
		int bigger = a > b ? a : b;
		int smaller = a < b ? a : b;
		int sDigits = String.valueOf(smaller).length();
		int bDigits = String.valueOf(bigger).length();
		int num = Double.valueOf(Math.pow(10, bDigits - sDigits)).intValue();
		if (sDigits == bDigits)
			return a > b ? true : false;
		if (a > b) {
			if (a / num == b) {
				return isBetter(a % num, b);
			}
			return a / num > b ? true : false;
		} else {
			if (a == b / num) {
				return isBetter(a, b % num);
			}
			return a > b / num ? true : false;
		}
	}

}
