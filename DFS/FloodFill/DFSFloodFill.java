package DFS.FloodFill;

/**
 * [733. Flood Fill - Easy ](https://leetcode.com/problems/flood-fill/
 * 
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.

 */
class BFSFloodFillMain{
    public static void main(String[] args){
        DFSFloodFill f = new DFSFloodFill();
        int[][] input = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] expected = {{2,2,2},{2,2,0},{2,0,1}};
        int[][] actual = f.floodFill(input, 1, 1, 2);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[0].length; j++) {
                if(expected[i][j] != actual[i][j]){
                    throw new AssertionError("Fill did not work!");
                }
            }
        }
        System.out.println("It worked!");
    }
}
public class DFSFloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color != newColor){
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }
    private void dfs(int[][] image, int r, int c, int color, int newColor){
        // only change colors that need to be changed
        if(image[r][c] == color){
            // 
            image[r][c] = newColor;
            // move to the left
            if(r >= 1){
                dfs(image,r-1, c, color, newColor);
            }
            // move down
            if(c >= 1){
                dfs(image, r, c-1, color, newColor);
            }
            // move right
            if(r + 1 < image.length){
                dfs(image, r+1, c, color, newColor);
            }
            // move up
            if(c + 1 < image[0].length){
                dfs(image, r, c+1, color, newColor);
            }
        }
    }
}
