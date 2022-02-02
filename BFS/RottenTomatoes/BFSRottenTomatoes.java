package BFS.RottenTomatoes;

import java.util.LinkedList;
import java.util.Queue;

// pseduo
//
//  get counts for row and col
//  create a counter for fresh oranges
//  create a queue for BFS
//  foreach row
//      foreach col
//          if rotten queue up
//          if fresh increment counter
//  create counter for mins, default to -1
//  while the queue is not empty
//      increment min counter
//      do a level order DFS
//      pop the rotten orange
//      visit all the neighbors
//      look for fresh organges
//      when you find one decrement fresh counter
//      mark it as now rotten
//      queue up the neighbor for the next round
//  if all the oranges have not rotted, return -1
//  otherwise return the mins passed

class BFSRottenTomatoesMains{
    public static void main(String[] args) {
        BFSRottenTomatoes b = new BFSRottenTomatoes();
        int[][] input = {{2,1,1},{1,1,0},{0,1,1}};
        int expected = 4;
        int actual = b.orangesRotting(input);
        if(actual != expected){
            throw new AssertionError("This is wrong!");
        }
        System.out.println("Done!");
    }
}
public class BFSRottenTomatoes {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // keep track of cells we visit
        boolean[][] visited = new boolean[rows][cols];
        int freshOrange = 0;
        
        // each level (min) will have a list of oranges that need
        // to rot their neighbors
        
        // Step 1). build the initial set of rotten oranges
        Queue<Queue<int[]>> levelQueue = new LinkedList<>();
        Queue<int[]> firstQueue = new LinkedList<>();
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                // start with the rotten apples
                if(grid[i][j] == 2){
                    firstQueue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
                else if(grid[i][j]==1){
                    freshOrange++;
                }
            }
        }
        // edge case
        // if there are no fresh oranges, it takes 0 mins
        if(freshOrange == 0){
            return 0;
        }        
        // edge case
        // if there are no rotten organges then return -1
        if(firstQueue.isEmpty()){
            return -1;
        }
        
        // Step 2). start the rotting process via BFS
        levelQueue.offer(firstQueue);
        int level = 0;
        
        // these are the directions of the neighbors
        int[][]dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!levelQueue.isEmpty()){
            Queue<int[]> currentQueue = levelQueue.poll();
            Queue<int[]> nextQueue = new LinkedList<>();
            while(!currentQueue.isEmpty()){
                int[] cell = currentQueue.poll();
                for(int[] d : dir){
                    int x = cell[0]+d[0];
                    int y = cell[1]+d[1];
                    if(x<0 || y<0 || x>=rows || y>=cols ||
                      grid[x][y] == 0 ||
                      visited[x][y]){
                        continue;
                    }
                    visited[x][y] = true;
                    // this will rot...
                    if(grid[x][y] == 1){
                        freshOrange--;
                        grid[x][y] = 2;
                        nextQueue.offer(new int[]{x,y});
                    }
                }
            }
            if(!nextQueue.isEmpty()){
                levelQueue.offer(nextQueue);
                level++;
            }
        }
        // edge case, the rotten oranges are contained!
        // this can happen if there is an orange in the corner
        if(freshOrange > 0){
            return -1;
        }
        return level;
    }
}
