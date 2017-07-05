package Lecture10;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(power(2, 5));
	}

	public static int power(int x, int n) {
		// base case
		if (n == 0) {
			return 1;
		}
		int retval;
		// job
		if (n % 2 == 0) {
			int xpn = power(x, n / 2);
			retval = xpn * xpn;
		} else {
			int xpn = power(x, n / 2);
			retval = xpn * xpn * x;
		}
		return retval;
	}
}
