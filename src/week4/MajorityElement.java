package week4;

import java.util.*;
import java.io.*;

public class MajorityElement {
	private static int getMajorityElement(int[] a, int left, int right) {
		if (left == right) {
			return a[left];
		}
		// write your code here
		int mid = (left + right) / 2;
		int l = getMajorityElement(a, left, mid);
		int r = getMajorityElement(a, mid + 1, right);
		if (l == r)
			return l;
		int lCount = count(a, left, right, l);
		int rCount = count(a, left, right, r);
		return lCount > rCount ? l : r;
	}

	public static int count(int[] a, int left, int right, int c) {
		int res = 0;
		for (int i = left; i <= right; i++) {
			if (a[i] == c)
				res++;
		}
		return res;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		if (count(a, 0, a.length - 1, getMajorityElement(a, 0, a.length - 1)) * 2 <= a.length) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
