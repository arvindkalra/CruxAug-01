package Lecture7;

public class StarPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		pp(6,0,0);
	}

	public static void pp(int N, int row, int col) {
		if (row==N){
			return;
		}
		
		if (col>row){
			System.out.println();
			pp(N,row+1,0);
			return;
		}
		
		System.out.print("*\t");
		pp(N,row,col+1);
	}
}
