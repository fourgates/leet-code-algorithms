package Arrays.PrisonCells;

import java.util.HashMap;

public class ArratsPrisonCells {
    
}
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        HashMap<String, Integer> cellPermutationsByIteration = new HashMap<>();
        boolean fastForward = false;
        
        while(n > 0){
            if(!fastForward){
                // compute a string of the current set of cells
                String key = computeKey(cells);
                if(cellPermutationsByIteration.containsKey(key)){
                    // we found a cycle!
                    fastForward = true;
                    // the length of the cycle is cellPermutationsByIteration[state_key] - n
                    // now that we found a cycle we only need to compute the remainder of iterations!
                    n = n % (cellPermutationsByIteration.get(key) - n);
                }
                else{
                    cellPermutationsByIteration.put(key, n);
                }
            }
            if(n > 0){
                n--;
                cells = computeNextDay(cells);    
            }
            
        }
        return cells;
    }
    private String computeKey(int[] cells){
        StringBuilder sb = new StringBuilder();
        for(int cell : cells){
            sb.append(cell);
        }
        return sb.toString();
    }
    private int[] computeNextDay(int[] cells){
        int[] newCells = new int[cells.length];
        newCells[0] = 0;
        for(int i=1;i<newCells.length - 1;i++){
            if(cells[i-1] == cells[i+1]){
                newCells[i] = 1;
            }
            else{
                newCells[i] = 0;
            }
        }
        newCells[cells.length - 1] = 0;
        return newCells;
    }
}