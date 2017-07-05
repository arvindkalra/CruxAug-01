import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Please enter the number - ");
		int N = scn.nextInt();
		
		int i = 2;
		while(i < N){
			if(N % i == 0){
				System.out.println("Not prime");
				return;
			}
			
			i = i + 1;
		}
		
		System.out.println("Prime");
	}

}
