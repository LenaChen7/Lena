package java_practice;

public class Check_If_Contains {

	public static void main(String[] args) {
		System.out.println(contains("Hello World", "true"));

	}

	private static boolean contains(String input, String value) {

		return input.indexOf(value) > -1;
	}

}
