package DynamicProgramming.MaximumSquare;

public class DPMaxiumSquare {
    
}

// area of a square
//
// A = B * H
// FRAMEWORK
//
// 1. DS or Funcion
//
//  i = x coord
//  j = y coord
//  dp(i,j) 
//
// 2. Recurrence Relation
//
// a square is made up of smaller squares...
//
//  dp(i,j) = 
//
// 3. Base Case
//
// matrix[i][j] = 1 return 1
class Solution {
    private int maxSql = 0;
    public int maximalSquare(char[][] matrix) {
        return bottomDown(matrix);
        
    }
    private int bottomDown(char[][] matrix){
        int rows = matrix.length, columns = matrix[0].length;
        if(rows == 0){
            return 0;
        }
        int[][] memo = new int[rows+1][columns+1];
        
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                if(matrix[i-1][j-1] == '0'){
                    continue;
                }
                // we want to take the min here bc if any of these values are not 1 then the 
                // area should be 1
                memo[i][j] = Math.min(
                    memo[i-1][j],
                    Math.min(memo[i-1][j-1], memo[i][j-1])
                ) + 1;
                maxSql = Math.max(maxSql, memo[i][j]);                
            }
        }        
        return maxSql * maxSql;
    }
}
