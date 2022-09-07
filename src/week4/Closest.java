package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Closest {

	static class Point implements Comparable<Point> {
		long x, y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
		}
	}

	static double minimalDistance(int[] x, int y[]) {
		double ans = Double.POSITIVE_INFINITY;
		// write your code here

		return ans;
	}

	static double minimalDistance(Point[] pList, int startIndex, int endIndex) {
		double ans = Double.POSITIVE_INFINITY;
		// write your code here
		if (startIndex + 1 == endIndex)
			return Math.sqrt(Math.pow(pList[0].x - pList[1].x, 2) + Math.pow(pList[0].y - pList[1].y, 2));
		int mid = startIndex + (endIndex - startIndex) / 2;
		double dl = minimalDistance(pList, startIndex, mid);
		double dr = minimalDistance(pList, mid, endIndex);
		
		double d = Math.min(dl, dr);
		Point midPoint = pList[mid];
		Point[] pListTemp = new Point[endIndex];
		int tempSize = 0;
		for (int i = 0; i < endIndex; i++) {
			if (Math.abs(pList[i].x - midPoint.x) < d) {
				pListTemp[tempSize] = pList[i];
				tempSize++;
			}
		}
		ans = d;
		int size = tempSize;
		Arrays.sort(pListTemp, 0, tempSize, Comparator.comparing(p -> p.y));
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size && (pListTemp[j].y - pListTemp[i].y < ans); ++j) {
				if (Math.sqrt(Math.pow(pListTemp[i].x - pListTemp[j].x, 2)
						+ Math.pow(pListTemp[i].y - pListTemp[j].y, 2)) < ans) {
					ans = Math.sqrt(Math.pow(pListTemp[i].x - pListTemp[j].x, 2)
							+ Math.pow(pListTemp[i].y - pListTemp[j].y, 2));
				}
			}
		}
		return Math.min(ans, d);
	}

	public static void main(String[] args) throws Exception {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out);
		int n = nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		Point[] pList = new Point[n];
		for (int i = 0; i < n; i++) {
			x[i] = nextInt();
			y[i] = nextInt();
			Point p = new Point(x[i], y[i]);
			pList[i] = p;
		}
		System.out.println(minimalDistance(pList, 0, pList.length));
		writer.close();
	}

	static BufferedReader reader;
	static PrintWriter writer;
	static StringTokenizer tok = new StringTokenizer("");

	static String next() {
		while (!tok.hasMoreTokens()) {
			String w = null;
			try {
				w = reader.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (w == null)
				return null;
			tok = new StringTokenizer(w);
		}
		return tok.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt(next());
	}
}
