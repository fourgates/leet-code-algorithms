[Leet Code - Dynamic Programming](https://leetcode.com/explore/learn/card/dynamic-programming/631/strategy-for-solving-dp-problems/4096/)

# What is Dynamic Programming (DP)?

- A way to systematically and efficiently explore all possiblee solutions to a problem

## What type of problems can you solve?

1. Problems that can be broken down into overlapping subproblems
2. Problems that have an "optimal substructure". (travelling salesman)

The fibonacci sequence is a classic example.

if you want to solve for the nth number you can it down into 

F(n-1) and F(n-2) = F(n)

This is an "optimal substructure" problem. However, the subproblems can be overlapping. 

e.g. 
F(4) is needed for both F(6) and F(5)

## Greedy?

This sounds like greed alogorithms, right? Similar in the fact that they have optimal substructure, BUT not overlapping subproblems. This is why DP and divide and conquer can commonly be mistaken for one another.

## Characteristics
DP is powerful bc 
- it breaks a complex problem into manageable subproblems. 
- avoids unnessary recalculations of ovelaps
- allows you to use the results of those sub problems to solve the iniital complex problem
- improves time complexity compared to brute force


Using brute force for Fib seq is exponential. Using DP its linear

# Top-down and Bottom-up

There are two ways to implement DP

- Bottom up, tabulation
- Top down, memoization

## Bottom Up

Use iteration and start at the base case. For the Fib seq F(0) = 0 and F(1) = 1.
Using bottom up you can use these case cases to calculate F(2) and then use those results to calculate F(3) up to F(n)

// Pseudocode example for bottom-up

F = array of length (n + 1)
F[0] = 0
F[1] = 1
for i from 2 to n:
    F[i] = F[i - 1] + F[i - 2]

Why is this called bottom up? bc you work from the very first state and work your way up to the case you are looking for    

## Top Down

Use recursion and made efficient with memoization. If you want to find F(n) you need to find F(n-1) and F(n-2). Continue until you reach the base case F(0) = F(1) = 1. 

### Whats the problem with top down?

If you use recursion you will hit a ton of unneccessary repeated computations.
To calc F(5) you would have to calc F(2) 3 times!

### How do you resolve the redundencies?

You can use external storgage, often a hashmap, to store pre calc values. You can refer to the cached value instead of calculating it again. 

// Pseudocode example for top-down

memo = hashmap
Function F(integer i):
    if i is 0 or 1: 
        return i
    if i doesn't exist in memo:
        memo[i] = F(i - 1) + F(i - 2)
    return memo[i]

Why is the called top down? bc you start at the case you are looking for and work backwards

## Which is better?

You can use either method

- bottom-up is typically faster bc there is no recursion overhead
- top-down is usually easier to write. with recursion, the ordering of subproblems doesnt matter. With bottom-up (tabluation) you need to go through a logical ordering of sub problems. 

** The important thing to note is that bottom up uses iteration and top down uses recursion **

# When to use DP?

- First Characteristic - Problem asks for the optimum value (max or min) or the number of ways to do something. 

- What is the minimum cost of doing...
- What is the maximum profit from...
- How many ways are there to do...
- What is the longest possible...
- Is it possible to reach a certain point...

** Not this is not a comprehensive list, just examples **

- Second Characteristic - future decisions depnd on earlier ones. Deciding to do something at one step may affect another. You need to factor in the results from a previous decision. 

[House Robber](https://leetcode.com/problems/house-robber/) is a great example!

```
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
```

1. The problem asked for an optimal solution (max)
2. There is a dependency on which houses you can rob

You can find the optimal solution, but that may be incorrect bc if you rob two adjacent houses the police will be notified!

[Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) is another great example.

You need to find the longest sequence of nums by removing numbers and not reordering the rest. 

1. This problem asks for an optimal solution (max)
2. Removing a number affects EVERYTHING

nums = [1, 2, 6, 3, 5]

You have to make a decision to remove 6. otherwise you cannot use 3 and 5. This means you essentially need to brute force and creating every permutation possible to find out which fits. This is not efficient! But that is where DP comes into play!

The 2nd characteristic may still be a little fuzzy. Here is a tip!

```
When trying to decide if the 2nd characteristic fits, try to remove it. Then try to think of a counterexample that proves greedy does not work! If you can find an example where a decision affects a future decision then DP is applicable!
```

** NOTE -  these ar only guidlines. There are examples that outside these characteristics where DP would be approrirate. DP is a very broad topic! **

# A Framework for DP Problems
We can use the [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) problem to demonstrate how to use a framework to solve any DP problem.

here are some terms you need to understand:

## State
The state is the set of variables that describe a scenario. These variables are called state variables. 

In the climbing stairs example, the only variable we care about is the current step we are on. if `i` is the current step, and `i` = 6, then we are on the 6th step. Every value of `i` describes a unique state.

## The Framework
We need to combine 3 things

### 1. You need a function or data structure to compute or contain the answer to the probelem for every given state. 

e.g. 

to solve the climbing stairs you can write a `dp(i)` function which returns the number of ways to climb the stairs for `i` number of stairs. This function is the original problem, but generalized for each state. 

```
Most top down impl's use a recursive function and a hash map. Bottom down use nested loops and arrays. We will be using top down in this example, start at the case you are looking for and work backwards. 

```

### 2. A recurrence relation to transition between states
A recurrence relation is an equation that relates diff states with each other. 



We `i` = 30 and we want to see how many ways to climb 30 stairs, we can break the problem down. Since you either take 1 or 2 steps, the 2nd to last stair will either be 29 or 28. Therefoe, the number of ways to climb 30 stairs is dp(28) + dp(29). Or more generialized

```
dp(i) = dp(n-1) + dp(n-2)
```

** A key thing to remember here is that the decisions about some states gives us details on other states! **

```
Finding the recurrence relation is the most difficult part of solving DP problems!
```

### 3. Base cases, so that the recurrence relation does on indefinetly 
```
dp(i) = dp(n-1) + dp(n-2)
```

This will go on until negative infinity! we need to figure out when to stop. This is often the EASIEST part of DP. 

A good way to approach this is, which cases do not require DP?

- 1 step only has one way
- 2 steps has two ways (2,1-1)

Therefore are base case(s) are:
```
dp(1) = 1
dp(2) = 2
```

## Example Impl's
```
class Solution {
    // A function that represents the answer to the problem for a given state
    private int dp(int i) {
        if (i <= 2) return i; // Base cases
        return dp(i - 1) + dp(i - 2); // Recurrence relation
    }
    
    public int climbStairs(int n) {
        return dp(n);
    }
}
```

The above is a solution using recursion. The complexity it O(2^n) bc everytime you computer a value we make two recursive calls. This is not good!

If we wanted to find how many ways there are to climb to the 250th step, the number of operations we would have to do is approximately equal to the number of atoms in the universe...

This is not DP bc we are not using memorization, only basic recursion.

Using a HashMap we can make this MUCH more efficent!

```class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<>();
    
    private int dp(int i) {
        if (i <= 2) return i;
        // Instead of just returning dp(i - 1) + dp(i - 2), calculate it once and then
        // store it inside a hashmap to refer to in the future
        if (!memo.containsKey(i)) {
            memo.put(i, dp(i - 1) + dp(i - 2));
        }
        
        return memo.get(i);
    }
    
    public int climbStairs(int n) {
        return dp(n);
    }
}
```

The complexity drops down to linear time! `O(n)`.

Here is a bottom down approach following the same framework

```
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        
        // An array that represents the answer to the problem for a given state
        int[] dp = new int[n + 1]; 
        dp[1] = 1; // Base cases
        dp[2] = 2; // Base cases
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Recurrence relation
        }
        
        return dp[n];
    }
}
```