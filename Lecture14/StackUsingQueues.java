package Lecture14;

import Lecture12_StacksAndQues.DynamicQues;;

public class StackUsingQueues {
	private DynamicQues primary;
	private DynamicQues secondary;
	
	public StackUsingQueues() throws Exception {
		this.primary = new DynamicQues();
		this.secondary = new DynamicQues();
	}
	
	public int size(){
		return this.primary.size();
	}
	
	public boolean isEmpty(){
		return this.size() == 0;
	}
	
	public void push(int item) throws Exception {
		this.primary.enque(item);
	}
	
	public int top() throws Exception{
		while(this.primary.size() != 1){
			this.secondary.enque(this.primary.deque());
		}
		
		int retVal = this.primary.deque();
		this.secondary.enque(retVal);
		
		DynamicQues temp = this.primary;
		this.primary = this.secondary;
		this.secondary = temp;
		
		
		return retVal;
	}
	
	public int pop() throws Exception{
		while(this.primary.size() != 1){
			this.secondary.enque(this.primary.deque());
		}
		
		int retVal = this.primary.deque();
		
		DynamicQues temp = this.primary;
		this.primary = this.secondary;
		this.secondary = temp;
		
		
		return retVal;
	}
	
	public void display() throws Exception{
		reverseTheQue(primary);
		primary.display();
		reverseTheQue(primary);
	}
	
	public static void reverseTheQue(DynamicQues queue) throws Exception{
		if(queue.IsEmpty()){
			return;
		}
		
		int el = queue.deque();
		reverseTheQue(queue);
		queue.enque(el);
	}
	
}
