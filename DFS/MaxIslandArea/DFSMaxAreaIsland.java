package DFS.MaxIslandArea;

/**
 * 695. Max Area of Island - Medium
 * 
 * https://leetcode.com/problems/max-area-of-island/
 */
class DFSMaxAreaIslandMain{
    public static void main(String[] args){
        int [][] input = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
            };
        DFSMaxAreaIsland dfs = new DFSMaxAreaIsland();
        int expected = 6;
        int actual = dfs.maxAreaOfIsland(input);
        if(expected != actual){
            throw new AssertionError("Max area is wrong!!");
        }
    }
}
public class DFSMaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        // i think we can do a dfs here
        int maxArea = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                maxArea = Math.max(maxArea, 
                                   findArea(grid, i, j, seen));
            }
        }
        return maxArea;
    }
    private int findArea(int[][] grid, int x, int y, boolean[][] seen){
        if(x < 0 || x >= grid.length){
            return 0;
        }
        if(y < 0 || y >= grid[0].length){
            return 0;
        }
        if(grid[x][y] == 0){
            return 0;
        }           
        if(seen[x][y]){
            return 0;
        }
        seen[x][y] = true;
        // left
        int left = findArea(grid, x+1, y, seen);
        // right
        int right = findArea(grid, x-1,y, seen);        
        // down
        int down = findArea(grid, x, y-1, seen);
        // // up
        int up = findArea(grid, x,y+1, seen);  
        
        return (left + down + right + up + 1);
    }
}
