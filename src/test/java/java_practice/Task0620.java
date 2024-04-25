package java_practice;

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
		String input = "Hello";
		reverse(input);

	}

	public static void reverse(String input) {

		String result = "";
		char[] array = input.toCharArray();
		
	 for (int i = array.length - 1 ; i >= 0 ; i--) {
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
