package Arrays.MergeIntervals;

import java.util.Arrays;
import java.util.LinkedList;

class ArraysMergeArraysMain{
    public static void main(String[] args) {
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        int[][] expected ={{1,6},{8,10},{15,18}};
        ArraysMergeIntervals a = new ArraysMergeIntervals();
        int[][] actual = a.merge(input);
        for(int i=0;i<expected.length;i++){
            for(int j=0;j<expected[0].length;j++){
                if(actual[i][j] != expected[i][j]){
                    throw new AssertionError();
                }
            }
        }
        System.out.println("done");
    }
}

/**
 * 
 * [56. Merge Intervals - Medium](https://leetcode.com/problems/merge-intervals/)
 */
public class ArraysMergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            }
            else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}
