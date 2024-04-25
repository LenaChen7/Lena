package java_practice;

public class If_contains_value_0620homework {

	public static void main(String[] args) {
//Write a Java program to test if an array contains a specific value. USE FOR EACH LOOP

		int target = 1789;
		int[] numbers = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2265, 1457, 2456 };
		// when you search a stuff in a array, you can use boolean to assume you don't
		// found the number

		boolean found = false;

		for (int number : numbers) {
			if (number == target) {
				found = true;
				break;
			}
		}

		System.out.println(found ? "The value is found" : "The value is not found");
	}

}
