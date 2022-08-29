package week3;

import java.util.Scanner;

public class CarFueling {
	static int computeMinRefills(int dist, int tank, int[] stops) {
		if (dist <= tank)
			return 0;
		if (stops.length == 0 || stops[0] - tank > 0 || (stops[stops.length - 1] + tank) < dist)
			return -1;
		int num = 0;
		int distPassed = 0;
		for (int i = 0; i < stops.length; i++) {
			if (tank + distPassed < stops[i]) {
				if (stops[i - 1] + tank < stops[i])
					return -1;
				if(dist <= tank + distPassed) break;
				else {
					num++;
					distPassed = stops[i - 1];
				}
			} else if (tank + distPassed == stops[i]) {
				if(dist <= tank + distPassed) break;
				else {
					num++;
					distPassed = stops[i];
					
				}
			}
			if(i == stops.length -1 && dist > tank+ distPassed && tank + distPassed> stops[i]) {
				num++;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dist = scanner.nextInt();
		int tank = scanner.nextInt();
		int n = scanner.nextInt();
		int stops[] = new int[n];
		for (int i = 0; i < n; i++) {
			stops[i] = scanner.nextInt();
		}

		System.out.println(computeMinRefills(dist, tank, stops));
	}
}
