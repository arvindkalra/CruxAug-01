package Lecture17;

import Lecture16.LinkedList;

public class QueueUsingLinkedList {

	private LinkedList list;

	public QueueUsingLinkedList() {
		this.list = new LinkedList();
	}

	public void enque(int item) {
		this.list.AddLast(item);
	}

	public int deque() throws Exception {
		return this.list.RemoveFirst();
	}

	public int front() throws Exception {
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
