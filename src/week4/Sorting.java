package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sorting {
	static int i, j;

	private static void partition3(int[] a, int l, int r) {
		i = l - 1;
		j = r;
		int p = l - 1, q = r;
		int v = a[r];

		while (true) {

			// From left, find the first element greater than
			// or equal to v. This loop will definitely
			// terminate as v is last element
			while (a[++i] < v);

			// From right, find the first element smaller than
			// or equal to v
			while (v < a[--j])
				if (j == l)
					break;

			// If i and j cross, then we are done
			if (i >= j)
				break;

			// Swap, so that smaller goes on left greater goes
			// on right
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;

			// Move all same left occurrence of pivot to
			// beginning of array and keep count using p
			if (a[i] == v) {
				p++;
				temp = a[i];
				a[i] = a[p];
				a[p] = temp;

			}

			// Move all same right occurrence of pivot to end of
			// array and keep count using q
			if (a[j] == v) {
				q--;
				temp = a[q];
				a[q] = a[j];
				a[j] = temp;
			}
		}

		// Move pivot element to its correct index
		int temp = a[i];
		a[i] = a[r];
		a[r] = temp;

		// Move all left same occurrences from beginning
		// to adjacent to arr[i]
		j = i - 1;
		for (int k = l; k < p; k++, j--) {
			temp = a[k];
			a[k] = a[j];
			a[j] = temp;
		}

		// Move all right same occurrences from end
		// to adjacent to arr[i]
		i = i + 1;
		for (int k = r - 1; k > q; k--, i++) {
			temp = a[i];
			a[i] = a[k];
			a[k] = temp;
		}
	}

	private static int partition2(int[] a, int l, int r) {
		int x = a[l];
		int j = l;
		for (int i = l + 1; i <= r; i++) {
			if (a[i] <= x) {
				j++;
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		int t = a[l];
		a[l] = a[j];
		a[j] = t;
		return j;
	}

	private static void randomizedQuickSort(int[] a, int l, int r) {
		if (l >= r) {
			return;
		}
//		int k = random.nextInt(r - l + 1) + l;
//		int t = a[l];
//		a[l] = a[k];
//		a[k] = t;
		// use partition3
		partition3(a, l, r);

		// Recur
		randomizedQuickSort(a, l, j);
		randomizedQuickSort(a, i, r);
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		randomizedQuickSort(a, 0, n - 1);
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
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

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
