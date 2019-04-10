import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueen {
	public String[][] findAllArrangements(int n) {
		int[][] board = new int[n][n];
		List<int[][]> list = new LinkedList<>();
		placeQueen(0, board, list);
		
		String[][] result = new String[list.size()][n];
		int k=0;
		int l=0;
		for(int[][] arr : list) {
			for(int[] row : arr) {
				StringBuilder sb= new StringBuilder();
				for(int i : row) {
					if(i==2)
						sb.append('q');
					else
						sb.append('-');
				}
				result[k][l++]=sb.toString();
			}
			k++;
			l=0;
		}
			
		return result;
    }
	
	
	
	public void placeQueen(int row, int[][]board, List<int[][]> list){
		//List<int[][]> boards = new LinkedList<>();
		if(row>=board.length) {
			int[][] clone = new int[board.length][board[0].length];
			int i=0;
			int j=0;
			for(int[] r : board) {
				for(int k: r) 
					clone[i][j++]=k;
				i++;
				j=0;
			}
			list.add(clone);
			return;
		}
		
		for(int j=0;j<board[0].length;j++) {
			if(isSafe(row, j, board)) {
				board[row][j]=2;
				placeQueen(row+1, board, list);
				board[row][j]=0;
			}
		}
		return;
	}
	public boolean isSafe(int r, int c, int[][] board) {
		return !isExistCol(c, board) && !isExistDiag(r, c, board);
	}
	public boolean isExistCol(int column, int[][] board) {
		for(int i=0;i<board.length;i++)
			if(board[i][column]!=0)
				return true;
		return false;
	}
	public boolean isExistDiag(int r, int c, int[][] board) {
		for(int i=r+1, j=c+1; i<board.length && j<board[0].length;i++,j++) {
			if(board[i][j]!=0)
				return true;
		}
		for(int i=r-1, j=c-1; i>=0 && j>=0;i--,j--) {
			if(board[i][j]!=0)
				return true;
		}
		for(int i=r+1, j=c-1; i<board.length && j>=0;i++,j--) {
			if(board[i][j]!=0)
				return true;
		}
		for(int i=r-1, j=c+1; i>=0 && j<board[0].length;i--,j++) {
			if(board[i][j]!=0)
				return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		NQueen nq = new NQueen();
		String[][] result = nq.findAllArrangements(4);
		for(String[] arr : result) {
			for(String s : arr)
				System.out.println(s);
			System.out.println();
			System.out.println();
		}
				
	}
}
