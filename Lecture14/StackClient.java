package Lecture14;

public class StackClient {

	public static void main(String[] args) throws Exception {
		int N = 5;
		
		StackUsingQueues stack = new StackUsingQueues();
		
		for(int i = 0; i < N; i++){
			stack.push(N - i);
			stack.display();
			System.out.println("Size = " + stack.size());
			System.out.println("Empty = " + stack.isEmpty());
			System.out.println("Top = " + stack.top());
			System.out.println("********************************");
		}
		
		System.out.println("Pop Starts");
		for(int i = 0; i < N; i++){
			System.out.println("Size = " + stack.size());
			System.out.println("Empty = " + stack.isEmpty());
			System.out.println("Top = " + stack.top());
			System.out.println("********************************");
			
			stack.pop();
			stack.display();
		}
	}

}
