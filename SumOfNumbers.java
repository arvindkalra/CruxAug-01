import java.util.Scanner;

public class SumOfNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn  = new Scanner(System.in);
		
		System.out.println("Please enter the number");
		int N = scn.nextInt();
		
		int i = 1, sum = 0;
		while(i <= N){
			sum = sum + i;
			i = i + 1;
		}
		
		System.out.println(sum);
	}

}
