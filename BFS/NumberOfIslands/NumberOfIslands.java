package BFS.NumberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [200. Number of Islands - Medium](https://leetcode.com/problems/number-of-islands/)
 */
public class NumberOfIslands {
        // given
    // m x n 2D binary grid
    // reps map of 1's = land and 0's = water
    // return the number of islands
    //
    // what is an island?
    // - surrounds by water
    // - formed by connecting adjacent lands horizontally or verically
    // 
    // assume
    // - all four edges of the grid are surroundsed by water
    
    // questions?
    // constraints on grid size?
    // binary?
    // square?
    private boolean[][] visited;
    private Queue<int[]> subQueue = new LinkedList<>();
    public int numIslands(char[][] grid) {
        // BFS
        visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                // we only need to process land
                if(grid[i][j] == '1'){
                    queue.add(new int[]{i,j});
                }
            }
        }
        if(queue.isEmpty()){
            return 0;
        }
        int islands = 0;
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            if(visited[cell[0]][cell[1]]){
                // if we visited this cell already 
                // we dont want to increments islands
               continue; 
            }
            findIsland(grid, cell);
            // ^^ this only moves up, down, left, right
            // we may need to explore other land we find
            while(!subQueue.isEmpty()){
                cell = subQueue.poll();
                findIsland(grid, cell);
            }
            // we hit water, so increment islands!
            islands++;
        }
        return islands;
    }
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private void findIsland(char[][] grid, int[] cell){
        // keep going until you find water...
        for(int [] d : dir){
            int x = cell[0] + d[0];
            int y = cell[1] + d[1];
            // standard boundaries + continue if we hit water
            if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length ||
              visited[x][y] || grid[x][y] == '0'){
                continue;
            }
            visited[x][y] = true;
            // i think we can remove this...
            if(grid[x][y] == '0'){
                return;
            }
            // explore this one next...
            else{
                subQueue.add(new int[]{x,y});
            }
            findIsland(grid, new int[]{x,y});
        }
    }
}
