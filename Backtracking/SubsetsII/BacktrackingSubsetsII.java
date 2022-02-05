package Backtracking.SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BacktrackingSubsetsII {
    
}
class Solution {
    private List<List<Integer>> out = new ArrayList<>();
    private int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        backtrack(new ArrayList<>(), 0);
        return out;
    }    
    private void backtrack(List<Integer> currList, int currIndex){
        out.add(new ArrayList<>(currList));    
        for(int i=currIndex;i<nums.length;i++){
            if(i > currIndex && nums[i] == nums[i-1]){
                continue; // skip dupes
            }
            currList.add(nums[i]);
            backtrack(currList, i + 1);
            currList.remove(currList.size() - 1);   
        }
    }
}