package Lecture7;

import java.util.ArrayList;

public class RecursionCtd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(Power(3, 5));
//		printPascalsTriangle(6, 0, 0, 1);
//		int[] arr = {5, 5, 6, 8, 5, 6, 5, 7, 9};
//		int[] foundAt = allIndices(arr, 0, 5, 0);
//		
//		for(int item: foundAt){
//			System.out.println(item);
//		}
		

//		ArrayList<Integer> al = new ArrayList<>();
//		
//		al.add(1);
//		System.out.println(al);
//		
//		al.add(2);
//		System.out.println(al);
//		
//		al.add(4);
//		System.out.println(al);
//		
//		al.add(1, 100);
//		System.out.println(al);
//		
//		System.out.println(al.size());
//		
//		al.set(3, 7);
//		System.out.println(al);
//		
//		al.remove(1);
//		System.out.println(al);
//		
//		ArrayList<Integer> other = new ArrayList<>();
//		other.add(10);
//		other.add(15);
//		other.add(30);
//		
//		al.addAll(other);
//		System.out.println(al);
		
//		System.out.println(giveSS("abcd"));
//		printPattern(6, 0, 0);
		
		int[] arr = {5, 9, 2, 1, 7};
		selectionSort(arr, 0, 1);
		
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	public static ArrayList<String> giveSS(String str){
		if(str.length() == 0){
			ArrayList<String> baseList = new ArrayList<>();
			
			baseList.add("");
			
			return baseList;
		}
		
		ArrayList<String> smallerResult = giveSS(str.substring(1));
		ArrayList<String> myResult = new ArrayList<>();
		
		// as it is
		myResult.addAll(smallerResult);
		
		for(int i = 0; i < smallerResult.size(); i++){
			myResult.add(str.charAt(0) + smallerResult.get(i));
		}
		
		return myResult;
	}

	public static int Power(int x, int n){
		if(n == 0){
			return 1;
		}
		
		int xpnm1 = Power(x, n - 1);
		int xpn = xpnm1 * x;
		
		return xpn;
	}
	
	public static int Factorial(int n){
		if(n == 0){
			return 1;
		}
		
		int nm1f = Factorial(n - 1);
		int nf = nm1f * n;
		
		return nf;
	}
	
	public static void printPattern(int tr, int col, int row){
		if(row == tr){
			return;
		}
		
		if(col > row){
			System.out.println();
			printPattern(tr, 0, row + 1);
			return;
		}
		
		System.out.print("*\t");
		printPattern(tr, col + 1, row);
	}
	
	public static void printPascalsTriangle(int tr, int col, int row, int value){
		if(row == tr){
			return;
		}
		
		if(col > row){
			System.out.println();
			printPascalsTriangle(tr, 0, row + 1, 1);
			return;
		}
		
		System.out.print(value + "\t");
		value = value * (row - col) / (col + 1);
		printPascalsTriangle(tr, col + 1, row, value);
	}

	public static int[] allIndices(int[] arr, int si, int el){
		if(si == arr.length){
			return new int[0];
		}
		
		int[] fainsa = allIndices(arr, si + 1, el);
		if(arr[si] == el){
			int[] la = new int[fainsa.length + 1];
			for(int i = 0; i < fainsa.length; i++){
				la[i] = fainsa[i];
			}
			
			la[la.length - 1] = si;
			return la;
		}
		else{
			return fainsa;
		}
	}
	
	public static int[] allIndices(int[] arr, int si, int el, int count){
		if(si == arr.length){
			return new int[count];
		}
		
		if(arr[si] == el){
			count = count + 1;
		}
		
		int[] fainsa = allIndices(arr, si + 1, el, count);
		if(arr[si] == el){
			fainsa[count - 1] = si;
		}
		
		return fainsa;
	}

	public static void bubbleSort(int[] arr, int si, int li){
		if(li == 0){
			return;
		}
		
		if(si == li){
			bubbleSort(arr, 0, li - 1);
			return;
		}
		
		if(arr[si] > arr[si + 1]){
			int temp = arr[si];
			arr[si] = arr[si + 1];
			arr[si + 1] = temp;
		}
		
		bubbleSort(arr, si + 1, li);
	}

	public static void selectionSort(int[] arr, int si, int li){
		if(si == arr.length - 1){
			return;
		}
		
		if(li == arr.length){
			selectionSort(arr, si + 1, si + 2);
			return;
		}
		
		if(arr[si] > arr[li]){
			int temp = arr[si];
			arr[si] = arr[li];
			arr[li] = temp;
		}
		
		selectionSort(arr, si, li + 1);
	}
}
