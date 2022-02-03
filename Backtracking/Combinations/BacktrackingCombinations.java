package Backtracking.Combinations;

import java.util.ArrayList;
import java.util.List;

// Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

// pseduo code 1
//  create a list of lists of ints to return
//  create a counter and init it to 0
//  create a list to start and populate it with 0
//  iterate over the counter
//      increment value at counter(starts at 0)
//      if the list index value is greater than n
//          decrement counter
//      else if the counter is equal to k minus 1
//          add it to the lsit
//      else 
//          increment counter
//          set the current list value index to the previous list value
//
//
// pesduo code 2
//  create a list of lists to return
//  call a recursive method backtrack(listOfLists, curInt, n, k, list)
//  start with current int value equal to 1
//      if k is equal to zero (base case)
//          add the current list to the ret (list of lists)
//          return
//      if the currrent int value is less than or equal to n -k
//      this means there are not enough numbers left
//          backtrack by incrementing the curr value by 1
//      add the current value to the curr list
//      backtrack by incremeneting the curr value and k minus 1

// pesdo code 3
//
//  create a list of lists to return the results
//  call a recursive backtrack function
//      if you have met the end criteria
//          add current list and return
//      backtrack the incremented current value
//      add the current value to the current list
//      backtrack the incremented current value
//
// pesdo code 4
//
//  create a list of lists to return
//  backtrack (recursively) using the resturn list, n, k, and a new list
//      if k equals 0 (base case) add the current list to the result
//      if n (current number in range) is greater than k(the amount of numbers you can use)
//          backtrack with decrementing n
//      add n to the current list
//      backtrack by decrementing the current value and k
//
// pesduo code 5
//
//  create list of lists to return
//  create backtrack recursive function that takes a number (curr) and a list
//      base case - if the size of the list is equal to the max size of a list (k) add the current list
//      iterate over the numbers between curr and n
//          add the iterated value to the current combo
//          backtrack by incrementing the current number
//          remove the last element of the list
//          
//
// pesdo code 6
//
//  if the current list size is equal to the max list size, add the current list to the output
//  iterate over the numbers between the current int value and the max int value
//      add the current number value to the current list
//      backtrack using the incremented value of the current number value
///     backtrack by remove the last element in the current list
public class BacktrackingCombinations {
    
}
class Solution {
    private List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, new ArrayList<>(), n, k);
        return out;
    }
    private void backtrack(int currValue, List<Integer> currList, int n, int k){
        if(currList.size() == k){
            out.add(new ArrayList<>(currList));
        }
        for(int i=currValue;i<n + 1;i++){
            currList.add(i);
            backtrack(i+1, currList, n,k);
            currList.remove(currList.size() - 1);
        }
    }
}