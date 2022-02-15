package DynamicProgramming.HouseRobber;

import java.util.Arrays;
import java.util.HashMap;

class DPHouseRobberMain{

    public static void main(String[] args){
        DPHouseRobber r = new DPHouseRobber();
        int[] houses = {1,2,3,1};
        int expected = 4;
        int actual = r.rob(houses);
        if(actual != expected){
            throw new AssertionError("PooPoo");
        }
        System.out.println("done");
    }
}

// GIVEN
//
// - you are a robber
// - each house has a certain amount of $ stashed
// - adjacent houses have security systems  connected. they will go off
//      and contact the popo if two adjacent houes are broken into on
//      the same night!
//
// INPUT
//
// array of numbers rep the $ in each house
//
// TASK
//
// return the MAX amount of $ you can rob in a night without alerting police
//
// NOTES
// 
// this might be a DP problem bc it is asking for the max
// also there is a constraint on the decision of which house you can rob
// if we went the greedy route you would not be able to choose two adjacent
// or concurrent houses
//
// 0. state - which house are are robbing (array index)
//
// 1. The DS or Function to Compute
// memo -   we can write dp(i) which returns the max number of $ you
//          could rob up until i. this way we can reuse all the sub problems
//          of i-1 to calculate i+1
//
// 2. Recurrence Function
//          when you get to a house you make a binary decision, 
//          do you rob this house or not?
//          if you robbed the previous house you cannot rob this house
//          if you did not rob the previous house you can rob this house
//
//      // either you rob the previous house - dp(i-1)
//      // or you rob the house before that and this one - dp(i-2) + nums[i]
//      // take the max value of these two options
//      dp(i) = max(dp(i-1), dp(i-2) + nums[i])
//
// 3. Base Case
//
//          d(0) = nums[0]
//          d(1) == max(nums[0], nums[1])

class DPHouseRobber {
    private HashMap<Integer, Integer> memo = new HashMap<>();
    private int[] nums;
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        this.nums = nums;
        
        // add base cases to map
        this.memo.put(0, this.nums[0]);
        this.memo.put(1, Math.max(this.nums[0], this.nums[1]));
        
        // we can do a top-down approach were we start at the value we are interested in
        dp(nums.length - 1);
        return this.memo.get(nums.length - 1);
        
    }
    
    private Integer dp(int i){
        if(i == 0){
            return this.nums[0];
        }
        else if(i == 1){
            return Math.max(this.nums[0], this.nums[1]);
        }
        if(!memo.containsKey(i)){
            memo.put(i, Math.max(dp(i-1), dp(i-2) + nums[i]));
        }
        return memo.get(i);
    }
}
// solution uses arrays instead of a map
class Solution {
    private int[] memo;
    private int[] nums;
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        this.nums = nums;
        this.memo = new int[nums.length];
        Arrays.fill(memo, Integer.MIN_VALUE);
        // add base cases to map
        memo[0] = nums[0];
        memo[1] = Math.max(this.nums[0], this.nums[1]);
        
        // we can do a top-down approach were we start at the value we are interested in
        dp(nums.length - 1);
        return this.memo[nums.length - 1];
        
    }
    
    private Integer dp(int curr){
        if(curr == 0){
            return this.nums[0];
        }
        else if(curr == 1){
            return Math.max(this.nums[0], this.nums[1]);
        }
        if(memo[curr] == Integer.MIN_VALUE){
            memo[curr] = Math.max(dp(curr-1), dp(curr-2) + nums[curr]);
        }
        return memo[curr];
    }
}
