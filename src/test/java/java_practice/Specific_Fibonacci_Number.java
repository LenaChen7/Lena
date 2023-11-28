package java_practice;

public class Specific_Fibonacci_Number {

	public static void main(String[] args) {
		System.out.println(getFibonacci(10));
	}

	public static int getFibonacci(int position) throws IllegalArgumentException {
		if (position < 1) {
			throw new IllegalArgumentException("Invalid parameter, please enter a number that is greater than 0 ");
		}

		if (position == 1) {
			return 0;
		}

		if (position == 2) {
			return 1;
		}

		return getFibonacci(position - 1) + getFibonacci(position - 2);
	}

}
