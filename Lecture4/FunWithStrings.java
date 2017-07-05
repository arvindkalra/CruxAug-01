package Lecture4;

public class FunWithStrings {

	public static void main(String[] args) {
//		String s1 = "Hello";
//		String s2 = "Hello";
//		String s3 = new String("Hello");
//		
//		System.out.println(s1 == s2);
//		System.out.println(s1 == s3);
//		System.out.println(s1.equals(s2));
//		System.out.println(s1.equals(s3));
		
//		System.out.println(s1.charAt(5));
//		s1.charAt(4) = 'p';
		
//		System.out.println(s1.substring(1, 4));
//		System.out.println(s1.substring(1, 5));
//		System.out.println(s1.substring(1, 2));
//		System.out.println(s1.substring(1, 1));
//		System.out.println(s1.substring(1, 0));
		
//		System.out.println(s1.substring(2));
		
//		String s4 = s1 + s3;
	/*	String s4 = s1.concat(s3);
		System.out.println(s4);
		
		System.out.println(s4.indexOf("oHe"));
		System.out.println(s4.indexOf("ohe"));
		System.out.println(s4.indexOf("ell"));
		System.out.println(s4.lastIndexOf("ell"));
		
		System.out.println(s4.startsWith("ell"));*/
		
//		displayCharsInSeparateLines("Hello World");
//		System.out.println(isPalindrome("abcdcba"));
//		System.out.println(isPalindrome("abcdef"));
		
		String s = "Hello World";
		
//		System.out.println(s.charAt(6) + s.charAt(10));
//		System.out.println(s.substring(6, 7) + s.substring(10, 11));
		System.out.println(s.substring(6));
		System.out.println(s.substring(6, 11));
		
		String s1 = "Hello";
		String s2 = "World";
		String s3 = s1.concat(s2);
		System.out.println(s3);
		
		System.out.println(s3.indexOf("wor"));
		System.out.println(s3.startsWith("hell"));
		
		String str = "hello";
		System.out.println(str);
		
		String nStr = str.toUpperCase();
		System.out.println(str);
		System.out.println(nStr);
	}
	
	public static void displayCharsInSeparateLines(String str){
		for(int i = 0; i < str.length(); i++){
			System.out.println(str.charAt(i));
		}
	}
	
	public static boolean isPalindrome(String str){
		boolean retVal = true;
		int left = 0, right = str.length() - 1;
		
		while(left <= right){
			if(str.charAt(left) != str.charAt(right)){
				retVal = false;
				break;
			}
			
			left++;
			right--;
		}
		
		return retVal;
	}

}
