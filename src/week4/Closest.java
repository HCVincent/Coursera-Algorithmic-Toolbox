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

	// A structure to represent a Point in 2D plane
	public static class PointXComparator implements Comparator<Point> {

		// Needed to sort array of points
		// according to X coordinate
		@Override
		public int compare(Point pointA, Point pointB) {
			return Long.compare(pointA.x, pointB.x);
		}

	}

	public static class PointYComparator implements Comparator<Point> {

		// Needed to sort array of points
		// according to Y coordinate
		@Override
		public int compare(Point pointA, Point pointB) {
			return Long.compare(pointA.y, pointB.y);
		}

	}

	public static float closestUtil(Point[] P, int startIndex, int endIndex) {

		// If there are 2 or 3 points, then use brute force
		if ((endIndex - startIndex) <= 3) {
			return bruteForce(P, endIndex);
		}

		// Find the middle point
		int mid = startIndex + (endIndex - startIndex) / 2;
		Point midPoint = P[mid];

		// Consider the vertical line passing
		// through the middle point calculate
		// the smallest distance dl on left
		// of middle point and dr on right side
		float dl = closestUtil(P, startIndex, mid);
		float dr = closestUtil(P, mid, endIndex);

		// Find the smaller of two distances
		float d = Math.min(dl, dr);

		// Build an array strip[] that contains
		// points close (closer than d)
		// to the line passing through the middle point
		Point[] strip = new Point[endIndex];
		int j = 0;
		for (int i = 0; i < endIndex; i++) {
			if (Math.abs(P[i].x - midPoint.x) < d) {
				strip[j] = P[i];
				j++;
			}
		}

		// Find the closest points in strip.
		// Return the minimum of d and closest
		// distance is strip[]
		return Math.min(d, stripClosest(strip, j, d));
	}

	// The main function that finds the smallest distance
	// This method mainly uses closestUtil()
	public static float closest(Point[] P, int n) {
		Arrays.sort(P, 0, n, new PointXComparator());

		// Use recursive function closestUtil()
		// to find the smallest distance
		return closestUtil(P, 0, n);
	}

	public static void main(String[] args) throws Exception {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out);
		int n = nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			x[i] = nextInt();
			y[i] = nextInt();
			Point p = new Point(x[i], y[i]);
			points[i] = p;
		}
		System.out.println(closest(points, points.length));
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

	// A Brute Force method to return the
	// smallest distance between two points
	// in P[] of size n
	public static float bruteForce(Point[] P, int n) {
		float min = Float.MAX_VALUE;
		float currMin = 0;

		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				currMin = dist(P[i], P[j]);
				if (currMin < min) {
					min = currMin;
				}
			}
		}
		return min;
	}

	// A utility function to find the
	// distance between two points
	public static float dist(Point p1, Point p2) {
		return (float) Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}

	// A utility function to find the
	// distance between the closest points of
	// strip of given size. All points in
	// strip[] are sorted according to
	// y coordinate. They all have an upper
	// bound on minimum distance as d.
	// Note that this method seems to be
	// a O(n^2) method, but it's a O(n)
	// method as the inner loop runs at most 6 times
	public static float stripClosest(Point[] strip, int size, float d) {
		float min = d; // Initialize the minimum distance as d

		Arrays.sort(strip, 0, size, new PointYComparator());

		// Pick all points one by one and try the next points till the difference
		// between y coordinates is smaller than d.
		// This is a proven fact that this loop runs at most 6 times
		for (int i = 0; i < size; ++i) {
			for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; ++j) {
				if (dist(strip[i], strip[j]) < min) {
					min = dist(strip[i], strip[j]);
				}
			}
		}

		return min;
	}

}
