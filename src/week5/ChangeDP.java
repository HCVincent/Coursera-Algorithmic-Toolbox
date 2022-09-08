package week5;

import java.util.Scanner;

public class ChangeDP {
	private static int getChange(int m, int[] coins) {
		// write your code here
		if (m == 0)
			return 0;
		int res = Integer.MAX_VALUE;

		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= m) {
				int sub_res = getChange(m-coins[i], coins);
				if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
					res = sub_res + 1;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int[] coins = { 4, 3, 1 };
		System.out.println(getChange(m, coins));

	}
}
