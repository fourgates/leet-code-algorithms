package DynamicProgramming.UniquePath;

import java.util.Arrays;

public class DPUniquePath {
    
}

class BottomUp{
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];
    
        for(int[] arr : d) {
          Arrays.fill(arr, 1);
        }
        for(int col = 1; col < m; ++col) {
          for(int row = 1; row < n; ++row) {
            d[col][row] = d[col - 1][row] + d[col][row - 1];
          }
        }
        return d[m - 1][n - 1];
      }    
}
class TopDown {
    private int m;
    private int n;
    private int[][] memo;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        this.memo = new int[m][n];
        return dp(0,0);
    }
    
    private int dp(int x, int y){
        // out of bounds
        if(x >= m || x < 0 || y >= n || y < 0){
            return 0;
        }
        // found the end of the path!
        if(x == m - 1 && y == n -1){
            return 1;
        }
        // memo step
        if(memo[x][y] > 0){
            return memo[x][y];
        }
        return memo[x][y] = dp(x + 1, y) + dp(x, y +1);
    }
}