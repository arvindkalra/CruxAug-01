package SegmentTrees;

public class ST {
	private class Node {
		int si;
		int ei;
		Node left;
		Node right;
		int data;
	}

	private Node root;

	public ST(int[] arr) {
		this.root = makeST(arr, 0, arr.length - 1);
	}

	private Node makeST(int[] arr, int si, int ei) {
		if (si == ei) {
			Node rv = new Node();
			rv.si = si;
			rv.ei = ei;
			rv.left = null;
			rv.right = null;
			rv.data = arr[si];

			return rv;
		}

		int mid = (si + ei) / 2;

		Node rv = new Node();
		rv.si = si;
		rv.ei = ei;
		rv.left = makeST(arr, si, mid);
		rv.right = makeST(arr, mid + 1, ei);
		rv.data = rv.left.data + rv.right.data;

		return rv;
	}

	public int query(int qsi, int qei) {
		return query(qsi, qei, this.root);
	}

	private int query(int qsi, int qei, Node node) {
		if (isExcluded(qsi, qei, node)) {
			return 0;
		} else if (isWithin(qsi, qei, node)) {
			return node.data;
		} else {
			int i = query(qsi, qei, node.left);
			int j = query(qsi, qei, node.right);
			return i + j;
		}
	}

	private boolean isWithin(int qsi, int qei, Node node) {
		return node.si >= qsi && node.ei <= qei;
	}

	private boolean isExcluded(int qsi, int qei, Node node) {
		return node.ei < qsi || node.si > qei;
	}

	private int update(int nv, int idx, Node node) {
		if (idx > node.ei || idx < node.si) {
			return node.data;
		}

		int vall = update(nv, idx, node.left);
		int valr = update(nv, idx, node.right);
		return vall + valr;
	}

	public void update(int nv, int idx) {
		this.root.data = update(nv, idx, this.root);
	}
}
