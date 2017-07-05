package Lecture12_StacksAndQues;

public class StackUsingArrays {

	protected int[] data;
	protected int tos=-1;

	public static final int DEFAULT_CAPACITY = 10;

	// if capacity is provided by the user
	//Constructor
	public StackUsingArrays(int capacity) {
		this.data = new int[capacity];
	}

	// if capacity is not provided the we use default capacity
	public StackUsingArrays() {
		this(StackUsingArrays.DEFAULT_CAPACITY);
	}

	// now the functions
	// size function
	public int size() {
		return this.tos+1;
	}

	public boolean IsEmpty() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void push(int item) throws Exception {
		if (this.size() == this.data.length) {
			throw new Exception("Stack Is Full...");
		} else {
			this.tos++;
			this.data[this.tos] = item;
		}
	}

	public int top() throws Exception {
		if (this.IsEmpty()) {
			throw new Exception("Stack Is Empty...");
		}
		int retval;
		retval = this.data[this.tos];
		return retval;
	}
	public int pop() throws Exception{
		if (this.IsEmpty()) {
			throw new Exception("Stack Is Empty...");
		}
		int retval;
		retval = this.data[this.tos];
		this.data[this.tos]=0;
		this.tos--;
		return retval;
	}
	public void Display(){
		for (int i = this.tos; i>=0; i--){
			System.out.println(this.data[i]);
		}
	}
}
