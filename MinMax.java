import java.util.Scanner;

public class MinMax {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Please enter the first number: ");
		int N = scn.nextInt();

		int min = N, max = N;

		int counter = 1;
		while (counter <= 4) {
			System.out.println("Enter next number ");
			int j = scn.nextInt();

			if (j > max) {
				max = j;
			}

			if (j < min) {
				min = j;
			}

			counter = counter + 1;
		}

		System.out.println("Maximum is " + max);
		System.out.println("Minimum is " + min);
	}

}
