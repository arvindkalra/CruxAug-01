import java.util.Scanner;

public class SumOddEven {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Please enter the number - ");
		int N = scn.nextInt();
		
		int sumOdd = 0, sumEven = 0, done = 1;
		while (done <= N){
			if(done % 2 == 0){
				sumEven = sumEven + done;
			}
			else {
				sumOdd = sumOdd + done;
			}
			
			done = done + 1;
		}
		
		System.out.println("Sum of odd numbers is " + sumOdd);
		System.out.println("Sum of even numbers is " + sumEven);
		
		scn.close();
	}

}
