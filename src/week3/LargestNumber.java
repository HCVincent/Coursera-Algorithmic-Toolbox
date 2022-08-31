package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestNumber {
    private static final Scanner scanner = new Scanner(System.in);
	private static String largestNumber(String[] a) {
		// write your code here
		String result = "";
		for (int i = 0; i < a.length; i++) {
			String maxNum = a[i];
			for (int j = i; j < a.length; j++) {
				if (isBetter(a[j], maxNum)) {
					maxNum = a[j];
					a[j] = a[i];
					a[i] = maxNum;
				}
			}
			result += a[i];
		}
		return result;
	}

//    private static List<String> largestNumber(List<String> numbers) {
//        numbers.sort((o1, o2) -> {
//            for (int index = 0 ; index < o1.length() && index < o2.length() ; index++) {
//                if (o1.charAt(index) < o2.charAt(index)) {
//                    return 1;
//                } else if (o1.charAt(index) > o2.charAt(index)) {
//                    return -1;
//                }
//            }
//            String larger = o1.length() > o2.length() ? o1 : o2;
//            String smaller = o1.length() > o2.length() ? o2 : o1;
//            return o1.length() == o2.length()
//                    ? 0
//                    : Integer.compare(larger.charAt(smaller.length()), smaller.charAt(0))
//                        * Integer.compare(o2.length(), o1.length());
//        });
//
//        return numbers;
//    }
//	public static boolean isBetter(int a, int b) {
//		if (a == 1000)
//			return false;
//		if (b == 1000)
//			return true;
//		if (a == b)
//			return true;
//		int bigger = a > b ? a : b;
//		int smaller = a < b ? a : b;
//		int sDigits = String.valueOf(smaller).length();
//		int bDigits = String.valueOf(bigger).length();
//		int num = Double.valueOf(Math.pow(10, bDigits - sDigits)).intValue();
//		if (sDigits == bDigits)
//			return a > b ? true : false;
//		if (a > b) {
//			if (a / num == b) {
//				return isBetter(a % num, b);
//			}
//			return a / num > b ? true : false;
//		} else {
//			if (a == b / num) {
//				return isBetter(a, b % num);
//			}
//			return a > b / num ? true : false;
//		}
//	}

	public static Boolean isBetter(String a, String b) {
		for (int index = 0; index < a.length() && index < b.length(); index++) {
			if (a.charAt(index) < b.charAt(index)) {
				return false;
			} else if (a.charAt(index) > b.charAt(index)) {
				return true;
			}
		}

		String bigger = a.length() > b.length() ? a : b;
		String smaller = a.length() < b.length() ? a : b;
		int bDigits = bigger.length();
		int sDigits = smaller.length();
		int num = Double.valueOf(Math.pow(10, bDigits - sDigits)).intValue();

		if (a.length() == b.length())
			return false;
		if (bigger.charAt(smaller.length()) == smaller.charAt(0)) {
			return isBetter(Integer.valueOf(bDigits) % num +"", smaller);
		}
		int result = Integer.compare(bigger.charAt(smaller.length()), smaller.charAt(0));
		if ( a.length() < b.length()) result *= -1; 
		boolean res;
		if (result < 0) {
			res = false;
		} else
			res = true;
		return res;
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

}