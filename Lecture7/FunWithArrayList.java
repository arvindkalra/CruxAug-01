package Lecture7;

import java.util.ArrayList;

public class FunWithArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(2, 5);
		System.out.println(al);
		al.remove(1);
		System.out.println(al);
		al.remove(5);
		System.out.println(al);
	}

}
