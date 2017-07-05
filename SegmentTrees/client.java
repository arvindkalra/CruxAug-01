package SegmentTrees;

public class client {

	public static void main(String[] args) {
		int[] arr = { 10, 1, 15, -5, -9, 12, 18, 0 };
		ST st = new ST(arr);
		System.out.println(st.query(2, 5));

	}

}
