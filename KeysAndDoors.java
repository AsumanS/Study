import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class KeysAndDoors {

    /*
     * Complete the function below.
     */
    static int[][] find_shortest_path(String[] grid) {
        if(grid==null || grid.length==0)
            return new int[][]{};
        int[]start = findStart(grid);
        Set<Character> keys = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length()];
        List<int[]> path = new LinkedList<>();
        List<int[]> shortestPath = new LinkedList<>();
        findPaths(grid, start, path, keys, visited,shortestPath);
        int[][] result = new int[shortestPath.size()][2];
        int i=0;	
        for(int[] cell : shortestPath){
            result[i][0]=cell[0];
            result[i][1]=cell[1];
            i++;
        }
        return result;
    }
    static int[] findStart(String[] grid){
        for(int i=0;i<grid.length;i++){
            String s = grid[i];
            for(int j=0;j<s.length();j++)
                if(s.charAt(j)=='@')
                    return new int[]{i,j};
        }
        return new int[]{};    
    }
    static void findPaths(String[] grid, int[] start, List<int[]> path, Set<Character> keys, boolean[][] visited, List<int[]> shortestPath){
        int i=start[0];
        int j=start[1];
        if(i>=grid.length || i<0 || j>=grid[0].length() || j<0 || visited[i][j]==true) {
            return;
        }
        
        char c = grid[i].charAt(j);
        
        if(c=='@' && path.size()>0) {
            return;
        }
        if(c=='#') {
            return;
        }
        if((c>='A' && c<='Z') && !keys.contains(Character.toLowerCase(c))) {
            return;
        }
        if(shortestPath.size()>0 && shortestPath.size()<path.size())
        	return;
        if(c>='a' && c<='z') {
            keys.add(c);
            visited=new boolean[grid.length][grid[0].length()];
        }
            
        if(c=='+') {
        	if(shortestPath.size()==0) {
        		shortestPath.addAll(path);
        		shortestPath.add(start);
        	}
        	else if(shortestPath.size()>path.size()) {
        		shortestPath.clear();
        		shortestPath.addAll(path);
        		shortestPath.add(start);
        	}
            return;
        }
        path.add(start);
        visited[i][j]=true;
        
        findPaths(grid, new int[]{i-1,j}, path, keys, visited, shortestPath);   
        findPaths(grid, new int[]{i+1,j}, path, keys, visited, shortestPath);  
        findPaths(grid, new int[]{i,j+1}, path, keys, visited, shortestPath);  
        findPaths(grid, new int[]{i,j-1}, path, keys, visited, shortestPath);  
        
        keys.remove(c);
        path.remove(path.size()-1);
        visited[i][j]=false;
        
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        int[][] res;
        int grid_size = 0;
        grid_size = Integer.parseInt(in.nextLine().trim());

        String[] grid = new String[grid_size];
        for(int i = 0; i < grid_size; i++) {
            String grid_item;
            try {
                grid_item = in.nextLine();
            } catch (Exception e) {
                grid_item = null;
            }
            grid[i] = grid_item;
        }

        res = find_shortest_path(grid);
        for(int[] cell : res) {
        	System.out.println(cell[0]+","+cell[1]);
        }
    }
}

