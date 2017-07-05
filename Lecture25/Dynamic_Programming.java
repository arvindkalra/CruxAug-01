package Lecture25;

public class Dynamic_Programming {

	public static long startedAt;

	public static void Start() {
		Dynamic_Programming.startedAt = System.currentTimeMillis();
	}

	public static long duration() {
		return System.currentTimeMillis() - Dynamic_Programming.startedAt;
	}

	public static void main(String[] args) {
		// int N = 10;
		// FIBONACCI
		// System.out.println("******FIBONACCI******");
		// Dynamic_Programming.Start();
		// System.out.println(FibR(N));
		// System.out.println(Dynamic_Programming.duration() + " for FibR");
		//
		// Dynamic_Programming.Start();
		// System.out.println(FibRS(N, new int[N + 1]));
		// System.out.println(Dynamic_Programming.duration() + " for FibRS");
		//
		// Dynamic_Programming.Start();
		// System.out.println(FibIS(N));
		// System.out.println(Dynamic_Programming.duration() + " for FibIS");
		//
		// Dynamic_Programming.Start();
		// System.out.println(FibISS(N));
		// System.out.println(Dynamic_Programming.duration() + " for FibISS");
		//
		// // COUNT BOARD PATHS
		// System.out.println("******BOARD PATHS******");
		// Dynamic_Programming.Start();
		// System.out.println(CountBoardR(0, N));
		// System.out.println(Dynamic_Programming.duration() + " for
		// CountBoardR");
		//
		// Dynamic_Programming.Start();
		// System.out.println(CountBoardRS(0, N, new int[N + 1]));
		// System.out.println(Dynamic_Programming.duration() + " for
		// CountBoardRS");
		//
		// Dynamic_Programming.Start();
		// System.out.println(CountBoardIS(N));
		// System.out.println(Dynamic_Programming.duration() + " for
		// CountBoardIS");
		//
		// Dynamic_Programming.Start();
		// System.out.println(CountBoardISS(N));
		// System.out.println(Dynamic_Programming.duration() + " for
		// CountBoardISS");

		int tr = 5, tc = 10  ;
		// COUNT MAZE PATHS
		System.out.println("******MAZE PATHS******");
		Dynamic_Programming.Start();
		System.out.println(CMPR(tr, tc, 0, 0));
		System.out.println(Dynamic_Programming.duration() + " for CMPR");

		Dynamic_Programming.Start();
		System.out.println(CMPRS(tr, tc, 0, 0, new int[tr + 1][tc + 1]));
		System.out.println(Dynamic_Programming.duration() + " for CMPRS");

		Dynamic_Programming.Start();
		System.out.println(CMPIS(tr, tc));
		System.out.println(Dynamic_Programming.duration() + " for CMPIS");

		Dynamic_Programming.Start();
		System.out.println(CMPISS(tr, tc));
		System.out.println(Dynamic_Programming.duration() + " for CMPISS");

		// COUNT MAZE PATHS WITH DIAGONALS
		Dynamic_Programming.Start();
		System.out.println(CMPWithDiagonalIS(tr, tc));
		System.out.println(Dynamic_Programming.duration() + " for CMPWithDiagonalIS");
		
		Dynamic_Programming.Start();
		System.out.println(CMPWithDiagonalISS(tr, tc));
		System.out.println(Dynamic_Programming.duration() + " for CMPWithDiagonalISS");
	}

	public static int FibR(int num) {
		if (num == 0 || num == 1) {
			return num;
		}
		int nm1 = FibR(num - 1);
		int nm2 = FibR(num - 2);
		int n = nm1 + nm2;

		return n;
	}

	public static int FibRS(int num, int[] storage) {
		if (num == 0 || num == 1) {
			return num;
		}
		if (storage[num] != 0) {
			return storage[num];
		}
		int nm1 = FibRS(num - 1, storage);
		int nm2 = FibRS(num - 2, storage);
		int n = nm1 + nm2;

		storage[num] = n;
		return n;
	}

	public static int FibIS(int num) {
		int[] storage = new int[num + 1];

		storage[0] = 0;
		storage[1] = 1;

		for (int i = 2; i <= num; i++) {
			storage[i] = storage[i - 1] + storage[i - 2];
		}

		return storage[num];
	}

	public static int FibISS(int num) {
		int[] storage = new int[2];

		storage[0] = 0;
		storage[1] = 1;

		for (int i = 2; i <= num; i++) {
			int temp = storage[0] + storage[1];
			storage[0] = storage[1];
			storage[1] = temp;
		}

		return storage[1];
	}

	public static int CountBoardR(int start, int end) {
		int count = 0;
		if (start == end) {
			return 1;
		}
		if (start > end) {
			return 0;
		}
		for (int dice = 1; dice <= 6; dice++) {
			count += CountBoardR(start + dice, end);
		}

		return count;
	}

	public static int CountBoardRS(int start, int end, int[] storage) {
		if (start == end) {
			return 1;
		}
		if (start > end) {
			return 0;
		}
		if (storage[start] != 0) {
			return storage[start];
		}

		int count = 0;
		for (int th = 1; th <= 6; th++) {
			count += CountBoardRS(start + th, end, storage);
		}
		storage[start] = count;
		return count;
	}

	public static int CountBoardIS(int N) {
		int[] storage = new int[N + 1];
		storage[N] = 1;

		for (int i = N - 1; i >= 0; i--) {
			int sum = 0;
			for (int j = i + 1; j <= i + 6 && j < storage.length; j++) {
				sum += storage[j];
			}
			storage[i] = sum;
		}

		return storage[0];
	}

	public static int CountBoardISS(int N) {
		int[] storage = new int[6];
		storage[0] = 1;
		storage[1] = 0;
		storage[2] = 0;
		storage[3] = 0;
		storage[4] = 0;
		storage[5] = 0;

		for (int i = N - 1; i >= 0; i--) {
			int sum = 0;
			for (int j = 0; j <= 5 && j < storage.length; j++) {
				sum += storage[j];
			}
			int[] myst = new int[6];
			myst[0] = sum;
			for (int j = 1; j < storage.length; j++) {
				myst[j] = storage[j - 1];
			}
			storage = myst;
		}

		return storage[0];
	}

	public static int CMPR(int tr, int tc, int cr, int cc) {
		int count = 0;
		if (cr == tr && cc == tc) {
			return 1;
		}
		if (cr == tr) {
			count += CMPR(tr, tc, cr, cc + 1);
			return count;
		}
		if (cc == tc) {
			count += CMPR(tr, tc, cr + 1, cc);
			return count;
		}
		count += CMPR(tr, tc, cr + 1, cc);
		count += CMPR(tr, tc, cr, cc + 1);
		return count;
	}

	public static int CMPRS(int tr, int tc, int cr, int cc, int[][] storage) {
		int count = 0;
		if (cr == tr && cc == tc) {
			return 1;
		}
		if (storage[cr][cc] != 0) {
			return storage[cr][cc];
		}

		if (cr == tr) {
			count += CMPRS(tr, tc, cr, cc + 1, storage);
			return count;
		}
		if (cc == tc) {
			count += CMPRS(tr, tc, cr + 1, cc, storage);
			return count;
		}
		count += CMPRS(tr, tc, cr + 1, cc, storage);
		count += CMPRS(tr, tc, cr, cc + 1, storage);
		storage[cr][cc] = count;
		return count;
	}

	public static int CMPIS(int tr, int tc) {
		int[][] store = new int[tr + 1][tc + 1];

		store[tr][tc] = 1;

		for (int i = tr; i >= 0; i--) {
			for (int j = tc; j >= 0; j--) {
				if (j == tc && i == tr) {
					store[i][j] = 1;
				} else if (j == tc) {
					store[i][j] = store[i + 1][j];
				} else if (i == tr) {
					store[i][j] = store[i][j + 1];
				} else {
					store[i][j] = store[i + 1][j] + store[i][j + 1];
				}
			}
		}

		return store[0][0];
	}

	public static int CMPISS(int tr, int tc) {
		int[] store = new int[tc + 1];
		for (int i = 0; i < store.length; i++) {
			store[i] = 1;
		}

		for (int i = tr - 1; i >= 0; i--) {
			for (int j = tc; j >= 0; j--) {
				if (j == tc) {
					// nothing to do..
				} else {
					store[j] += store[j + 1];
				}
			}
		}
		return store[0];
	}

	public static int CMPWithDiagonalIS(int tr, int tc) {
		int[][] store = new int[tr + 1][tc + 1];

		store[tr][tc] = 1;

		for (int i = tr; i >= 0; i--) {
			for (int j = tc; j >= 0; j--) {
				if (j == tc && i == tr) {
					store[i][j] = 1;
				} else if (j == tc) {
					store[i][j] = store[i + 1][j];
				} else if (i == tr) {
					store[i][j] = store[i][j + 1];
				} else {
					store[i][j] = store[i + 1][j] + store[i][j + 1] + store[i + 1][j + 1];
				}
			}
		}

		return store[0][0];
	}

	public static int CMPWithDiagonalISS(int tr, int tc) {
		int[] store = new int[tc + 1];
		for (int i = 0; i < store.length; i++) {
			store[i] = 1;
		}

		for (int i = tr - 1; i >= 0; i--) {
			int[] arr = new int[tc + 1];
			for (int j = tc; j >= 0; j--) {
				if (j == tc) {
					arr[j] = store[j];
				} else {
					arr[j] = store[j + 1] + store[j] + arr[j + 1];
				}
			}
			store = arr;
		}
		return store[0];
	}

}
