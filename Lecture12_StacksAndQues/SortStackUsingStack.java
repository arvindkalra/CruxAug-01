package Lecture12_StacksAndQues;

import java.util.Scanner;

public class SortStackUsingStack {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter Number Of Elements in the Stack...");
		int n = scn.nextInt();
		DynamicStack primary = new DynamicStack(n + 1);
		DynamicStack secondary = new DynamicStack(n + 1);
		System.out.println("Please Enter The Elements to be Stacked....");
		for (int i = 1; i<=n; i++){
			primary.push(scn.nextInt());
		}
		primary.Display();
		if (secondary.size() == 0) {
			int j = primary.pop();
			secondary.push(j);
		}
		while (secondary.size() != n) {
			if (secondary.top() >= primary.top()) {
				int j = primary.pop();
				secondary.push(j);
			}
			if (secondary.top() < primary.top()&&secondary.size()!=n) {
				int f = primary.pop();
				while (secondary.top() < primary.top()&&secondary.size()!=0) {
					int j = secondary.pop();
					primary.push(j);
				}
				secondary.push(f);
			}
		}
		secondary.Display();
	}

}
