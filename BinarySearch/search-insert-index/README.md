# 35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

## Example 1:
```
Input: nums = [1,3,5,6], target = 5
Output: 2
```

## Example 2:
```
Input: nums = [1,3,5,6], target = 2
Output: 1
```

## Example 3:
```
Input: nums = [1,3,5,6], target = 7
Output: 4
```

// notes
hmm
so the return index if found is easy

the tricky part is if the target doesnt exist how do you

know where it should be inserted

n would belong where

This is the key!

n - 1 < n < n + 1