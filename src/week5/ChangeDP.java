package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChangeDP {
	private static int getChange(int m, int[] coins) {
		// write your code here
		int results[] = new int[m + 1];
		results[0] = 0;
		for (int i = 1; i <= m; i++) {
			results[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < coins.length; j++) {
				if(coins[j] <= i) {
					int sub_res = results[i - coins[j]];
					if(sub_res != Integer.MAX_VALUE && sub_res + 1 < results[i]) {
						results[i] = sub_res + 1;
					}
				}
			}
		}
		return results[m];
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int m = scanner.nextInt();
		int[] coins = { 4, 3, 1 };
		System.out.println(getChange(m, coins));

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
