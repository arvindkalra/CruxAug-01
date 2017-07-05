import java.util.Scanner;

public class SumOfOddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter The No.");
		int N = scn.nextInt(), even = 0, odd = 0;
		int i = 1;
		while (i <= N) {
			if (i % 2 == 0) {
				even = even + i;
			} else {
				odd = odd + i;
			}
			i = i + 1;
		}

		System.out.println("Sum of Odd Nos Is " + odd);
		System.out.println("Sum OF Even Nos Is" + even);
		scn.close();
	}
}