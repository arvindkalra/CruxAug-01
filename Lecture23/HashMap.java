package Lecture23;

import java.util.ArrayList;
import java.util.Collection;

import Lecture18.LinkedList;

public class HashMap<K, V> {

	private class HTNode implements Comparable<HTNode> {
		K key;
		V value;

		public HTNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			HTNode othernode = (HTNode) obj;
			return this.key.equals(othernode.key);
		}

		@Override
		public int compareTo(HTNode o) {
			return 0;
		}

		@Override
		public String toString() {
			return "{" + this.key + " : " + this.value + "}";
		}

	}

	private LinkedList<HTNode>[] BucketArray;

	private int size;

	private static final int DEFAULT_SIZE = 10;

	public HashMap() {
		this(DEFAULT_SIZE);
	}

	public HashMap(int cap) {
		this.BucketArray = (LinkedList<HTNode>[]) new LinkedList[cap];
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		System.out.println("******DISPLAY******");
		System.out.println(this);
	}

	@Override
	public String toString() {
		String retval = "";
		for (LinkedList<HTNode> buck : this.BucketArray) {
			if (buck == null) {
				retval += "NULL\n";
			} else {
				retval += buck.toString();
			}
		}
		return retval;
	}

	public V Get(K key) throws Exception {
		int bi = this.HashFunction(key);
		LinkedList<HTNode> buck = this.BucketArray[bi];

		HTNode node = new HTNode(key, null);

		if (buck == null) {
			return null;
		} else {
			int bfi = buck.Find(node);
			if (bfi == -1) {
				return null;
			} else {
				HTNode myn = buck.GetAt(bfi);
				return myn.value;
			}
		}
	}

	public int HashFunction(K key) {
		int retval = 0;
		int hcd = key.hashCode();
		hcd = Math.abs(hcd);

		retval = hcd % this.BucketArray.length;
		return retval;
	}

	public V Remove(K key) throws Exception {
		int bi = this.HashFunction(key);
		LinkedList<HTNode> buck = this.BucketArray[bi];

		HTNode node = new HTNode(key, null);

		if (buck == null) {
			return null;
		} else {
			int bfi = buck.Find(node);
			if (bfi == -1) {
				return null;
			} else {
				HTNode myn = buck.RemoveAt(bfi);
				this.size--;
				return myn.value;
			}
		}
	}

	public void put(K key, V value) throws Exception {
		int bi = this.HashFunction(key);
		LinkedList<HTNode> buck = this.BucketArray[bi];

		HTNode node = new HTNode(key, value);

		if (buck == null) {
			buck = new LinkedList<>();
			buck.AddLast(node);
			this.size++;
			this.BucketArray[bi] = buck;
		} else {
			int bfi = buck.Find(node);
			if (bfi == -1) {
				buck.AddLast(node);
				this.size++;
			} else {
				HTNode myn = buck.GetAt(bfi);
				myn.value = node.value;
			}
		}
		double lamda = (this.size * 1.0) / this.BucketArray.length;
		if (lamda > 0.75) {
			rehash();
		}
	}

	private void rehash() throws Exception {
		LinkedList<HTNode>[] obs = this.BucketArray;

		this.BucketArray = (LinkedList<HTNode>[]) new LinkedList[2 * obs.length];
		this.size = 0;

		for (LinkedList<HTNode> ob : obs) {
			while (ob != null && !ob.IsEmpty()) {
				HTNode ntba = ob.RemoveFirst();
				this.put(ntba.key, ntba.value);
			}
		}
	}
}
