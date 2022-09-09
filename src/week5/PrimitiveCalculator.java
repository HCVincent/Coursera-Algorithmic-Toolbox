package week5;

import java.util.*;

public class PrimitiveCalculator {
	private static List<Integer> optimal_sequence(int n) {
		List<Integer> sequence = new ArrayList<Integer>();
		int[] res = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			res[i] = res[i - 1] + 1;
			
			if (i % 2 == 0) {
				res[i] = Math.min(1 + res[i / 2], res[i]);
			}	
			
			if (i % 3 == 0) {
				res[i] = Math.min(1 + res[i / 3], res[i]);
			}
		}

		while (n > 0) {
			sequence.add(n);
			if (res[n] - 1 == res[n - 1])
				n--;
			else if ((n % 2 == 0) && res[n] == res[n / 2] + 1)
				n /= 2;
			else if ((n % 3 == 0) && res[n] == res[n / 3] + 1)
				n /= 3;
		}
		Collections.reverse(sequence);
		return sequence;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> sequence = optimal_sequence(n);
		System.out.println(sequence.size() - 1);
		for (Integer x : sequence) {
			System.out.print(x + " ");
		}
	}
}
