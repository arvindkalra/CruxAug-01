import java.util.Scanner;

public class PrimeUptoN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Please enter the number - ");
		int N = scn.nextInt();
		
		int numberToCheck = 2;
		while(numberToCheck <= N){
			boolean yesTheNumberIsPrime = true;
			int divisor = 2;
			while(divisor < numberToCheck){
				if(numberToCheck % divisor == 0){
					yesTheNumberIsPrime = false;
					break;
				}
				
				divisor = divisor + 1;
			}
			
			if(yesTheNumberIsPrime){
				System.out.println(numberToCheck);
			}
			
			numberToCheck = numberToCheck + 1;
		}
			
	}

}
