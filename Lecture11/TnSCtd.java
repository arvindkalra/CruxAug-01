package Lecture11;

public class TnSCtd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long start = System.currentTimeMillis();
		// System.out.println(countBoard(30, 0));
		// System.out.println(countBoardBtr(30, 0, new int[30+1]));
		// System.out.println(getpolyval(10, 3));
		System.out.println(largerNumbers("2134"));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static int countBoard(int N, int ci) {

		if (ci == N) {
			return 1;
		}
		if (ci > N) {
			return 0;
		}

		int count = 0;
		for (int th = 1; th <= 6; th++) {
			count += countBoard(N, ci + th);
		}
		return count;
	}

	public static int countBoardBtr(int N, int ci, int[] storage) {
		if (ci == N) {
			return 1;
		}
		if (ci > N) {
			return 0;
		}
		if (storage[ci] != 0) {
			return storage[ci];
		}

		int count = 0;
		for (int th = 1; th <= 6; th++) {
			count += countBoardBtr(N, ci + th, storage);
		}
		storage[ci] = count;
		return count;
	}

	public static int getpolyval(int x, int n) {

		int retval = 0;
		int power = 1;
		for (int i = 0; i < n; i++) {
			int cpower = power * x;
			retval += (n - i) * cpower;
			power = cpower;
		}
		return retval;
	}

	public static int largerNumbers(String str) {
		int retval = 0;
		int counter = str.length() - 2;
		int factorial = 1;
		int num = 2;
		while (counter >= 0) {
			int count = 0;
			int innercounter = counter + 1;
			while (innercounter < str.length()) {
				if (str.charAt(innercounter) > str.charAt(counter)) {
					count++;
				}
				innercounter++;
			}

			retval += count * factorial;
			factorial *= num;
			num++;
			counter--;
		}

		return retval;

	}

}
