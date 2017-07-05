import java.util.Scanner;

public class FibN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		System.out.println("Please enter the number - ");
		int N = scn.nextInt();

		int fn = 0, sn = 1;

		while (fn <= N) {
			System.out.print(fn + ", ");

			int ofn = fn;
			fn = sn;
			sn = ofn + sn;
		}
	}

}
