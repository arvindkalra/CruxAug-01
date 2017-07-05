package Lecture3;

public class FunWithDataTypes {

	public static void main(String[] args) {
		long l = 111111111111L;
		int i = 0;
		short s = 0;
		byte b = 0;

		char c = 'a';
		i = c + 3;
		char d = (char)(c + 3);
		
		System.out.println(i);
		System.out.println(d);
		
		boolean bo = true;
		bo = false;
		
		double dbl = 5.5;
		float f = (float)5.5;
		
		
		System.out.println("Hello" + 10 + 12);
		System.out.println(10 + 12 + "Hello");
		
		int ascci = '\t';
		System.out.println(ascci);
	}

}
