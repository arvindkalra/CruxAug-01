package Lecture10;

public class FIbonacciImproved {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(FibBtr(50)[1]);
	}

	public static int[] FibBtr(int n) {

		if (n == 1) {
			int[] base = new int[2];
			base[0] = 0;
			base[1] = 1;
			return base;
		}

		int[] recresult = FibBtr(n - 1);
		int[] myresult = new int[2];

		myresult[0] = recresult[1];
		myresult[1] = recresult[0] + recresult[1];

		return myresult;
	}
}
