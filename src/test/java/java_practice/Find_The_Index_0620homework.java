package java_practice;

public class Find_The_Index_0620homework {

	public static void main(String[] args) {
		// Write a program to find the index of an array element:
		// Test data:
		int[] numbers = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2300, 1456, 2265, 1457, 2456 };

		// Looking for 2013
		// Output: The index of 2013 is 4.

		int target = 1458;
		System.out.println(getIndex(target, numbers));
	}

	public static int getIndex(int target, int[] numbers) {

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == target) {
				return i;
			}
		}
		return -1;
	}

}
