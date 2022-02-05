package Backtracking.Subsets;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingSubsets {
    
}
class Solution {
    private List<List<Integer>> out = new ArrayList<>();
    private int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backtrack(new ArrayList<>(), 0);
        return out;
    }
    private void backtrack(List<Integer> currList, int currIndex){
        out.add(new ArrayList<>(currList));
        for(int i=currIndex;i<nums.length;i++){
            currList.add(nums[i]);
            backtrack(currList, i + 1);
            currList.remove(currList.size() - 1);   
        }
    }
}