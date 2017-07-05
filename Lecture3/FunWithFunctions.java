package Lecture3;

public class FunWithFunctions {

	
	
	public static void main(String[] args) {
//		int one = 100, two = 200;
//		
//		int sumOf5And10 = Sum(5, 10);
//		System.out.println(sumOf5And10);
//		
//		System.out.println(Sum(15, 20));
//		
//		System.out.println(intersting);
//		
//		if(sumOf5And10 > 50){
//			int i = 100;
//		}
		
		int one = 10, two = 20;
		
		System.out.println(one + ", " + two);
		Swap(one, two);
		System.out.println(one + ", " + two);
		
		
	}
	
	public static int Sum(int one, int two){
		int retVal = 0;
		
		retVal = one + two;
		
		System.out.println(intersting);
		System.out.println(FunWithFunctions.retVal);
		
		return retVal;
	}
	
	public static void Swap(int one, int two){
		System.out.println(one + ", " + two);
		
		int temp = one;
		one = two;
		two = temp;
		
		System.out.println(one + ", " + two);
	}

	public static int intersting = 100;
	public static int retVal = 0;
}
