package BFS.Matrix01;

import java.util.LinkedList;
import java.util.Queue;

//
// TODO
//
// - calc the distance between the nearest 0 from each cell
// - the dist between two adjacent cells is 1
// 
// thoughts...
//
// seems like a bfs type of q
//
// why bfs?
//
// which would be O(n * m)
// and O(n * m) space
// we can essentially reuse the a neighbor to determine the closest 0
// the size of the matrix can be very large
//  may not want to use recursion or at least optimize at the end
// pseduo
//
//  foreach row
//      foreach col
//          if row,col = 0 queue it up
//          mark it as visited
//
//  while queue is not empty
//      get the current node
//      iterate over its neighbors
//      do a bounds and visited check
//      queue neighbor
//      increment the neighbors distance by using the current nodes distance
//          (as we get furthor away the distance will grow!)

// https://leetcode.com/problems/01-matrix/solution/
// https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/tutorial/
class BFSMatrix01Main{
    public static void main(String[] args){
        BFSMatrix01 b = new BFSMatrix01();
        int[][] input = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] expected = {{0,0,0},{0,1,0},{1,2,1}};

        int[][] actual = b.updateMatrix(input);
        for(int i=0;i<expected.length;i++){
            for(int j=0;j<expected[0].length;j++){
                if(expected[i][j] != actual[i][j]){
                    throw new AssertionError("This didnt work!");
                }
            }
        }
        System.out.println("Done!");
    }
    
}
public class BFSMatrix01 {
    // BFS
    public int[][] updateMatrix(int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        boolean[][] visited = new boolean[rows][cols];
        
        // queue up all the 0's so we can start from there...
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] dir ={{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for(int[] d : dir){
                int x = cell[0] + d[0];
                int y = cell[1] + d[1];
                if(x < 0 || y < 0 || x >= rows || y >= cols
                  || visited[x][y] || mat[x][y] == 0){
                    continue;
                }
                queue.offer(new int[]{x,y});
                visited[x][y] = true;
                mat[x][y] += mat[cell[0]][cell[1]];
            }
        }
        return mat;
    }
}
