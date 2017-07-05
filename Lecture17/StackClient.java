package Lecture17;

public class StackClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StackUsingLinkedList st = new StackUsingLinkedList();
		for (int i = 0; i < 5; i++) {
			st.push(5 - i);
			System.out.println("TOP = " + st.top());
			System.out.println("SIZE = " + st.size());
		}
		st.display();
		System.out.println("+++++++POP START+++++++");
		System.out.println(st.pop());
		System.out.println();
		st.display();
	}
}
