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
		if (s.charAt(sLength - 1) == t.charAt(tLength - 1)) {
			return editDistance(s.substring(0,s.length()-1), t.substring(0,t.length()-1));
		}
		return 1 + min(editDistance(s, t.substring(0,t.length()-1)), editDistance(s.substring(0,s.length()-1), t),
				editDistance(s.substring(0,s.length()-1), t.substring(0,t.length()-1)));

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
