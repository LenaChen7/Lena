package java_practice;

import java.util.Arrays;

public class Bubble_Sort {

	public static void main(String[] args) {
		int[] numbers = { 45, 12, 73, 11, 17, 50, 64, 32, 98, 21 };
		System.out.println("Orginal: " + Arrays.toString(numbers));

		int[] result = bubbleSort(numbers);
		System.out.println("Ordered: " + Arrays.toString(result));

	}

	public static int[] bubbleSort(int[] numbers) {

		for (int index = 0; index < numbers.length; index++) {

			for (int i = 0; i < numbers.length - 1; i++) {
				int firstNumber = numbers[i];
				int secondNumber = numbers[i + 1];

				if (firstNumber > secondNumber) {
					numbers[i] = secondNumber;
					numbers[i + 1] = firstNumber;
				}

			}

		}

		return numbers;
	}
}
