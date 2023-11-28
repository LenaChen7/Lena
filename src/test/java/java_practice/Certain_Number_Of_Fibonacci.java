package java_practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Certain_Number_Of_Fibonacci {

	public static void main(String[] args) {
		// print a certain number of fibonacci sequence
		int howManyNumber = 2;
		System.out.println(getFibonacci(howManyNumber));

	}

	private static ArrayList<Integer> getFibonacci(int howManyNumber) {
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
