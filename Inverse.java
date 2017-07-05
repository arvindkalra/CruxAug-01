import java.util.Scanner;

public class Inverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter the Number");
		int N = scn.nextInt();
		int ans = 0;
		int pos = 1;
		while (N > 0) {
			int j = N % 10;
			N = N / 10;
			int pow = 1;
			for (int i = 1; i < j; i++) {
				pow = pow * 10;
			}
			ans = ans + pos * pow;
			pos++;
		}
		System.out.println(ans);
		scn.close();
	}

}
