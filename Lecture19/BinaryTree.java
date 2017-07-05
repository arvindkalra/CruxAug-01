package Lecture19;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

	private class Node {
		int data;
		Node left;
		Node right;

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root;
	private int size;

	public BinaryTree() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, false);
	}

	public BinaryTree(int[] preOrder, int[] inOrder) {
		this.root = this.constructnode(preOrder, 0, preOrder.length, inOrder, 0, inOrder.length);
		this.size = preOrder.length;
	}

	private Node constructnode(int[] pre, int presi, int preei, int[] in, int insi, int inei) {
		if (presi > preei || insi > inei) {
			return null;
		}
		Node node = new Node(pre[presi], null, null);
		int lsi = -1;
		for (int i = insi; i <= inei; i++) {
			if (in[i] == node.data) {
				lsi = i;
				break;
			}
		}
		node.left = constructnode(pre, presi + 1, presi + lsi, in, insi, lsi - 1);
		node.right = constructnode(pre, presi + lsi + 1, preei, in, lsi + 1, inei);
		return node;
	}

	private Node takeInput(Scanner scn, Node parent, boolean isLeft) {
		if (parent == null) {
			System.out.println("Please Enter the data for root..");
		} else {
			if (isLeft) {
				System.out.println("Please Enter the data for left node of " + parent.data);
			} else {
				System.out.println("Please Enter the data for right node of " + parent.data);
			}
		}
		int cdata = scn.nextInt();
		Node child = new Node(cdata, null, null);
		this.size++;

		System.out.println("Do you want a left node for " + cdata);
		boolean choice = scn.nextBoolean();
		if (choice) {
			child.left = takeInput(scn, child, true);
		}
		System.out.println("Do you want a right node for " + cdata);
		choice = scn.nextBoolean();
		if (choice) {
			child.right = takeInput(scn, child, false);
		}
		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void Display() {
		System.out.println("********DISPLAY*******");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return this.toString(this.root);
	}

	private String toString(Node node) {
		if (node == null) {
			return "";
		}
		String retval = "";
		if (node.left == null) {
			retval += "END" + " => ";
		} else {
			retval += node.left.data + " => ";
		}
		retval += node.data;
		if (node.right == null) {
			retval += " <= " + "END";
		} else {
			retval += " <= " + node.right.data;
		}
		retval += "\n";
		retval += toString(node.left);
		retval += toString(node.right);
		return retval;
	}

	public int size2() {
		return size2(this.root);
	}

	private int size2(Node node) {
		int count = 0;
		if (node == null) {
			return 0;
		}
		count += size2(node.left);
		count += size2(node.right);
		count++;
		return count;

	}

	public int max() {
		return max(this.root, 0);
	}

	private int max(Node node, int maxval) {
		if (node == null) {
			return maxval;
		}
		if (node.data > maxval) {
			maxval = node.data;
		}
		maxval = max(node.left, maxval);
		maxval = max(node.right, maxval);
		return maxval;
	}

	public int min() {
		return min(this.root, this.root.data);
	}

	private int min(Node node, int minval) {
		if (node == null) {
			return minval;
		}
		if (node.data < minval) {
			minval = node.data;
		}
		minval = min(node.left, minval);
		minval = min(node.right, minval);
		return minval;
	}

	public boolean find(int k) {
		return this.find(this.root, k);
	}

	private boolean find(Node node, int k) {
		boolean retval = false;
		if (node == null) {
			return false;
		}
		if (node.data == k) {
			retval = true;
		}
		if (!retval) {
			retval = find(node.left, k);
		}
		if (!retval) {
			retval = find(node.right, k);
		}

		return retval;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		System.out.println("Hi for " + node);
		if (node == null) {
			return -1;
		}
		int retval;
		int leftht = height(node.left);
		int rightht = height(node.right);
		retval = (leftht > rightht) ? leftht : rightht;
		// if (leftht > rightht) {
		// retval = leftht;
		// } else {
		// retval = rightht;
		// }
		retval++;
		return retval;
	}

	public int Diameter() {
		return this.Diameter(this.root).diameter;
	}

	private Pair Diameter(Node node) {
		if (node == null) {
			Pair p = new Pair(-1, -1);
			return p;
		}
		Pair lp = Diameter(node.left);
		Pair rp = Diameter(node.right);
		int f1 = lp.diameter;
		int f2 = rp.diameter;
		int f3 = lp.height + rp.height + 2;
		int mydia = Math.max(f3, Math.max(f1, f2));
		int myheight = Math.max(lp.height, rp.height) + 1;
		Pair mypair = new Pair(myheight, mydia);
		return mypair;
	}

	private class Pair {
		int height;
		int diameter;

		Pair(int height, int diameter) {
			this.height = height;
			this.diameter = diameter;
		}
	}

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node node) {
		if (node == null) {
			return;
		}
		mirror(node.left);
		mirror(node.right);
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	public void inOrder() {
		this.inOrder(this.root);
		System.out.println("END");
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + ", ");
		inOrder(node.right);
	}

	public void preOrder() {
		this.preOrder(this.root);
		System.out.println("END");
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + ", ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder() {
		this.postOrder(this.root);
		System.out.println("END");
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + ", ");
	}

	public void preOrderIterative() {
		Stack<Node> stack = new Stack<>();
		stack.push(this.root);
		while (!stack.isEmpty()) {
			Node abc = stack.pop();
			System.out.print(abc.data + ", ");
			if (abc.right != null) {
				stack.push(abc.right);
			}
			if (abc.left != null) {
				stack.push(abc.left);
			}
		}
		System.out.println("END");
	}

	public void lineOrder() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(this.root);
		while (!queue.isEmpty()) {
			Node abc = queue.poll();
			System.out.print(abc.data + ", ");
			if (abc.left != null) {
				queue.offer(abc.left);
			}
			if (abc.right != null) {
				queue.offer(abc.right);
			}
		}
		System.out.println("END");
	}

	public void lineOrderLineWise() {
		System.out.println("**************LINE ORDER***********");
		Queue<Node> queue = new LinkedList<>();
		queue.offer(this.root);
		while (!queue.isEmpty()) {
			int siz = queue.size();
			for (int i = 0; i < siz; i++) {
				Node abc = queue.poll();
				System.out.print(abc.data + ", ");
				if (abc.left != null) {
					queue.offer(abc.left);
				}
				if (abc.right != null) {
					queue.offer(abc.right);
				}
			}
			System.out.println("END");
		}
		System.out.println("**************LINE ORDER***********");
	}

	private class Pairmax {
		int include;
		int exclude;

		public Pairmax(int include, int exclude) {
			this.include = include;
			this.exclude = exclude;
		}
	}

	public int MaxSum() {
		Pairmax ans = MaxSum(this.root);
		return Integer.max(ans.include, ans.exclude);
	}

	private Pairmax MaxSum(Node node) {
		if (node == null) {
			return new Pairmax(0, 0);
		}
		Pairmax LS = MaxSum(node.left);
		Pairmax RS = MaxSum(node.right);
		int itself = node.data;
		int includeSum = LS.exclude + RS.exclude + itself;
		int excludeSum = Integer.max(LS.exclude, LS.include) + Integer.max(RS.exclude, RS.include);

		return new Pairmax(includeSum, excludeSum);
	}

	private class LL {
		Node head;
		Node tail;

		public LL(Node head, Node tail) {
			this.head = head;
			this.tail = tail;
		}
	}

	public void ConvertLL() {
		// Todo
	}

	private LL ConvertLL(Node node) {
		if (node.left == null && node.right == null) {
			return new LL(node, node);
		} else if (node.left == null) {
			LL rightll = ConvertLL(node.right);
			node.right = rightll.head;
			return new LL(node, rightll.tail);
		} else if (node.right == null) {
			LL leftll = ConvertLL(node.left);
			leftll.tail.right = node;
			return new LL(leftll.head, node);
		} else {
			LL rightll = ConvertLL(node.right);
			LL leftll = ConvertLL(node.left);
			leftll.tail.right = node;
			node.right = rightll.head;
			return new LL(leftll.head, rightll.tail);
		}
	}

	public boolean isBST3() {
		return this.isBST3(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST3(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data < min && node.data > max) {
			return false;
		} else {
			boolean lb = isBST3(node.left, min, node.data);
			boolean rb = isBST3(node.right, node.data, max);
			return lb && rb;
		}
	}

	private class TripletBST {
		boolean is;
		int min;
		int max;

		public TripletBST(boolean is, int min, int max) {
			this.is = is;
			this.min = min;
			this.max = max;
		}
	}
}
