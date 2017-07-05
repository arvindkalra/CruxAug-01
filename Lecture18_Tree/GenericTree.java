package Lecture18_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GenericTree {

	private class Node {
		int data;
		ArrayList<Node> Children;

		private Node(int data, ArrayList<Node> Children) {
			this.data = data;
			this.Children = Children;
		}
	}

	private Node root;
	private int size;

	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		this.root = takeInput(scn, null, -1);
	}

	private Node takeInput(Scanner scn, Node parent, int ithchild) {
		if (parent == null) {
			System.out.println("Please Enter the Data For Root Node...");
		} else {
			System.out.println("Please Enter the Data For " + ithchild + "th Child of " + parent.data + "...");
		}
		int childData = scn.nextInt();

		System.out.println("Please Enter thr Number Of Children...");
		int numgrandchild = scn.nextInt();

		Node child = new Node(childData, new ArrayList<>());
		this.size++;

		for (int i = 1; i <= numgrandchild; i++) {
			Node grandchild = takeInput(scn, child, i);
			child.Children.add(grandchild);
		}
		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return this.toString(this.root);
	}

	private String toString(Node node) {
		String retval = "";
		retval += node.data + " => ";
		for (int i = 0; i < node.Children.size(); i++) {
			retval += node.Children.get(i).data + ", ";
		}
		retval += "END\n";
		for (int i = 0; i < node.Children.size(); i++) {
			retval += this.toString(node.Children.get(i));
		}
		return retval;
	}

	public int max() {
		return max(this.root, this.root.data);
	}

	private int max(Node node, int maxval) {
		if (node.data > maxval) {
			maxval = node.data;
		}

		for (int i = 0; i < node.Children.size(); i++) {
			maxval = max(node.Children.get(i), maxval);
		}
		return maxval;
	}

	public boolean find(int data) {
		return this.find(data, this.root);
	}

	private boolean find(int data, Node node) {
		boolean retval = false;
		if (node.data == data) {
			retval = true;
		}
		for (int i = 0; i < node.Children.size() && !retval; i++) {
			retval = find(data, node.Children.get(i));
		}

		return retval;

	}

	public int size2() {
		return size2(this.root);
	}

	private int size2(Node node) {
		int retval = 0;
		for (int i = 0; i < node.Children.size(); i++) {
			retval += size2(node.Children.get(i));
		}
		retval++;
		return retval;
	}

	public int height() {
		return this.height(this.root) - 1;
	}

	private int height(Node node) {
		int retval;
		int[] arr = new int[node.Children.size()];
		for (int i = 0; i < node.Children.size(); i++) {
			arr[i] = height(node.Children.get(i));
		}
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		retval = max + 1;
		return retval;
	}

	public void PrintAtk(int k) throws Exception {
		this.PrintAtk(this.root, k, 0);
		System.out.println("END");
	}

	private void PrintAtk(Node node, int k, int depth) throws Exception {
		if (k > this.height()) {
			throw new Exception("K is more than the Depth of Tree..");
		}
		if (k == 0) {
			System.out.print(this.root.data + ", ");
			return;
		}
		if (depth == k - 1) {
			for (int i = 0; i < node.Children.size(); i++) {
				System.out.print(node.Children.get(i).data + ", ");
			}
			return;
		}
		for (int i = 0; i < node.Children.size(); i++) {
			PrintAtk(node.Children.get(i), k, depth + 1);
		}
	}

	private int Score(Node node) {
		int retval = 0;
		for (int i = 0; i < node.Children.size(); i++) {
			retval += node.Children.get(i).data;
		}
		retval += node.data;
		return retval;
	}

	public int maxsumoc() {
		Pair nas = new Pair(0, this.root);
		return this.maxsumoc(this.root, nas).maxnode.data;
	}

	private Pair maxsumoc(Node node, Pair nas) {
		int abc = Score(node);
		if (abc > nas.maxscore) {
			nas.maxscore = abc;
			nas.maxnode = node;
		}

		for (int i = 0; i < node.Children.size(); i++) {
			nas = maxsumoc(node.Children.get(i), nas);
		}
		return nas;
	}

	private class Pair {
		int maxscore;
		Node maxnode;

		public Pair(int maxscore, Node maxnode) {
			this.maxscore = maxscore;
			this.maxnode = maxnode;
		}
	}

	public Integer justLarger(int k) {
		int retval;
		// hum ans ki val k se initialise karenge..
		// agar end mein answer k hi hoga toh matlab koi aisi value nahi mili jo
		// k se just badi ho
		retval = this.justLarger(k, this.root, k);
		// then we return null
		if (retval == k) {
			return null;
		}
		return retval;
	}

	private int justLarger(int inputval, Node node, int hamaraans) {
		// inputval vo value hai jo pichhe se input hui hai
		// agar ans abhi tak update ho gya hoga toh ans will not be equal to k
		// aur agar answer update ho gya hai toh may be we have already found
		// the just larger
		// nmber and to confirm our assumption we need to go to the other if
		if (node.data >= inputval && hamaraans == inputval) {
			hamaraans = node.data;
			// agar ans update ho gya hai but jis node par hum kahde hain uske
			// data ki value k se badi
			// hai but jo hamara answer hai usse data ki value chhoti hai toh
			// humara answer galat hai
			// so we need to update our answer
			// hence we update our answer
		} else if (node.data > inputval && node.data < hamaraans) {
			hamaraans = node.data;
		}

		for (int i = 0; i < node.Children.size(); i++) {
			hamaraans = justLarger(inputval, node.Children.get(i), hamaraans);
		}
		return hamaraans;

	}

	public int kthsmallest(int k) {
		int lowest = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			lowest = justLarger(lowest);
		}
		return lowest;
	}

	private int justSmaller(int inputval, Node node, int hamaraans) {
		if (node.data <= inputval && hamaraans == inputval) {
			hamaraans = node.data;

		} else if (node.data < inputval && node.data > hamaraans) {
			hamaraans = node.data;
		}

		for (int i = 0; i < node.Children.size(); i++) {
			hamaraans = justSmaller(inputval, node.Children.get(i), hamaraans);
		}
		return hamaraans;
	}

	public Integer justSmaller(int k) {
		int retval;
		retval = this.justSmaller(k, this.root, k);
		if (retval == k) {
			return null;
		}
		return retval;
	}

	public int kthlargest(int k) {
		int big = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			big = justSmaller(big);
		}
		return big;
	}

	public void preOrder() {
		preOrder(this.root);
		System.out.println("END");
	}

	private void preOrder(Node node) {
		System.out.print(node.data + ", ");
		for (int i = 0; i < node.Children.size(); i++) {
			preOrder(node.Children.get(i));
		}
	}

	public void postOrder() {
		postOrder(this.root);
		System.out.println("END");
	}

	private void postOrder(Node node) {
		for (int i = 0; i < node.Children.size(); i++) {
			postOrder(node.Children.get(i));
		}
		System.out.print(node.data + ", ");
	}

	public void preOrderIterative() {
		Stack<Node> stack = new Stack<>();
		stack.push(this.root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.print(node.data + ", ");
			for (int i = node.Children.size() - 1; i >= 0; i--) {
				stack.push(node.Children.get(i));
			}
		}
		System.out.println("END");
	}

	public void levelPrintIterative() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(this.root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.data + ", ");
			for (int i = 0; i < node.Children.size(); i++) {
				queue.offer(node.Children.get(i));
			}
		}
		System.out.println("END");
	}

	public int CountLeafNodes() {
		return this.NoLeafNodes(this.root);
	}

	private int NoLeafNodes(Node node) {
		int count = 0;
		int countnumloop = 0;
		for (int i = 0; i < node.Children.size(); i++) {
			count += NoLeafNodes(node.Children.get(i));
			countnumloop++;
		}
		if (countnumloop == 0) {
			count++;
		}
		return count;
	}

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node node) {
		String str = node.data + " => ";
		int startval = node.Children.size() - 1;
		for (int i = startval; i >= 0; i--) {
			str += node.Children.get(i).data + ", ";
		}
		System.out.println(str + "END");
		for (int i = startval; i >= 0; i--) {
			this.mirror(node.Children.get(i));
		}
	}

	public void levelorderlinewise() {
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> queue2 = new LinkedList<>();
		queue.add(this.root);
		while (!queue.isEmpty()) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + ",");

			for (Node small : temp.Children) {
				queue2.addLast(small);
			}
			if (queue.isEmpty()) {
				LinkedList<Node> temp2 = queue;
				queue = queue2;
				queue2 = temp2;
				System.out.println();
			}
		}

	}

	public void levelorderzigzag() {
		// error h.w
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> queue2 = new LinkedList<>();
		LinkedList<Node> queue3 = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();
		int flag = 0;
		queue.add(this.root);
		while (!queue.isEmpty()) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + ",");

			if (flag % 2 == 0) {
				for (Node small : temp.Children) {
					queue3.addFirst(small);
				}

			} else {
				for (Node small : temp.Children) {
					helper.addLast(small);
				}
				queue2.addAll(0, helper);
				helper = new LinkedList<>();
			}

			if (queue.isEmpty()) {
				flag++;
				if (flag % 2 == 0) {
					queue = queue2;
					queue2 = new LinkedList<>();
					System.out.println();
				} else {
					queue = queue3;
					queue3 = new LinkedList<>();
					System.out.println();
				}
			}
		}

	}

}
