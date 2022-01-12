package Graphs.BFS.ShortestPathInMatrix;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInMatrix {
    
}
class Solution {
    private Queue<List<int[]>> queue = new ArrayDeque();
    private int[][] grid;
    private boolean[][] visited;
    // TODO - change path from an int to a list to keep track of the current path
    private int n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        // init
        this.n = grid.length;
        this.grid = grid;
        this.visited = new boolean[n][n];
        
        // edge cases
        if(grid == null || grid.length == 0){
            return -1;
        }
        if(grid[0][0] != 0){
            return -1;
        }
        // add first path
        List<int[]> firstPath = new ArrayList<>();
        firstPath.add(new int[]{0,0});
        visited[0][0] = true;
        
        // lets get started!
        queue.add(firstPath);
        return bfs();
    }
    // there are 8 sides in which you could move
    private int[][] dir = {{0,1}, {1,0}, {-1, 0}, {0, -1}, {1,1}, {-1, -1}, {1,-1}, {-1,1}};
    private int bfs(){
        while(!queue.isEmpty()){
            
            List<int[]> currentPath = queue.poll();
            
            // get the last node in the path
            int[] coord = currentPath.get(currentPath.size() - 1);
            int x = coord[0];
            int y = coord[1];
            
            // check if we are done!
            if(x == n-1 && y == n-1){
                return currentPath.size();
            }
            
            // add all the neighbors
            for(int[] d : dir){
                int newX = x + d[0];
                int newY = y + d[1];
                
                // out of bounds check
                if(newX >= 0 && newX <= n-1 &&
                    newY >= 0 && newY <= n-1){
                    
                    // make sure this is a new node and it fits the 0 criteria
                    if(!visited[newX][newY] && grid[newX][newY] == 0){
                        List<int[]> newPath = new ArrayList<>(currentPath);
                        newPath.add(new int[]{newX, newY});
                        queue.add(newPath);
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        // we didnt find a path :(
        return -1;
    }
}