package Lecture17;

import Lecture16.LinkedList;

public class StackUsingLinkedList {

	private LinkedList list;

	public StackUsingLinkedList() {
		this.list = new LinkedList();
	}

	public void push(int item) {
		this.list.AddFirst(item);
	}

	public int pop() throws Exception {
		return this.list.RemoveFirst();
	}

	public int top() throws Exception {
		return this.list.GetFirst();
	}

	public int size() {
		return this.list.size();
	}

	public boolean isEmpty() {
		return this.list.IsEmpty();
	}

	public void display() {
		this.list.Display();
	}
}
