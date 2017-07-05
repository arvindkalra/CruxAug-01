package Lecture18_Tree;

public class Client {

	public static void main(String[] args) throws Exception {
		// 10 3 20 2 50 0 60 0 30 1 70 0 40 2 80 0 90 0
		GenericTree tree = new GenericTree();
		// System.out.println("***********DISPLAY***********");
		// tree.display();
		// System.out.println(tree.max());
		// System.out.println(tree.find(100));
		// System.out.println(tree.size2());
		// System.out.println(tree.height());
		// tree.PrintAtk(0);
		// System.out.println(tree.maxsumoc());
		// System.out.println(tree.justLarger(1));
		// System.out.println(tree.kthsmallest(5));
		// System.out.println(tree.justSmaller(14));
		// System.out.println(tree.kthlargest(3));
		// // tree.preOrder();
		// // tree.postOrder();
		// // tree.preOrderIterative();
		// // tree.levelPrintIterative();
		// System.out.println(tree.CountLeafNodes());
		// tree.mirror();
		tree.levelorderlinewise();
		System.out.println("***************************");
		tree.levelorderzigzag();
	}

}
