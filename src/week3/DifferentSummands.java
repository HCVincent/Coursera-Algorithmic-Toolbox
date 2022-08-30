package week3;

import java.util.*;

public class DifferentSummands {
	private static List<Integer> optimalSummands(int n) {

		List<Integer> summands = new ArrayList<Integer>();
		// write your code here
		if(n == 2) {
			summands.add(2);
			return summands;
		}
		for (int i = 1; n > 0; i++) {
			n -= i;
			summands.add(i);
			if (n >= i + 1 && n < i + 1 + i + 2) {
				summands.add(n);
				break;
			}
		}
		return summands;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> summands = optimalSummands(n);
		System.out.println(summands.size());
		for (Integer summand : summands) {
			System.out.print(summand + " ");
		}
	}
}
