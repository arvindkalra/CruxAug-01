package Lecture12_StacksAndQues;

public class QuesUsingArrays {

	protected int[] data;
	protected int front;

	public int getFront() {
		return this.front;
	}

	public int getSize() {
		return this.size;
	}

	protected int size;
	public static final int DEFAULT_CAPACITY = 10;

	public QuesUsingArrays(int capacity) {
		this.data = new int[capacity];
		this.front = 0;
		this.size = 0;
	}

	public QuesUsingArrays() {
		this(QuesUsingArrays.DEFAULT_CAPACITY);
	}

	public int size() {
		return this.size;
	}

	public boolean IsEmpty() {
		return this.size() == 0;
	}

	public void enque(int item) throws Exception {
		if (this.size == this.data.length) {
			throw new Exception("Que Is Full...");
		}
		int ai = (this.front + this.size) % this.data.length;
		data[ai] = item;
		this.size++;
	}

	public int front() throws Exception {
		if (this.size == 0) {
			throw new Exception("Que is Empty...");
		}
		int retval = this.data[this.front];
		return retval;
	}

	public int deque() throws Exception {
		if (this.size == 0) {
			throw new Exception("Que is Empty...");
		}
		int retval = this.data[this.front];
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return retval;
	}

 	public void display() {
		for (int i = 0; i < this.size(); i++) {
			System.out.print(this.data[(front + i) % data.length] + ", ");
		}
		System.out.println("End");
	}
}
