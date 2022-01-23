package Graphs.ShortestPath.PathWithMinEffort;

import java.util.Arrays;

public class ShortestPathWithMinEffort {
    
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        int[][] dp = new int[rows][cols];
        int[][] dir = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        
        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // base case - 0,0
        dp[0][0] = 0;
        
        // we can optimize BF by returning if we no longer relax the edges
        boolean relaxAtleastOneEdge = true;
        
        // Bellman-Ford required UP TO N-1 iterations
        for(int k=0;k<(rows * cols)-1 && relaxAtleastOneEdge;k++){
            // whenever all ndeos are relaxed this flag will remain false and we have found 
            // the optimal route
            relaxAtleastOneEdge = false;
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    // move in 4 directions
                    for(int[] d : dir){
                        int x = i+d[0];
                        int y = j+d[1];
                        
                        // check for out of bounds
                        if(x < 0 || x >= rows || y < 0 || y >= cols || dp[i][j] >= dp[x][y]){
                            continue;
                        }
                        
                        // calc abs value
                        int absValue = Math.abs(heights[x][y] - heights[i][j]);
                        
                        // relax step
                        if(Math.max(dp[i][j], absValue) < dp[x][y]){
                            // we found a shorter path
                            dp[x][y] = Math.max(dp[i][j], absValue);
                            relaxAtleastOneEdge = true;
                        }
                    }
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}