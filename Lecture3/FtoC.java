package Lecture3;

import java.util.Scanner;

public class FtoC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter The Max");
		int max = scn.nextInt();
		System.out.println("Please Enter The Min");
		int min = scn.nextInt();
		System.out.println("Please Enter The Step");
		int step = scn.nextInt();
		int far = min;
		while (far <= max) {
			int cel = (int) ((5.0 / 9) * (far - 32));
			System.out.println(far + "\t" + cel);
			far = far + step;
		}
		scn.close();
	}

}
