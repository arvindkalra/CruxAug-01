package Lexture12A;

public class InPolClient {

	public static void main(String[] args) {
		// Reference is P and object is P
		P obj1 = new P();
		
		System.out.println(obj1.d);
		System.out.println(obj1.d1);
//		System.out.println(((C)obj1).d2); run time error
		obj1.Fun();
		obj1.Fun1();
		System.out.println("*******************************");
		
		// Reference is P and object is C
		
		P obj2 = new C();
		
		System.out.println(obj2.d); // danger area because C has two d's
		System.out.println(obj2.d1);
//		System.out.println(obj2.d2); is there but compiler doesnt allow it
		System.out.println(((C)obj2).d2);
		obj2.Fun1();
		obj2.Fun(); // Two Fun's?
//		obj2.Fun2(); Exists but compiler doesn't know it.
		((C)obj2).Fun2();
		System.out.println("*******************************");
		
		// Reference is C and object is P
//		C obj3 = new P(); never allowed becacuse this would have resulted in a run-time error
		// because obj3.Fun2() seems fine to the compiler but the object (P) doesnot know 
		// about Fun2
		
		// Reference is C and object is C
		C obj4 = new C();
		
		System.out.println(obj4.d);
		System.out.println(obj4.d1);
		System.out.println(obj4.d2);
		
		obj4.Fun();
		obj4.Fun1();
		obj4.Fun2();
		System.out.println("*******************************");
		
		// Overloading
		int sum = Add(2, 3);
		String concat = Add("hi", "Bye");
		double price = Add(2.0, 3.0);
		
		System.out.println(Add(1, 2, 4, 5));
		System.out.println(Add(1, 2, 4));
		System.out.println(Add(1, 2));
	}

	
	public static String Add(String one, String two){
		return one + two;
	}
	
	// Not allowed, because overloading doesn't depend on return types
//	public static void Add(String one, String two){
//		return one + two;
//	}
	
	public static int Add(int one, int two){
		return one + two;
	}
	
	public static double Add(double one, double two){
		return one + two;
	}
	
	public static int Add(int... numbers){
		int retVal = 0;
		
		for(int i = 0; i < numbers.length; i++){
			retVal += numbers[i];
		}
		
		return retVal;
	}
}

