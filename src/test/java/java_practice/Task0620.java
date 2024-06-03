package java_practice;

import java.util.Arrays;

public class Task0620 {

	public static void main(String[] args) {
//		 1. Homework: Print out elements in this below array, but skipping every other
//		 element:
//		int[] numbers = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2265, 1457, 2456 };
//		// Skip(numbers);
//		// 2. Write a Java program to test if an array contains a specific value. USE
//		// FOR
//		int target = 1899;
//		 System.out.println(Contains(numbers, target));
//		 3. Write a program to find the index of an array element:
//		 System.out.println(FindIndex(numbers , target));
//		 4. Create a function that calculates the average of a two dimensional int
//		 array
//		int[][] twoD = { { 1, 2, 3, 4 }, { 22, 23 }, { 101, 102, 103 } };
//		getAverage(twoD);
//		String input = "Hello";

//		5, Given this below String array:
//			Hey, Everyone, Today, Is, A, Good, Day
//		String[] idk = new String[] { "Hey", "Everyone", "Today", "Is", "A", "Good", "Day" };
//		reverse2(idk);
////		Print this array out in the console in a reverse order
//		int numberOfLine = 3;
//		int numberOfUnits = 5;
//
//		printGrid(numberOfLine, numberOfUnits);
		// 2, ==> Write a program that can print a triangle shape like below:
//		    *
//		   * *
//		  * * *
//		 * * * *
//		* * * * *
//		for (int line = 1; line <= 5; line++) {
//			//spaces
//			for (int spaces = 1; spaces <= 5 - line; spaces++) {
//				System.out.print(" ");
//			}
//			
//			for (int star = 1; star <= line ; star++) {
//				System.out.print("* ");
//			} System.out.println(" ");
//		}
//		
//
//	}
//		int numbersOfArray = 12;
//		getFibonaci(numbersOfArray);
//
//		String[][] food = { { "apple", "banana" }, { "chicken", "beef", "lamb" }, { "cabbage", "carrot" } };
//
//		System.out.println(Arrays.deepToString(food));
//		// Calculate the sum for 2d array
//		int[][] twoD = { { 1, 2, 3, 4 }, { 22, 23 }, { 101, 102, 103 } };
//		int sum = 0;
//		for (int[] innerArray : twoD) {
//			for (int number : innerArray) {
//				sum += number;
//			}
//		}
////		System.out.println(sum);
//		String input = "Chen Lena";
//		System.out.println(input.substring(2,9));
//		input = input.replace(" ", "*");
//		String[]pieces = input.split("");
//		System.out.println(Arrays.toString(pieces));
		// Find the longest word
//		String message = "The one and only way to be successful in java programming is to practice";
//		//Expected Output: programming
//        String[] words = message.split(" ");
// 		System.out.println(Arrays.toString(words));
// 		String theBiggest = words[0];
// 		for (int i = 0; i < words.length; i++) {
//			if(theBiggest.length() < words[i].length()) {
//				theBiggest = words[i];
//				
//			}
//		} System.out.println(theBiggest);
//
//		String name = "Lena\tChen";
//
//		System.out.println(name);
//		int numberOftimes = 5;
//		CountDown(numberOftimes);
//		Fibonacii numbers
//		0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
//		1, 2, 3, 4, 5, 6, 7, 8,  9,  10, 11, 12, 13
//		Write a function, that gets the nth fibonacii number
		int nth = 1;
		System.out.println(fibonacci(nth));
		

	}

	public static int fibonacci(int nth) {
		if(nth == 1) {
			return 0;
		}
		if(nth == 2) {
			return 1;
		}
		else {
			return fibonacci(nth-2) + fibonacci(nth-1);
		}
		
		
	}

	public static void CountDown(int numberOftimes) {
		if(numberOftimes == 0) {
			return;
		}
		System.out.println(numberOftimes);
		CountDown(--numberOftimes);
		
	}

	public static void getFibonaci(int numbersOfArray) {
		int[] fibo = new int[numbersOfArray];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int index = 2; index < fibo.length; index++) {
			fibo[index] = fibo[index - 2] + fibo[index - 1];
		}
		System.out.println(Arrays.toString(fibo));

	}

	public static void printGrid(int numberOfLine, int numberOfUnits) {

		for (int line = 0; line <= numberOfLine; line++) {
			for (int unit = 1; unit <= numberOfUnits; unit++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

	public static void reverse2(String[] idk) {
		String result = "";
		for (int i = 0; i < idk.length; i++) {
			result = idk[i] + " " + result;
		}

		System.out.println(result);

	}

	public static void reverse(String input) {

		String result = "";
		char[] array = input.toCharArray();

		for (int i = array.length - 1; i >= 0; i--) {
			System.out.println(array[i]);
		}

	}

	public static void getAverage(int[][] twoD) {
		// TODO Auto-generated method stub

	}

	public static int FindIndex(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == target) {
				return i;

			}
		}
		return -1;

	}

	public static boolean Contains(int[] numbers, int target) {
		boolean found = false;
		for (int number : numbers) {
			if (number == target) {
				found = true;
				break;
			}
		}
		return found;

	}

	public static void Skip(int[] numbers) {
		boolean skip = true;
		for (int i = 0; i < numbers.length; i++) {
			skip = !skip;
			if (skip) {
				continue;
			} else {
				System.out.println(numbers[i]);
			}
		}

	}

}
