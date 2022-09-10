package week5;

import java.util.*;

class EditDistance {
	public static int editDistance(String s, String t) {
		// write your code here
		int sLength = s.length();
		int tLength = t.length();
		if (sLength == 0)
			return tLength;
		if (tLength == 0)
			return sLength;
		int[][] nums = new int[sLength + 1][tLength + 1];
		for (int i = 0; i <= sLength; i++) {
			nums[i][0] = i;
		}
		for (int j = 0; j <= tLength; j++) {
			nums[0][j] = j;
		}

		for (int i = 1; i <= sLength; i++) {
			for (int j = 1; j <= tLength; j++) {
				int insertion = nums[i][j - 1] + 1;
				int deletion = nums[i - 1][j] + 1;
				int match = nums[i - 1][j - 1];
				int mismatch = nums[i - 1][j - 1] + 1;
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					nums[i][j] = min(insertion,deletion,match);
				} else {
					nums[i][j] = min(insertion,deletion,mismatch);
				}
			}
		}
		return nums[sLength][tLength];
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		String s = scan.next();
		String t = scan.next();

		System.out.println(editDistance(s, t));
	}

	static int min(int x, int y, int z) {
		if (x <= y && x <= z)
			return x;
		if (y <= x && y <= z)
			return y;
		else
			return z;
	}

}
