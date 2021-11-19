package Backtracking.WordSearch;

/**
 * 
 * [79. Word Search - Medium](https://leetcode.com/problems/word-search/)
 * 
 * 
 */
class BacktrackingWordSearchMain{
    public static void main(String[] args){
        BacktrackingWordSearch b = new BacktrackingWordSearch();
        char[][] input = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean actual = b.exist(input, word);
        if(!actual){
            throw new AssertionError("This should exist! " + word);
        }
        System.out.println("done");
    }
}
public class BacktrackingWordSearch {
        // given
    //
    // m x n matrix of characters
    // string -word
    // 
    // TODO
    //
    // return true if the word exists
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0){
            return false;
        }
        // BFS since we need to start with the first letter
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                // technically we only need to search if the current char matches the 
                // char of the word, but this shoud do the same thing
               boolean out = bfs(board, word, new int[]{i,j}, 0);
                if(out){
                    return true;
                }     
            }
        }
        return false;
    }
    private int [][] dir = {{0,1}, {1,0}, {0, -1}, {-1,0}};
    private boolean bfs(char[][] board, String word, int[] curr, int charIndex){
        // you found all the characters!
        if(charIndex >= word.length()){
            return true;
        }        
        int row = curr[0];
        int col = curr[1];
        char nextChar = word.charAt(charIndex);

        // normal boundaries + we can stop if the char does match
        if(row <0 || col <0 || row >= board.length || col >= board[0].length ||
          board[row][col] != nextChar){
            return false;
        }        
        // this is a nift way to make sure we dont visit the same cell twice
        board[row][col] = '#';
        boolean ret = false;

        // actual bfs
        for(int[] d : dir){
            int x = curr[0] + d[0];
            int y = curr[1] + d[1];
            // look for the next index
            ret = bfs(board, word, new int[]{x,y}, charIndex + 1);
            if(ret){
                break;
            }
        }
        // backtrack...
        board[row][col] = word.charAt(charIndex);
        return ret;
    }
}
