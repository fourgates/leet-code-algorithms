package DynamicProgramming.MinCostClimbingStairs;
// GIVEN
//
// - you are given a number of steps
// - there is a cost to taking each step
// - if you pay the cost you can climb one or two more steps
// - you can start from 0 or 1
//
// TASK
// 
// - return the MIN cost to reach the top!
//
// NOTES
//
// this SMELLS like DP! Pretty darn close to the fib sequence
//
// FRAMEWORK
//
// 0. State - Which step are you on?
//
// 1. DS or Function
//      we can use a memo map to keep track of the min cost to get to step i
//
// 2. Recurrence Function
//
//      the cost of step i is the cost of the current step
//      + the cost of the steps before it
//      you either took one step or two steps
//      
//      dp(i) = cost[i] + Math.min(dp(i-1), dp(i-2));
//
// 3. Base Case
//
//      dp(0) = cost[0]
//      dp(1) = cost[1]

import java.util.HashMap;

class DPMinCostClimbingStairsMain{
    public static void main(String[] args){
        DPMinCostClimbingStairs dp = new DPMinCostClimbingStairs();
        int expected = 15;
        int[] cost = {10,15,20};
        int actual =  dp.minCostClimbingStairs(cost);

        if(expected != actual){
            throw new AssertionError("No bueno!");
        }
        System.out.println("done!");
    }
}

public class DPMinCostClimbingStairs {
    private HashMap<Integer, Integer> memo = new HashMap<>();
    private int[] cost;
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        if(cost.length == 1){
            return cost[0];
        }
        // base cases
        memo.put(0, cost[0]);
        memo.put(1, cost[1]);
        
        // top down approach
        dp(cost.length - 1);
        
        // the key here is that the last step you can be on is either going to be
        // the last step or the 2nd to last
        return Math.min(memo.get(cost.length - 1),memo.get(cost.length - 2));
    }
    private Integer dp(int i){
        if(i==0){
            return cost[0];
        }
        else if(i==1){
            return cost[1];
        }
        if(!memo.containsKey(i)){
            memo.put(i, cost[i] + Math.min(dp(i-1), dp(i-2)));
        }
        return memo.get(i);
    }
}
