package week6;

import java.util.Scanner;

public class PlacingParentheses {
	private static long[] minAndMax(int i, int j, char[] op, long[][] m, long[][] M) {
		long min = Integer.MAX_VALUE;
		long max = Integer.MIN_VALUE;
		for (int k = i; k < j; k++) {
			long a = eval(M[i][k], M[k + 1][j], op[k]);
			long b = eval(M[i][k], m[k + 1][j], op[k]);
			long c = eval(m[i][k], M[k + 1][j], op[k]);
			long d = eval(m[i][k], m[k + 1][j], op[k]);
			min = Math.min(min, Math.min(a, Math.min(b, Math.min(c, d))));
			max = Math.max(max, Math.max(a, Math.max(b, Math.max(c, d))));
		}
		return new long[] { min, max };
	}

	private static long getMaximValue(String exp) {
		char[] charArr = exp.toCharArray();
		int n = exp.length() / 2 + 1;
		long[][] max = new long[n][n];
		long[][] min = new long[n][n];
		char[] op = new char[exp.length() - n];
		for (int i = 0, t = 0; i < charArr.length; i += 2, t++) {
			max[t][t] = Character.getNumericValue(charArr[i]);
			min[t][t] = Character.getNumericValue(charArr[i]);
		}
		for (int i = 1, t = 0; i < charArr.length; i += 2, t++) {
			op[t] = charArr[i];
		}

		for (int s = 1; s < n; s++) {
			for (int i = 0; i < n - s; i++) {
				int j = i + s;
				long mM[] = minAndMax(i, j, op, min, max);
				min[i][j] = mM[0];
				max[i][j] = mM[1];
			}
		}

		return max[0][n - 1];
	}

	private static long eval(long a, long b, char op) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else if (op == '*') {
			return a * b;
		} else {
			assert false;
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String exp = scanner.next();
		System.out.println(getMaximValue(exp));
	}
}
