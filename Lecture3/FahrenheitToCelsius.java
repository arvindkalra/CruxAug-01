package Lecture3;

import java.util.Scanner;

public class FahrenheitToCelsius {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Please enter the min number ");
		int min = scn.nextInt();
		
		System.out.println("Please enter the max number ");
		int max = scn.nextInt();
		
		System.out.println("Please enter the step number ");
		int step = scn.nextInt();
		
		int far = min;
		while(far <= max){
			int cel = (int)((5.0 / 9)*(far - 32));
			System.out.println(far + "\t" + cel);
			far = far + step;
		}
	}

}
