import java.util.Scanner;

public class PrimeNos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter The No.");
		int N = scn.nextInt();
		int i = 2;
		while (i < N) {
			if (N % i == 0) {
				System.out.println("Not Prime");
				return;
			}
			i = i + 1;
		}
		System.out.println("Prime");
		scn.close();
	}
}
