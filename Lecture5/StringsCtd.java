package Lecture5;

import java.util.Scanner;

public class StringsCtd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Please enter the input ");
		String str = scn.next();
		
		System.out.println(IsPalindrome(str));
//		printSubStrings(str);
		printSubSequences(str);
	}
	
	public static boolean IsPalindrome(String str){
		int left = 0, right = str.length() - 1;
		while(left <= right){
			if(str.charAt(left) != str.charAt(right)){
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}
	
	public static void printSubStrings(String str){	
		for(int sp = 0; sp < str.length(); sp++){
			for(int ep = sp + 1; ep <= str.length(); ep++){
				System.out.println(str.substring(sp, ep));
			}
		}
		System.out.println("");
	}
	
	public static void printSubSequences(String str){
		int limit = 1, counter = 1;
		while(counter <= str.length()){
			limit *= 2;
			counter++;
		}
		
		counter = 0;
		while(counter < limit){
			String word = "";
			int decimal = counter, indexOfChar = str.length() - 1;
			while(decimal != 0){
				int bit = decimal % 2;
				if(bit == 1){
					word = str.charAt(indexOfChar)+ word;
				}
				
				indexOfChar--;
				decimal = decimal / 2;
			}
			
			System.out.println(word);
			counter++;
		}
	}

}
