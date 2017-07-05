import java.util.Scanner;

public class isArmstrong {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter The Number to Check..");
		int N = scn.nextInt();
		int gnum = N;
		int sum = 0;
		while (N > 0) {
			int j = N % 10;
			N = N / 10;
			int j3 = j * j * j;
			sum += j3;
		}
		if (sum == gnum) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
