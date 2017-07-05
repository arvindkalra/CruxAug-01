import java.util.Scanner;

public class LogBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter the value of BASE");
		int b = scn.nextInt();
		System.out.println("Please Enter the Number whose LOG is to be found");
		int num = scn.nextInt();
		int count = 0;
		while (num > 1) {
			num = num / b;
			count++;
		}
		System.out.println(count);
		scn.close();
	}

}
