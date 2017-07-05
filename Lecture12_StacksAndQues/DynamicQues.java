package Lecture12_StacksAndQues;

import Lecture12_StacksAndQues.QuesUsingArrays;

public class DynamicQues extends QuesUsingArrays {
	public DynamicQues(int capacity) {
		super(capacity);
	}

	public DynamicQues() {
		this(DEFAULT_CAPACITY);
	}

	public void enque(int item) throws Exception {
		if (this.size() == this.data.length) {
			int[] temp = new int[2 * this.data.length];

			for (int i = 0; i < this.size(); i++) {
				int ai = (this.front + i) % this.data.length;
				temp[i] = this.data[ai];
			}

			this.data = temp;
			this.front = 0;
		}

		/*
		 * int ai = (this.front + this.size) % this.data.length; this.data[ai] =
		 * item; this.size++;
		 */
		super.enque(item);
	}
}
