# Sliding Window Algorithm

- Very important algorithm to know
- Use when there is overlapping sub arrays
- Sliding allows you to optimize most algo's from `O(N*k)` to `O(N)`

## Fixed Size Sliding Window
e.g.

K = 3
nums = 

// compute first set of value
[1,2,3,4,5,6]
 * * *
 = 6

// compute second set of values
 [1,2,3,4,5,6]
    * * *
= 9

- you can see that both 2 and 3 are both used in the first two iterations 
- the only thing that actually changes is the first and last values
- if you compare the value of the first subarray to the second, the only difference is the first (1) and last (4) value!
- in the first sub array you include 1, but not 4 and in the second you include 4 but not 1

- to get to 9 you can say
```
6 + 1 + 4
or
prev - i + j

## How does this work?
1. start with the first subarray
2. slide along the array
3. remove the initial value and add the next value

## Dynamic Size Sliding Window
- Useful when you want to find the largest or smallest subarray that matches some condition

e.g. 
Find the smallest subarray that is <= some number

x = 7
[1,2,3,4,5,6]

- find the smallest subarray that is >=7
- allows you to start small and expand until you match the condition
- once you find the condition you can start to subtract from the left side to get the minimal size
- once you no longer match the condition you can start to exapnd again on the right side