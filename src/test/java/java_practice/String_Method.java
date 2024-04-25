package java_practice;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

public class String_Method {

	public static void main(String[] args) {

//		String name = "Lena";
//		String name2 = "Chnen";
//		name2.length();
//		name2.trim(); // trim the spaces at the beginning and the end
//		// concat
//		// .indexOf() wherever it starts
//		// contains
//		// charAt()
		// toCharArray()
//		System.out.println(name2.indexOf('n'));
//
		String input = "Hello";
		reverseString3(input);
	}

	private static void reverseStringback(String input) {

		String result = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			result += input.charAt(i);
		}
		System.out.println(result);

	}

	private static void reverseStringfront(String input) {

		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result = input.charAt(i) + result;
		}
		System.out.println(result);

		// Iteration 0: result = "h"
		// Iteration 1: result = "e" + "h" = "eh"
		// Iteration 2: result = "l" + "eh" = "leh"
		// Iteration 3: result = "l" + "leh" = "lleh"
		// Iteration 4: result = "o" + "lleh" = "olleh"

	}

	private static void reverseString3(String input) {

		String result = "";
		char[] newInput = input.toCharArray();
		for (char c : newInput) {
			result = c + result;
		}
		System.out.println(result);
	}
}
