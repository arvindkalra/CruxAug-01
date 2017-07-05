package Lecture24;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		// Heap<Integer, String> he = new Heap<>(false);
		//
		// he.add(57, "A");
		// he.Display();
		//
		// he.add(87, "G");
		// he.Display();
		//
		// he.add(27, "F");
		// he.Display();
		//
		// he.add(97, "E");
		// he.Display();
		// he.add(111, "Z");
		// he.add(5, "D");
		// he.Display();
		//
		// he.add(34, "C");
		// he.Display();
		//
		// he.add(63, "B");
		// he.Display();
		//
		// he.add(100, "I");
		// he.Display();
		//
		// he.treeDisplay();
		//
		// System.out.println(he.removeHP());
		// System.out.println(he.removeHP());
		// he.treeDisplay();
		// System.out.println(he.getHP());

		int[] arr = { 30, 60, 10, 20, 70, 40, 80, 100, 50, 90 };
		HeapSort(arr);
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("END");
	}

	public static void HeapSort(int[] arr) {

		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			downHeapify(arr, i, arr.length);
		}

		for (int i = 0; i < arr.length - 1; i++) {
			swap(arr, 0, arr.length - i - 1);
			downHeapify(arr, 0, arr.length - i - 1);
		}
	}

	public static void downHeapify(int[] arr, int pi, int li) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mi = pi;

		if (lci < li && arr[lci] > arr[mi]) {
			mi = lci;
		}
		if (rci < li && arr[rci] > arr[mi]) {
			mi = rci;
		}

		if (mi != pi) {
			swap(arr, mi, pi);
			downHeapify(arr, mi, li);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
