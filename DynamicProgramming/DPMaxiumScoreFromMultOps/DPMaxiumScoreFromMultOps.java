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
    private int[][] memo2;
    private int[] nums;
    private int[] multipliers;
    private int m,n;
    public int maximumScore(int[] nums, int[] multipliers) {
        if(nums.length == 1 && multipliers.length == 1){
            return nums[0] * multipliers[0];
        }
        this.nums = nums;
        this.multipliers = multipliers;
        
        this.memo = new int[multipliers.length][m][m];
        //return topBottom(0, 0, nums.length - 1);
        bottomDown();
        return this.memo2[0][0];
    }
    // 1. start with top down - done
    // 2. initialize dp with size of state variables - done
    // 3. set the base cases... there are no real base cases to set here bc  we do
    //      keep going until we get to the end
    // 4. write a loop starting from the base cases. nest loops for each state
    // 5. in the inner most loop add the recurrence logic and replcace dp() with dp[]
    // 6. return dp[] instead of dp()
    private void bottomDown(){
        this.n = this.nums.length;
        this.m = this.multipliers.length;
        this.memo2 = new int[m + 1][m + 1];
        
        // need to start at the base case
        // in which case the base case starts with i == m
        for(int i=m -1;i >= 0; i--){
            for(int j=i; j >= 0; j--){
                int left = j;
                int right = n - 1 - (i -left);
                memo2[i][j] = Math.max(
                    this.multipliers[i] * nums[left] + memo2[i+1][j+1],
                    this.multipliers[i] * nums[right] + memo2[i+1][j]
                );
            }
        }
    }
    private int topBottom(int i, int j, int k){
        if(i >= this.multipliers.length){
            return 0;
        }
        if(memo[i][j][k] == 0){
            int left = this.nums[j];
            int right = this.nums[k];
            memo[i][j][k] = Math.max(
                // move left pointer right
                (
                    this.multipliers[i] * left + topBottom(i+1, j+1, k)
                ),
                // move right pointer left
                (
                    this.multipliers[i] * right + topBottom(i+1,j, k-1)
                )
            );
        }
        return memo[i][j][k];
    }
}