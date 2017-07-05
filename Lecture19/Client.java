package Lecture19;

public class Client {

	public static void main(String[] args) {
		// 50 true 25 true 12 false false true 37 false false true 75 true 65
		// false false true 80 false false
		//
		// 10 true 20 true 40 false false true 50 false false true 30 true 71
		// false false true 70 false false
		//
		// 10 true 20 true 40 false false false true 30 true 50 false false
		// false
		//
		// 1 true 10 true 7 false false true 12 false false true 6 true 15 false
		// true 8 false false true 2 false true 20 false false 1 true 10 false
		// true 100 false false true 12 true 3 false false true 4 false false
		BinaryTree tree = new BinaryTree();
		tree.lineOrderLineWise();
		System.out.println(tree.size());
		System.out.println(tree.isEmpty());
		tree.Display();
		System.out.println(tree.size2());
		System.out.println(tree.max());
		System.out.println(tree.min());
		System.out.println(tree.find(71));
		// System.out.println(tree.height());
		System.out.println(tree.Diameter());
		tree.Display();
		// tree.mirror();
		// System.out.println("*********MIRROR********");
		// System.out.println(tree);
		tree.inOrder();
		tree.preOrder();
		tree.preOrderIterative();
		tree.postOrder();
		tree.lineOrder();
		int[] in = { 12, 25, 37, 50, 62, 75, 87 };
		int[] pre = { 50, 25, 12, 37, 75, 62, 87 };
		BinaryTree tr = new BinaryTree(pre, in);
		System.out.println(tr);
		System.out.println(tree.MaxSum());
		// System.out.println(tree.isBst());
		// System.out.println(tree.isBST2());
		System.out.println(tree.isBST3());
	}

}
