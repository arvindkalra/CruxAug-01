package Lecture10;

public class CrossingBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(WaysToCross(10, 0));
	}

	public static int WaysToCross(int N, int ci) {
		if (ci == N) {
			return 1;
		}
		if (ci > N) {
			return 0;
		}

		int count = 0;
		for (int th = 1; th <= 6; th++) {
			count += WaysToCross(N, ci + th);
		}
		return count;
	}

	public static int WithLadder(int N, int m, int ci) {
		if (ci == N) {
			return 1;
		}
		if (ci > N) {
			return 0;
		}

		int mid = N / 2;
		int count = 0;
		for (int th = 1; th <= 6; th++) {
			if (th % m == 0 && th <= mid && ci < mid) {
				int j = N - th;
				count += WithLadder(N, m, ci + j);
			} else {
				count += WaysToCross(N, ci + th);
			}
		}
		return count;
	}
}