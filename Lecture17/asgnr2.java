package Lecture17;

import java.util.ArrayList;

public class asgnr2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		printCodes("1123", "");
//		System.out.println(targetSum(new int[] {1, 2, 3, 4, 5}, 0, 5));
		printTargetSum(new int[] {1, 2, 3, 4, 5}, 0, 5, new ArrayList<>());
	}

	public static void printCodes(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return;
		}

		char cc = str.charAt(0);
		String ros1 = str.substring(1);
		char converted = (char) (cc - '1' + 'a');

		printCodes(ros1, result + converted);

		if (str.length() >= 2) {
			String cc2 = str.substring(0, 2);
			String ros2 = str.substring(2);
			int ii2 = Integer.parseInt(cc2, 10);

			if (ii2 <= 26) {
				converted = (char) (ii2 - 1 + 'a');
				printCodes(ros2, result + converted);
			}
		}
	}

	public static ArrayList<ArrayList<Integer>> targetSum(int[] arr, int si, int target) {
		if (si == arr.length - 1) {
			ArrayList<ArrayList<Integer>> baseResult = new ArrayList<>();

			if (target == arr[si]) {
				ArrayList<Integer> innerBaseResult = new ArrayList<>();
				innerBaseResult.add(arr[si]);
				baseResult.add(innerBaseResult);
			} else if (target == 0) {
				ArrayList<Integer> innerBaseResult = new ArrayList<>();
				baseResult.add(innerBaseResult);
			} else {
				// negative
			}

			return baseResult;
		}

		ArrayList<ArrayList<Integer>> myResult = new ArrayList<>();
		ArrayList<ArrayList<Integer>> recResultExclusion = targetSum(arr, si + 1, target);
		ArrayList<ArrayList<Integer>> recResultInclusion = targetSum(arr, si + 1, target - arr[si]);

		
		myResult.addAll(recResultExclusion);
		for(int i = 0; i < recResultInclusion.size(); i++){
			ArrayList<Integer> innerRecResultInclusion = recResultInclusion.get(i);
			innerRecResultInclusion.add(arr[si]);
			myResult.add(innerRecResultInclusion);
		}
		
		return myResult;
	}

	public static void printTargetSum(int[] arr, int si, int target, ArrayList<Integer> acc){
		if(si == arr.length - 1){
			if(target == 0){
				System.out.println(acc);
			}
			else if(target == arr[si]){
				acc.add(arr[si]);
				System.out.println(acc);
				acc.remove(acc.size() - 1);
			}
			else {
				// nothing
			}
			
			return;
		}
		
		printTargetSum(arr, si + 1, target, acc);
		
		acc.add(arr[si]);
		printTargetSum(arr, si + 1, target - arr[si], acc);
		acc.remove(acc.size() - 1);
	}
}
