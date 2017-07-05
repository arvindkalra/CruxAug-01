package Lecture18;

public class LinkedList<T extends Comparable<T>> {
	// class that creates nodes which store data and next ki place value...
	// they are basically the elements of the linked list
	private class Node {
		T data;
		Node next;

		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	// they are the only data members of a linked list...
	private Node head;
	private Node tail;
	private int size;

	// Constructor
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// Constructor that takes head and tail to form a linked list
	public LinkedList(Node head, Node tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	// at any point when we need to use the size of linked list we use this
	// function...
	// we never use size data member for this purpose
	// when we need to change or modify the size we use size data member..
	public int size() {
		return this.size;
	}

	public boolean IsEmpty() {
		return this.size == 0;
	}

	// These are the functions used to get various values of elements in a
	// linked list
	// its time complexity is O(1)
	public T GetFirst() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Linked List Is Empty...");
		} else {
			return this.head.data;
		}
	}

	// Time Complexity O(1)
	public T GetLast() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Linked List Is Empty...");
		} else {
			return this.tail.data;
		}
	}

	// this function is used to get the node at particular index...
	// we make it private so that the client can't see or modify the values
	// placed inside the node
	// TIme Complexity O(N)
	private Node getNodeAt(int idx) throws Exception {
		if (this.IsEmpty()) {
			throw new Exception("Linked List is Empty...");
		} else if (idx < 0 || idx >= this.size()) {
			throw new Exception("Index Out Of Bound");
		} else {
			Node retval = this.head;
			for (int i = 0; i < idx; i++) {
				retval = retval.next;
			}
			return retval;
		}
	}

	// Time Complexity is O(N)
	public T GetAt(int idx) throws Exception {
		Node temp = getNodeAt(idx);
		return temp.data;
	}

	// these functions are used to ADD elements to the linked list
	// Time Comlplexity O(1)
	public void AddFirst(T item) {
		Node node = new Node(item, this.head);
		this.head = node;
		this.size++;
		// agar size 0 tha toh head aur tail dono same node ko point karenge jo
		// ki naya node hai...
		if (this.size() == 1) {
			this.tail = node;
		}
	}

	// Time Comlplexity O(1)
	public void AddLast(T item) {
		Node node = new Node(item, null);
		if (this.size() == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
	}

	// Time Comlplexity O(N)
	public void AddAt(T item, int idx) throws Exception {
		if (idx == 0) {
			this.AddFirst(item);
		} else if (idx == this.size()) {
			this.AddLast(item);
		} else {
			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node node = new Node(item, n);
			nm1.next = node;
			this.size++;
		}
	}

	// these functions are used to remove the elements from the linked list
	// Time Comlplexity O(1)
	public T RemoveFirst() throws Exception {
		if (this.IsEmpty()) {
			throw new Exception("Linked List Is Empty..");
		}
		T retval = this.head.data;
		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}
		this.size--;
		return retval;
	}

	// Time Comlplexity O(N)
	public T RemoveLast() throws Exception {
		if (this.IsEmpty()) {
			throw new Exception("Linked List Is Empty..");
		}
		T retval = this.tail.data;
		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node sm2 = getNodeAt(this.size() - 2);
			sm2.next = null;
			this.tail = sm2;
		}
		this.size--;
		return retval;
	}

	// Time Comlplexity O(N)
	public T RemoveAt(int idx) throws Exception {
		if (idx == 0) {
			return this.RemoveFirst();
		} else if (idx == this.size() - 1) {
			return this.RemoveLast();
		} else {
			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;
			T retval = n.data;
			nm1.next = np1;
			this.size--;
			return retval;
		}
	}

	// this Function is used to display all the elements of the linked list from
	// first to last
	public void Display() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		String retval = "";
		Node node = this.head;
		while (node != null) {
			retval += node.data + " => ";
			node = node.next;
		}
		retval += "END\n";

		return retval;
	}

	public void Reverse_List_Iterative() throws Exception {
		for (int fi = 0, li = this.size() - 1; fi < li; fi++, li--) {
			Node nod1 = getNodeAt(fi);
			Node nod2 = getNodeAt(li);
			// reversing
			T temp = nod1.data;
			nod1.data = nod2.data;
			nod2.data = temp;
		}
	}

	public void Reverse_Pointer_Iterative() throws Exception {
		Node prevNode = null;
		Node currentNode = this.head;
		Node nextNode = currentNode.next;
		while (nextNode != null) {
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
			nextNode = nextNode.next;
		}
		currentNode.next = prevNode;
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

	}

	public void Reverse_Pointer_Recurssive() throws Exception {
		Node currentnode = this.head;
		this.Reverse_Pointer_Recurssive(currentnode);
		// swapping head n tail..
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;

	}

	private void Reverse_Pointer_Recurssive(Node current) throws Exception {
		if (current == this.tail) {
			return;
		}
		Reverse_Pointer_Recurssive(current.next);
		Node temp = current.next;
		temp.next = current;

	}

	public void Reverse_Data_Recurssive() throws Exception {
		Node leftval = this.head;
		Node right = this.head;
		HeapMover left = new HeapMover(leftval);
		Reverse_Data_Recurssive(left, right, 0);

	}

	private void Reverse_Data_Recurssive(HeapMover left, Node right, int level) {
		if (right == null) {
			return;
		}
		this.Reverse_Data_Recurssive(left, right.next, level + 1);
		if (level >= this.size() / 2) {
			T temp = right.data;
			right.data = left.node.data;
			left.node.data = temp;
			left.node = left.node.next;
		}
	}

	// this function is used to save some data on the heap
	private class HeapMover {
		Node node;

		public HeapMover(Node node) {
			this.node = node;
		}
	}

	public T mid() {
		return this.midnode().data;
	}

	private Node midnode() {
		Node Slow = this.head;
		Node Fast = this.head;
		while (Fast.next != null && Fast.next.next != null) {
			Slow = Slow.next;
			Fast = Fast.next.next;
		}

		return Slow;
	}

	public T KthFromLast(int k) {
		return KthNodeFromLast(k).data;
	}

	private Node KthNodeFromLast(int k) {
		Node Slow = this.head;
		Node Fast = this.head;
		for (int i = 1; i <= k; i++) {
			Fast = Fast.next;
		}
		while (Fast.next != null) {
			Slow = Slow.next;
			Fast = Fast.next;
		}
		return Slow.next;
	}

	public LinkedList<T> merge(LinkedList<T> other) {
		LinkedList<T> retval = new LinkedList<>();
		Node maintemp = this.head;
		Node othertemp = other.head;
		while (maintemp != null && othertemp != null) {
			if (maintemp.data.compareTo(othertemp.data) < 0) {
				retval.AddLast(maintemp.data);
				maintemp = maintemp.next;
			} else {
				retval.AddLast(othertemp.data);
				othertemp = othertemp.next;
			}
		}
		while (maintemp != null) {
			retval.AddLast(maintemp.data);
			maintemp = maintemp.next;
		}
		while (othertemp != null) {
			retval.AddLast(othertemp.data);
			othertemp = othertemp.next;
		}

		return retval;
	}

	public void mergeSort() {
		LinkedList<T> myanswer = this.mergeSortHelper();
		this.head = myanswer.head;
		this.tail = myanswer.tail;
		this.size = myanswer.size;
	}

	private LinkedList<T> mergeSortHelper() {
		// Base Case
		if (this.size() == 1) {
			return this;
		}
		// My Job
		Node mid = this.midnode();
		Node midpo = mid.next;
		mid.next = null;
		LinkedList<T> first = new LinkedList<>(this.head, mid, (this.size() + 1) / 2);
		LinkedList<T> second = new LinkedList<>(midpo, this.tail, this.size() / 2);
		first = first.mergeSortHelper();
		second = second.mergeSortHelper();
		LinkedList<T> retval = first.merge(second);
		return retval;

	}

	public void KSort(int k) throws Exception {

	}

	public void Swap(int indx1, int indx2) {
		int j;
		int lower;
		// to check which index is greater
		if (indx1 > indx2) {
			j = indx1 - indx2;
			lower = indx2;
		} else {
			j = indx2 - indx1;
			lower = indx1;
		}
		Node first = this.head;
		Node second = this.head;
		for (int i = 1; i <= j; i++) {
			second = second.next;
		}
		for (int i = 0; i < lower; i++) {
			first = first.next;
			second = second.next;
		}
		// Now we have reached the two nodes whose data is is to be swaped...
		// Now Swapping the data
		T temp = first.data;
		first.data = second.data;
		second.data = temp;
	}

	public void EliminateDuplicates() {
		this.mergeSort();
		EliminateDuplicates(this.head);
	}

	private void EliminateDuplicates(Node cn) {
		// Base Case
		if (cn.next == null) {
			return;
		}
		// my Job
		if (cn.data == cn.next.data) {
			cn.next = cn.next.next;
			EliminateDuplicates(cn);
		} else {
			EliminateDuplicates(cn.next);
		}
	}

	public boolean isPalindrome() {
		boolean retval = false;
		HeapMover left = new HeapMover(this.head);
		Node right = this.head;
		if (isPalindrom(left, right, 0)) {
			retval = true;
		}
		return retval;
	}

	private boolean isPalindrom(HeapMover left, Node right, int level) {
		if (right == null) {
			return true;
		}
		// my job
		boolean ans = isPalindrom(left, right.next, level + 1);
		if (level <= this.size() / 2) {
			return ans;
		}
		if (ans) {
			if (left.node.data == right.data) {
				left.node = left.node.next;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean isEqual(LinkedList<?> other) {
		return this.size == other.size;
	}

	public int Find(T data) {
		int retval = -1;
		Node temp = this.head;
		int counter = 0;
		while (temp != null) {
			if (temp.data.equals(data)) {
				retval = counter;
				break;
			}
			temp = temp.next;
			counter++;
		}
		return retval;
	}
}