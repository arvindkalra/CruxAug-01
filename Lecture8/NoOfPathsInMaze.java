
package Lecture8;

public class NoOfPathsInMaze {
	public static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CMPs(3, 2, 0, 0));
	}

	public static int CMPs(int tr, int tc, int cr, int cc) {

		if (cr == tr && cc == tc) {
			count = count + 1;
			return count;
		}
		if (cr == tr) {
			CMPs(tr, tc, cr, cc + 1);
			return count;
		}
		if (cc == tc) {
			CMPs(tr, tc, cr + 1, cc);
			return count;
		}
		CMPs(tr, tc, cr + 1, cc);
		CMPs(tr, tc, cr, cc + 1);
		return count;
	}
}
