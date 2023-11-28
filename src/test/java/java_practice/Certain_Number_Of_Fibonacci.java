package java_practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Certain_Number_Of_Fibonacci {

	public static void main(String[] args) {
		// print a certain number of fibonacci sequence
		int howManyNumber = 10;
//		System.out.println(getFibonacci1(howManyNumber));
		System.out.println(Arrays.toString(getFibonacci2(howManyNumber)));

	}

	private static int[] getFibonacci2(int howManyNumber) {

		int[] Fibonacci = new int[howManyNumber];

		if (howManyNumber == 1) {
			Fibonacci[0] = 0;

		} else if (howManyNumber == 2) {
			Fibonacci[0] = 0;
			Fibonacci[1] = 1;
		} else {
			Fibonacci[0] = 0;
			Fibonacci[1] = 1;
			for (int i = 2; i < Fibonacci.length; i++) {
				Fibonacci[i] = Fibonacci[i - 1] + Fibonacci[i - 2];
			}

		}

		return Fibonacci;

	}

	private static ArrayList<Integer> getFibonacci1(int howManyNumber) {
		ArrayList<Integer> Fibonacci = new ArrayList<>();
		if (howManyNumber == 1) {
			Fibonacci.add(0);
		} else if (howManyNumber == 2) {
			Fibonacci.add(0);
			Fibonacci.add(1);
		} else {
			Fibonacci.add(0);
			Fibonacci.add(1);

			for (int i = 2; i < howManyNumber; i++) {
				int nextNumber = Fibonacci.get(i - 1) + Fibonacci.get(i - 2);
				Fibonacci.add(nextNumber);

			}

		}

		return Fibonacci;
	}

}
