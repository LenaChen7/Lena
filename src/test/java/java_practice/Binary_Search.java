package java_practice;

public class Binary_Search {

	public static void main(String[] args) {

		// Linear search
		int[] source = { 12, 14, 25, 28, 70, 75 };
		int target = 70;
		boolean found = false;
		for (int i = 0; i < source.length; i++) {
			if (source[i] == target) {
				found = true;
			}
		}

		System.out.println(found);

	}

}
