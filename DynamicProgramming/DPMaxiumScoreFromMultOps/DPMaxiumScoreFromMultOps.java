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
// since we have multiple states a nth-D array may be worthwhile exploring...
//
// 2. Recurrence relation
//
//
// - i = a multiplier
// - j = left most index
// - k = right more index
// - dp(i, j, k) = multiplier[i] * Math.max(nums[j], nums[k]) + 
//                  Math.max(dp(i+1, j + 1, k), dp(i+1,j, k -1))
//
// 3. Base Cases
//
//  - j = k then just return i * j
class Solution {
    private int[][][] memo;
    private int[] nums;
    private int[] multipliers;
    public int maximumScore(int[] nums, int[] multipliers) {
        if(nums.length == 1 && multipliers.length == 1){
            return nums[0] * multipliers[0];
        }
        this.nums = nums;
        this.multipliers = multipliers;
        int m = nums.length;
        this.memo = new int[m][m][m];
        return dp(0, 0, nums.length - 1);
    }
    private int dp(int i, int j, int k){
        if(i >= this.multipliers.length){
            return 0;
        }
        if(memo[i][j][k] == 0){
            int left = this.nums[j];
            int right = this.nums[k];
            memo[i][j][k] = Math.max(
                // move left pointer right
                (
                    this.multipliers[i] * left + dp(i+1, j+1, k)
                ),
                // move right pointer left
                (
                    this.multipliers[i] * right + dp(i+1,j, k-1)
                )
            );
        }
        return memo[i][j][k];
    }
}