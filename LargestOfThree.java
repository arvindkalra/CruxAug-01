
public class LargestOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10, b = 25, c = 20;

		/*
		 * if(a >= b && a >= c){ System.out.println(a); return; }
		 * 
		 * if(b >= a && b >= c){ System.out.println(b); return; }
		 * 
		 * System.out.println(c);
		 */

		/*
		 * if (a >= b && a >= c) { System.out.println(a); } else { if (b >= a &&
		 * b >= c) { System.out.println(b); } else { System.out.println(c); } }
		 */

		Math.log10(15);

		if (a >= b && a >= c) {
			System.out.println(a);
		} else if (b >= a && b >= c) {
			System.out.println(b);
		} else {
			System.out.println(c);
		}
	}

}
