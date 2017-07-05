package Lecture6;

public class RecurssionStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printDecreasingIncreasing(10);
	}

	public static void printDecreasingIncreasing(int value) {
		if (value == 0) {
			System.out.print(value + ", ");
			return;
		}
		if (value != 4) {
			System.out.print(value + ", ");
		}
		printDecreasingIncreasing(value - 1);
		if (value != 3) {
			System.out.print(value + ", ");
		}
	}

}
