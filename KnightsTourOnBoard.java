import java.util.LinkedList;
import java.util.Queue;

public class KnightsTourOnBoard {
    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        int steps = 0;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q1 = new LinkedList<>();
        q1.add(new int[]{start_row,start_col});
        visited[0][0]=true;
        while(!q1.isEmpty()) {
        	Queue<int[]> q2 = new LinkedList<>(); 
        	while(!q1.isEmpty()){
        		int[] cell = q1.poll();
        		if(isEnd(cell, end_row, end_col))
        			return steps;
        		addCell(q2, cell, 1, 2, rows, cols, visited);
        		addCell(q2, cell, 2, 1, rows, cols, visited);
        		addCell(q2, cell, -1, 2, rows, cols, visited);
        		addCell(q2, cell, -2, 1, rows, cols, visited);
        		addCell(q2, cell, 1, -2, rows, cols, visited);
        		addCell(q2, cell, 2, -1, rows, cols, visited);
        		addCell(q2, cell, -1, -2, rows, cols, visited);
        		addCell(q2, cell, -2, -1, rows, cols, visited);
        	}
        	if(!q2.isEmpty()) {
        		steps++;
        		q1.addAll(q2);
        	}
        }
        return -1;
    }
    static void addCell(Queue<int[]> q, int[] cell, int rowDif, int colDif, int rows, int cols, boolean[][] visited){
        int i = cell[0]+rowDif;
        int j = cell[1]+colDif;
        if(i<rows && i>=0 && j<cols && j>=0 && visited[i][j]==false){
            q.add(new int[]{i, j});
            visited[i][j]=true;
        }
    }
    static boolean isEnd(int[] cell, int end_row, int end_col){
        if(cell[0]==end_row && cell[1]==end_col)
            return true;
        return false;
    }
    public static void main(String[] args) {
    	System.out.println(find_minimum_number_of_moves(2,1,1,0,0,0));
    }
}
