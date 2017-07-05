package Lecture12_StacksAndQues;

import Lecture12_StacksAndQues.StackUsingArrays;

public class DynamicStack  extends StackUsingArrays {
	public DynamicStack(int capacity){
		super(capacity);
	}
	
	public DynamicStack(){
		this(DEFAULT_CAPACITY);
	}
	
	
	public void push(int item) throws Exception {
		if(this.size() == this.data.length){
			int[] temp = new int[2 * this.data.length];
			
			for(int i = 0; i < this.data.length; i++){
				temp[i] = this.data[i];
			}
			
			this.data = temp;
		}
		
		/*this.tos++;
		this.data[this.tos] = item;*/
		super.push(item);
	}
}
