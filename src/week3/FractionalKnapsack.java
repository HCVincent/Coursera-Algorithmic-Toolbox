package week3;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
	private static double getOptimalValue(int capacity, int[] values, int[] weights) {
		double value = 0;
		// write your code here
		if(values.length == 1) {
			return capacity >= weights[0] ? values[0] : (Double.valueOf(values[0])/weights[0]*capacity);
		}
		
		int length = values.length;
		Items[] itemList = new Items[length];
		for (int i = 0; i < length; i++) {
			Items item = new Items(values[i], weights[i]);
			itemList[i] = item;
		}
		Arrays.sort(itemList);

		int leftCap = capacity;
		int index = 0;
		int temp = 0;
		while (leftCap > 0) {
			temp = leftCap;
			leftCap -= itemList[index].weight;
			if (leftCap < 0) {
				value += temp * itemList[index].valuePerUnit;
			} else {
				value += itemList[index].weight * itemList[index].valuePerUnit;
			}
			index++;
		}

		return value;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int capacity = scanner.nextInt();
		int[] values = new int[n];
		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
			weights[i] = scanner.nextInt();
		}
		System.out.printf("%.4f",getOptimalValue(capacity, values, weights));
	}

	public static void reverse(int[] data) {
		for (int left = 0, right = data.length - 1; left < right; left++, right--) {
			// swap the values at the left and right indices
			int temp = data[left];
			data[left] = data[right];
			data[right] = temp;
		}
	}

	public static class Items implements Comparable<Items> {
		int weight;
		int value;
		double valuePerUnit;

		public Items(int value, int weight) {
			this.weight = weight;
			this.value = value;
			this.valuePerUnit = Double.valueOf(value) / weight;
		}

		@Override
		public int compareTo(Items o) {
			// TODO Auto-generated method stub
			return Double.compare(o.valuePerUnit, this.valuePerUnit);
		}
	}

}
