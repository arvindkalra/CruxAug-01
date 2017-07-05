package Lecture8;

public class NoOfPathsInMazeWithDiagonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(CMPs(5, 10, 0, 0));
	}

	public static int count = 0;

	public static int CMPs(int tr, int tc, int cr, int cc) {
		if (cr == tr && cc == tc) {
			count = count + 1;
			return count;
		}

		if (cr < tr) {
			CMPs(tr, tc, cr + 1, cc);

		}
		if (cc < tc) {
			CMPs(tr, tc, cr, cc + 1);
		}
		if (cc < tc && cr < tr) {
			CMPs(tr, tc, cr + 1, cc + 1);

		}
		return count;
	}
}
