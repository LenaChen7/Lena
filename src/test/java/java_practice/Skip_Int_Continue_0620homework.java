package java_practice;

public class Skip_Int_Continue_0620homework {

	public static void main(String[] args) {
//Print out elements in this below array, but skipping every other element:

		int[] numbers = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2265, 1457, 2456 };

		boolean skip = true;

		for (int number : numbers) {
			skip = !skip;
			if (skip) {
				continue;
			}
			System.out.println(number);

		}

	}

}

//it depends which number do you want to skip, 1st or 2nd
