package Lecture20;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst = new BST();
		bst.AddData(50);
		bst.AddData(75);
		bst.AddData(75);
		bst.AddData(25);
		bst.AddData(37);
		bst.AddData(90);
		bst.AddData(12);
		bst.AddData(80);
		bst.AddData(62);
		bst.Display();

		bst.PrintInRange(26, 63);
		System.out.println();

		bst.MakeSortedBST();
		bst.Display();

		int[] arr = { 12, 25, 37, 50, 62, 75, 80, 90 };
		BST bst2 = new BST(arr);
		bst2.Display();
	}

}
