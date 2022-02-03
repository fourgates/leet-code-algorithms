package SlidingWindow.MaxAvgSubArray;

public class SlidingWindowMaxAvgSubArray {
    
}

// complexity
// Time - O(N)
// - we iterate over the array once
//
// Space - O(1)
// we only need two doubles to keep track of the max and the curr sum
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // edge cases
        if(k == 1 && nums.length == 1){
            return (double)nums[0];
        }
        if(k > nums.length){
            return -1;
        }
        
        // first window
        double maxSum = 0;
        for(int i=0;i<k;i++){
            maxSum+=nums[i];
        }
        
        double currSum = maxSum;
        for(int i=k;i<nums.length;i++){
            // remove initial value & add new value
            currSum += nums[i] - nums[i-k];
            
            // find the max sum
            maxSum = Math.max(maxSum, currSum);
        }
        
        // optimization - we only need to divide once
        return maxSum / k;
    }
}
