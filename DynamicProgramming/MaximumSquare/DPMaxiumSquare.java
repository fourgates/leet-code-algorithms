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
    private char[][] matrix;
    private int n, m;
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        this.matrix = matrix;
        this.n = this.matrix.length;
        this.m = this.matrix[0].length;
        return dp(0,0);
    }
    private int dp(int x, int y){
        if(x == n || y == n){
            return 0;
        }
        if(matrix[x][y] >= 1){
            matrix[x][y] = (char)dp(x,y);
        }
        return matrix[x][y];
    }
}
