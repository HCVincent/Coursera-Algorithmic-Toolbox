package week3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CoveringSegments {

	private static int[] optimalPoints(Segment[] segments) {
		// write your code here
		int[] points = new int[segments.length];
		List<Segment> list = new LinkedList<Segment>(Arrays.asList(segments));
		list.sort((Segment s1, Segment s2) -> Integer.compare(s1.end, s2.end));
//        for(Segment s : list) {
//        	System.out.println("s:"+s.start+"   e:" +s.end);
//        }
		int index = 0;
		while (!list.isEmpty()) {
			int firstEnd = list.get(0).end;
			points[index] = firstEnd;
			index++;
//			for (int i = 0; i < list.size(); i++) {
//				while (itr.hasNext()) {
//					if (list.get(i).start <= firstEnd) {
//						Segment s = (Segment) itr.next();
//						itr.remove();
//					}
//				}
//			}
			for(Iterator<Segment> itr = list.iterator(); itr.hasNext();) {
				if(itr.next().start <= firstEnd) {
					itr.remove();
				}
			}
		}
		
		return Arrays.stream(points).filter(num -> num != 0).toArray();
	}

	private static class Segment {
		int start, end;

		Segment(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Segment[] segments = new Segment[n];
		for (int i = 0; i < n; i++) {
			int start, end;
			start = scanner.nextInt();
			end = scanner.nextInt();
			segments[i] = new Segment(start, end);
		}
		int[] points = optimalPoints(segments);
		System.out.println(points.length);
		for (int point : points) {
			System.out.print(point + " ");
		}
	}
}
