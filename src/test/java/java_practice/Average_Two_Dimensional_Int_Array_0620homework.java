package java_practice;

public class Average_Two_Dimensional_Int_Array_0620homework {

	public static void main(String[] args) {
		int[][] twoD = { { 1, 2, 3, 4 }, { 22, 23 }, { 101, 102, 103 } };

		double average = calculate2DArrayAverage(twoD);
		System.out.println(average);

	}

	public static double calculate2DArrayAverage(int[][] twoD) {
		double sum = 0;
		int counter = 0;
		for (int[] innerArray : twoD) {
			for (int number : innerArray) {
				counter++;
				sum += number;
			}
		}
		return sum / counter;
	}

}
