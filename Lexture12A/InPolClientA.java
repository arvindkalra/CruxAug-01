package Lexture12A;

public class InPolClientA {

	public static void main(String[] args) {
		// Reference is PA and object is PA
		//PA obj1 = new PA();	wrong 
	
		System.out.println("*******************************");
		
		// Reference is PA and object is CA
		
		PA obj2 = new CA();
		
		obj2.Fun1();
		obj2.Fun(); // Two Fun's?
//				obj2.Fun2(); Exists but compiler doesn't know it.
		((CA)obj2).Fun2();
		System.out.println("*******************************");
		
		// Reference is CA and object is PA
		
		// Reference is CA and object is CA
		CA obj4 = new CA();
		
		obj4.Fun();
		obj4.Fun1();
		obj4.Fun2();
		System.out.println("*******************************");
	}

}
