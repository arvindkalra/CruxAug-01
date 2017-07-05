package Lecture12_StacksAndQues;

import java.math.MathContext;

public class StackUsingArraysClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int N = 100;
		StackUsingArrays st = new StackUsingArrays(N);
		for (int i = 0; i < N; i++) {
			st.push(N - i);
			System.out.println("TOP = " + st.top());
			System.out.println("SIZE = " + st.size());
		}
		st.Display();
		System.out.println("+++++++POP START+++++++");
		System.out.println(st.pop());
		System.out.println();
		st.Display();
	}
}
