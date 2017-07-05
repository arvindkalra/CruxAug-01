import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Please enter the number - ");
		int N = scn.nextInt();
		
		int row = 1;
		while(row <= N){
			// spaces
			int col = 1;
			while(col <= N - row){
				System.out.print(" ");
				col = col + 1;
			}
			
			// increasing
			col = 1;
			int value = row;
			while(col <= row){
				System.out.print(value);
				value = value + 1;
				col = col + 1;
			}
			
			// decreasing
			col = 1;
			value = 2 * row - 2;
			while(col <= row - 1){
				System.out.print(value);
				value = value - 1;
				col = col + 1;
			}
			
			System.out.println();
			row = row + 1;
		}
	}

}
