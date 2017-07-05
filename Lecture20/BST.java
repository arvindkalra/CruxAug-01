package Lecture20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BST {

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

	public BST() {
		this.root = null;
		this.size = 0;
	}

	public BST(int[] arr) {
		this.root = ConstructBST(arr, 0, arr.length - 1);
	}

	private Node ConstructBST(int[] arr, int si, int li) {
		if (si > li) {
			return null;
		}
		int mid = (si + li) / 2;
		Node node = new Node(arr[mid], null, null);
		this.size++;
		node.left = ConstructBST(arr, si, mid - 1);
		node.right = ConstructBST(arr, mid + 1, li);
		return node;
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
		return max(this.root);
	}

	private int max(Node node) {
		int retval = node.data;
		if (node.right != null) {
			retval = max(node.right);
		}
		return retval;
	}

	public int min() {
		return min(this.root);
	}

	private int min(Node node) {
		int retval = node.data;
		if (node.left != null) {
			retval = min(node.left);
		}
		return retval;
	}

	public boolean find(int k) {
		return this.find(this.root, k);
	}

	private boolean find(Node node, int k) {
		if (node == null) {
			return false;
		}
		if (k > node.data) {
			return this.find(node.right, k);
		} else if (k < node.data) {
			return this.find(node.left, k);
		} else {
			return true;
		}
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

	public void AddData(int k) {
		if (this.root == null) {
			this.root = new Node(k, null, null);
		} else {
			this.AddData(this.root, k, false);
		}
	}

	private void AddData(Node node, int k, boolean isAdded) {
		if (isAdded) {
			return;
		}
		if (k < node.data) {
			if (node.left == null) {
				node.left = new Node(k, null, null);
				isAdded = true;
				this.size++;
				return;
			} else {
				AddData(node.left, k, isAdded);
			}
		} else if (k > node.data) {
			if (node.right == null) {
				node.right = new Node(k, null, null);
				isAdded = true;
				this.size++;
			} else {
				AddData(node.right, k, isAdded);
			}
		} else {

		}
	}

	public void RemoveData(int data) {
		RemoveData(this.root, data);
	}

	private Node RemoveData(Node node, int k) {
		if (node == null) {
			return null;
		}

		if (k < node.data) {
			node.left = RemoveData(node.left, k);
			return node;
		} else if (k > node.data) {
			node.right = RemoveData(node.right, k);
			return node;
		} else {
			// remove here
			if (node.left == null && node.right == null) {
				this.size--;
				return null;
			} else if (node.left == null) {
				this.size--;
				return node.right;
			} else if (node.right == null) {
				this.size--;
				return node.left;
			} else {
				int lmax = this.max(node.left);
				node.data = lmax;
				node.left = RemoveData(node.left, lmax);
				return node;
			}
		}
	}

	public void PrintInRange(int lowerlimit, int upperlimit) {
		PrintInRange(root, lowerlimit, upperlimit);
		System.out.println("END");
	}

	private void PrintInRange(Node node, int k1, int k2) {
		if (node == null) {
			return;
		}

		if (k1 > node.data && k2 > node.data) {
			PrintInRange(node.right, k1, k2);
		} else if (k1 < node.data && k2 < node.data) {
			PrintInRange(node.left, k1, k2);
		} else {

			PrintInRange(node.left, k1, k2);
			System.out.print(node.data + ", ");
			PrintInRange(node.right, k1, k2);
		}
	}

	public void MakeSortedBST() {
		PairMS p = MakeSortedBST(this.root);
		this.root = p.head;
	}

	private PairMS MakeSortedBST(Node node) {
		if (node.left == null && node.right == null) {
			PairMS mp = new PairMS(node, node);
			return mp;
		} else if (node.left == null) {
			PairMS mp = new PairMS(node, node.right);
			return mp;
		} else if (node.right == null) {
			PairMS lp = MakeSortedBST(node.left);
			lp.tail.right = node;
			node.left = null;
			PairMS mp = new PairMS(lp.head, node);
			return mp;
		}
		PairMS lpair = MakeSortedBST(node.left);
		PairMS rpair = MakeSortedBST(node.right);
		lpair.tail.right = node;
		node.left = null;
		node.right = rpair.head;
		PairMS mypair = new PairMS(lpair.head, rpair.tail);
		return mypair;
	}

	private class PairMS {
		Node head;
		Node tail;

		public PairMS(Node head, Node tail) {
			this.head = head;
			this.tail = tail;
		}
	}
}
