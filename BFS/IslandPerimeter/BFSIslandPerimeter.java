package BFS.IslandPerimeter;

/**
 * [463. Island Perimeter - Easy](https://leetcode.com/problems/island-perimeter/)
 */

class BFSIslandPerimeterMain{
    public static void main(String[] args){
        BFSIslandPerimeter b = new BFSIslandPerimeter();
        int[][] input = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int expected = 16;
        int actual = b.islandPerimeter(input);
        if(actual != expected){
            throw new AssertionError("Perimeer doesnt match!");
        }
        System.out.println("Done!");
    }
}
public class BFSIslandPerimeter {
    private final int dir[][] = {{0,1}, {0,-1}, {1,0}, {0,-1}};
    public int islandPerimeter(int[][] grid) {
        // bfs by where the islands start
        int perimeter = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int current = grid[i][j];

                // only continue is current is land (part of the island)
                if(current == 0){
                    continue;
                }
                
                // start with an assumtion that each cell has for sides (perimeter = 4)
                perimeter = perimeter + 4;
                for(int[] d : dir){
                    int x = i + d[0];
                    int y = j + d[1];
                    if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length){
                        continue;
                    }
                    // decrement the perimeter if its land!
                    if(grid[x][y] == 1){
                        perimeter--;
                    }
                }                
            }
        }
        return perimeter;
    }
}
