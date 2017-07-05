package Lecture24;

import java.util.ArrayList;

public class Heap<K extends Comparable<K>, V> {
	private class HeapNode implements Comparable<HeapNode> {
		K score; // Marks used to check priority
		V value; // Actual name or value

		public HeapNode(K score, V value) {
			this.score = score;
			this.value = value;
		}

		@Override
		public String toString() {
			return "{" + this.score + " : " + this.value + "}";
		}

		@Override
		public int compareTo(Heap<K, V>.HeapNode o) {
			if (isMin) {
				return -1 * this.score.compareTo(o.score);
			} else {
				return this.score.compareTo(o.score);
			}
		}

	}

	private boolean isMin;
	private ArrayList<HeapNode> list;

	public Heap() {
		this(false);
	}

	public Heap(boolean isMin) {
		this.isMin = isMin;
		this.list = new ArrayList<>();
	}

	public Heap(K[] scores, V[] values, boolean isMin) {
		this(isMin);
		for (int i = 0; i < scores.length; i++) {
			this.list.add(new HeapNode(scores[i], values[i]));
		}
		for (int i = (this.size() - 1) / 2; i >= 0; i--) {
			this.downheapify(i);
		}
	}

	public void Display() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return list.toString();
	}

	public int size() {
		return this.list.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void add(K score, V value) {
		HeapNode ntba = new HeapNode(score, value);
		list.add(ntba);

		upheapify(list.size() - 1);
	}

	private void upheapify(int ci) {
		if (ci == 0) {
			return;
		}

		int pi = (ci - 1) / 2;
		if (list.get(pi).compareTo(list.get(ci)) < 0) {
			swap(pi, ci);
			upheapify(pi);
		}
	}

	public V removeHP() {
		V retval = this.list.get(0).value;
		swap(0, this.list.size() - 1);
		this.list.remove(this.list.size() - 1);
		downheapify(0);

		return retval;
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mi = pi;
		if (lci < this.list.size() && this.list.get(lci).compareTo(this.list.get(mi)) > 0) {
			mi = lci;
		}
		if (rci < this.list.size() && this.list.get(rci).compareTo(this.list.get(mi)) > 0) {
			mi = rci;
		}

		if (mi != pi) {
			swap(mi, pi);
			downheapify(mi);
		}
	}

	public V getHP() {
		return this.list.get(0).value;
	}

	private void swap(int i, int j) {
		HeapNode temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	public void treeDisplay() {
		System.out.println("********DISPLAY********");
		this.treeDisplay(0);
		System.out.println("**********END**********");
	}

	private void treeDisplay(int pi) {
		if (pi >= this.list.size()) {
			return;
		}
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		if (lci < this.list.size() && rci < this.list.size()) {
			System.out.print(this.list.get(lci));
			System.out.print(" => ");
			System.out.print(this.list.get(pi));
			System.out.print(" <= ");
			System.out.println(this.list.get(rci));
		} else if (lci < this.list.size()) {
			System.out.print(this.list.get(lci));
			System.out.print(" => ");
			System.out.print(this.list.get(pi));
			System.out.print(" <= ");
			System.out.println("END");
		} else if (rci < this.list.size()) {
			System.out.print("END");
			System.out.print(" => ");
			System.out.print(this.list.get(pi));
			System.out.print(" <= ");
			System.out.println(this.list.get(rci));
		} else {
			System.out.print("END");
			System.out.print(" => ");
			System.out.print(this.list.get(pi));
			System.out.print(" <= ");
			System.out.println("END");
		}

		treeDisplay(lci);
		treeDisplay(rci);
	}

	public void updateKey(K score, V value) {
		HeapNode ntbu = null;
		int idx = 0;

		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).value.equals(value)) {
				ntbu = this.list.get(i);
				idx = i;
				break;
			}
		}

		ntbu.score = score;
		int pi = (idx - 1) / 2;
		// wheather to upheapify or downheapify....

		if (this.list.get(pi).compareTo(ntbu) < 0) {
			upheapify(idx);
		} else {
			downheapify(idx);
		}
	}
}
