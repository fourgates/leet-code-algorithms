package DynamicProgramming.ClimbingStairs;

public class DPClimbingStairs {
    
}
// DP
//
// 1. DS to store or compute result
// 2. Recursive relation to transition between states
// 3. Base Case - which case does not require DP?

// base case, if you are on the last step you can only take one step!
//            if you are on the second to last step you can either take one step of two\
//
// pesduo code 1 - top down - need space for recursion
//
//  base case - if the current step is 1 return 1
//  base case - if the current step is 2 return 2
//      return climbing the n-1 step and the n-2 step
//
//
// pseduo code 2 - bottom down - O(n) space
//
//  if n is equal to 1 return 1
//  create an array of integers from 0 to n
//  base case - update the first index to 1 and the second index to 2 (base conditions)
//  iterate over each number (starting at 2 bc we filled in the first two)
//      relation step - the current step is equal to the previous step plus the one before that!
//  return the last step!
// (n^2) without memorization!
// O(n) with memo, you calculate each value once!
class Solution {
    private int[] memo;
    public int climbStairs(int n) {
        //return bottomDown(n);
        this.memo = new int[n + 1];
        return topDown(n);
    }
    private int topDown(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(memo[n] > 0){
            return memo[n];
        }
        memo[n] = topDown(n-1) + topDown(n-2);
        return memo[n];
    }
    private int bottomDown(int n){
        if(n == 1){
            return 1;
        }
        int[] out = new int[n];
        out[0] = 1;
        out[1] = 2;
        for(int i=2;i<n;i++){
            out[i] = out[i-1] + out[i-2];
        }
        return out[n-1];        
    }
}