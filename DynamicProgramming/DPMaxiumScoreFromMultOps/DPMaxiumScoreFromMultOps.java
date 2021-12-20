package DynamicProgramming.DPMaxiumScoreFromMultOps;

public class DPMaxiumScoreFromMultOps {
    
}
// GIVEN two integer arrays (nums and multipliers) of size n and m (n >= m)
//
// TASK
//
// return the max score after performing m operations
//
// NOTES
//
// - begin with a score of 0
// - perform EXAXTLY m operations.On the ith operation you will:
//  - chose one int x from either the start or end of the array nums
//  - add multipliers[i] * x to the score
//  - remove x from the array of nums
//
// DP
//
// - bc we want to find a MAX
// - each state change changes the possible decisions you can make going forward
//
// 1. DS or Function
//
// - we can use an array or hashmap...
// the state is made up of a number for nums and a number from multipliers dp(i,j)
//
// 2. Recurrence relation
//
// - i = a multiplier
// - j = subset of nums
// - dp(i,j[]) = Math.max(dp(i, j[0]), dp(i,j[j.length - 1]))
//
// 3. Base Cases
//
// - j.length == 1 - only one number!
// - j.length == 0 - no nums
class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        return -1;
    }
}