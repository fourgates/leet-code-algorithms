package Backtracking.Permuations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BacktrackingPermutations {
    
}
// pesduo code 1
//  return a list to return
//  create a recursive backtrack function
//      if base case add the current combo to output
//      iterate over the selectable values to add to the combo
//          add the current iterable to the current list
//          backtrack by recursively calling the next backtrack using the next element
//          backtrack by removing the last element
//
//
// pseduo code 2
//  if the curr index is equal the the max size of the list
//      add the current combo
//  iterate over the values between curr and the n (size of the lsit)
//      swap the curr index with current iterated value
//      call backtrack with incrementing the iterated value
//      backtrack step - swap the curr index and the current iterated value again
//
// pesduo code 3 - i like this one the best
//
//  use a temp list!
//  base case - if the temp list size is the size of the array of nums, add it to out
//  else
//      iterate over the nums array
//          if the temp list contains the num skip to the next number
//          add the num to the temp list
//          backtrack call using the temp list
//          backtrack step - remove the last element
class Solution {
    List<List<Integer>> out = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
          nums_lst.add(num);        
        
        backtrack(nums_lst, 0);
        return out;
    }
    private void backtrack(ArrayList<Integer> nums, int curr){
        if(curr == nums.size()){
            out.add(new LinkedList<>(nums));
        }
        for(int i=curr;i<nums.size();i++){
            Collections.swap(nums, curr, i);
            backtrack(nums, curr+1);
            Collections.swap(nums, curr, i);
        }
    }
}