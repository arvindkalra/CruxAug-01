package Lecture8;

import java.util.ArrayList;

public class RecursionCtd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(getSS("abcd"));
//		System.out.println(getSSWithAscii("ab"));
		System.out.println(getMazePathDiagonal(2, 2, 0, 0));
	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rosResult = getSS(ros);
		ArrayList<String> myResult = new ArrayList<>();

		for (int i = 0; i < rosResult.size(); i++) {
			myResult.add(rosResult.get(i));
			myResult.add(cc + rosResult.get(i));
		}

		return myResult;
	}

	public static ArrayList<String> getSSWithAscii(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rosResult = getSSWithAscii(ros);
		ArrayList<String> myResult = new ArrayList<>();

		for (int i = 0; i < rosResult.size(); i++) {
			myResult.add(rosResult.get(i));
			myResult.add(cc + rosResult.get(i));
			myResult.add(((int) cc) + rosResult.get(i));
		}

		return myResult;
	}

	public static int countMazePath(int tr, int tc, int cr, int cc) {
		int count = 0;
		
		if(cr == tr && cc == tc){
			return 1;
		}
		
		if (cc < tc) {
			count += countMazePath(tr, tc, cr, cc + 1);
		}

		if (cr < tr) {
			count += countMazePath(tr, tc, cr + 1, cc);
		}
		
		return count;
	}
	
	public static ArrayList<String> getMazePath(int tr, int tc, int cr, int cc) {
		if (tr == cr && tc == cc) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}
		
		ArrayList<String> rowResult = new ArrayList<>();
		ArrayList<String> colResult = new ArrayList<>();
		ArrayList<String> myResult = new ArrayList<>();
		
		if(cc < tc){
			colResult = getMazePath(tr, tc, cr, cc + 1); 
		}
		
		if(cr < tr){
			rowResult = getMazePath(tr, tc, cr + 1, cc); 
		}
		
		for(int i = 0; i < colResult.size(); i++){
			myResult.add("H" + colResult.get(i));
		}
		
		for(int i = 0; i < rowResult.size(); i++){
			myResult.add("V" + rowResult.get(i));
		}
		
		return myResult;
	}

	public static int countMazePathDiagonal(int tr, int tc, int cr, int cc) {
		int count = 0;
		
		if(cr == tr && cc == tc){
			return 1;
		}
		else if(cr == tr){
			count += countMazePathDiagonal(tr, tc, cr, cc + 1);
		}
		else if(cc == tc){
			count += countMazePathDiagonal(tr, tc, cr + 1, cc);
		}
		else{
			count += countMazePathDiagonal(tr, tc, cr, cc + 1);
			count += countMazePathDiagonal(tr, tc, cr + 1, cc);
			count += countMazePathDiagonal(tr, tc, cr + 1, cc + 1);
		}
		
		return count;
	}
	
	public static ArrayList<String> getMazePathDiagonal(int tr, int tc, int cr, int cc) {
		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> colResult = new ArrayList<>();
		ArrayList<String> rowResult = new ArrayList<>();
		ArrayList<String> diagResult = new ArrayList<>();
		
		if(cr == tr && cc == tc){
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}
		else if(cr == tr){
			colResult = getMazePathDiagonal(tr, tc, cr, cc + 1);
		}
		else if(cc == tc){
			rowResult = getMazePathDiagonal(tr, tc, cr + 1, cc);
		}
		else{
			colResult = getMazePathDiagonal(tr, tc, cr, cc + 1);
			rowResult = getMazePathDiagonal(tr, tc, cr + 1, cc);
			diagResult = getMazePathDiagonal(tr, tc, cr + 1, cc + 1);
		}
		
		for(int i = 0; i < colResult.size(); i++){
			myResult.add("H" + colResult.get(i));
		}
		
		for(int i = 0; i < rowResult.size(); i++){
			myResult.add("V" + rowResult.get(i));
		}
		
		for(int i = 0; i < diagResult.size(); i++){
			myResult.add("D" + diagResult.get(i));
		}
		
		return myResult;
	}

}
