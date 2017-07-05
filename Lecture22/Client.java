package Lecture22;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector.Characteristics;
import java.util.Map.Entry;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] one = { 1, 1, 2, 2, 2, 3, 5 };
		int[] two = { 1, 1, 1, 2, 2, 3, 4 };
		ArrayList<Integer> arr = getIntersectionBtr(one, two);
		System.out.println(arr);
		String str = "arvind kalra";
		char c = highestFrequencyChar(str);
		System.out.println(c);
		int[] xy = { 5, 3, -5, -3, 3, 5, -5, 0, 0, 0 };
		ArrayList<ArrayList<Integer>> ans = sumZero(xy);
		System.out.println(ans);
		int[] ab = { 1, 1, 2, 3, 2, 2, 3, 4, 4 };
		System.out.println(getUnique(ab));

	}

	public static ArrayList<Integer> getIntersection(int[] one, int[] two) {
		ArrayList<Integer> retval = new ArrayList<>();

		HashMap<Integer, Boolean> ht = new HashMap<>();

		for (int i = 0; i < one.length; i++) {
			ht.put(one[i], false);
		}

		for (int i = 0; i < two.length; i++) {
			if (ht.containsKey(two[i])) {
				ht.put(two[i], true);
			}
		}

		Set<Map.Entry<Integer, Boolean>> entries = ht.entrySet();

		for (Map.Entry<Integer, Boolean> entry : entries) {
			if (entry.getValue()) {
				retval.add(entry.getKey());
			}
		}
		return retval;
	}

	public static ArrayList<Integer> getIntersectionBtr(int[] one, int[] two) {
		ArrayList<Integer> retval = new ArrayList<>();

		HashMap<Integer, Integer> ht = new HashMap<>();

		for (int i = 0; i < one.length; i++) {
			if (ht.containsKey(one[i])) {
				int x = ht.get(one[i]);
				ht.put(one[i], x + 1);
			} else {
				ht.put(one[i], 1);
			}
		}

		for (int i = 0; i < two.length; i++) {
			if (ht.containsKey(two[i])) {
				int ov = ht.get(two[i]);
				if (ov > 0) {
					retval.add(two[i]);
					ov--;
					ht.put(two[i], ov);
				}
			}
		}
		return retval;
	}

	public static char highestFrequencyChar(String str) {
		char retval = ' ';
		int max = 0;
		HashMap<Character, Integer> ht = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (ht.containsKey(str.charAt(i))) {
				int x = ht.get(str.charAt(i));
				ht.put(str.charAt(i), x + 1);
			} else {
				ht.put(str.charAt(i), 1);
			}
		}
		for (int i = 0; i < str.length(); i++) {
			int x = ht.get(str.charAt(i));
			if (x > max) {
				max = x;
				retval = str.charAt(i);
			}
		}
		return retval;
	}

	public static ArrayList<ArrayList<Integer>> sumZero(int[] arr) {
		ArrayList<ArrayList<Integer>> retval = new ArrayList<>();

		HashMap<Integer, Integer> ht = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			int rev = -1 * arr[i];
			if (ht.containsKey(rev)) {
				if (ht.get(rev) > 0) {
					ArrayList<Integer> abc = new ArrayList<>();
					abc.add(rev);
					abc.add(arr[i]);

					int ov = ht.get(rev);
					ov--;
					ht.put(rev, ov);
					retval.add(abc);
				}
			} else {
				ht.put(arr[i], 1);
			}
		}

		return retval;
	}

	public static ArrayList<Integer> getUnique(int[] arr) {
		ArrayList<Integer> retval = new ArrayList<>();

		HashMap<Integer, Integer> ht = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			ht.put(arr[i], 0);
		}

		Set<Integer> keys = ht.keySet();
		for (Integer val : keys) {
			retval.add(val);
		}
		return retval;
	}
}
