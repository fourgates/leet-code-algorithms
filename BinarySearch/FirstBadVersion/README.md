You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

https://leetcode.com/problems/first-bad-version/

## Example 1:
> Input: n = 5, bad = 4
>
> Output: 4
>
> Explanation:
>
> call isBadVersion(3) -> false
>
> call isBadVersion(5) -> true
>
> call isBadVersion(4) -> true
>
> Then 4 is the first bad version.

## Example 2:
> Input: n = 1, bad = 1
>
>Output: 1

## Constraints:
> 1 <= bad <= n <= 231 - 1
>
> (hint this is the largest number you can store in Java!)

## Graphical

### First Loop
init
1  2  3  4  5

F  F  F  T  T

L = 1
R = 5

pivot = L + (R - L) / 2

pivot = 1 + (5 - 1) / 2

pivot = 1 + 4 / 2

pivot = 1 + 2

pivot = 3

1  2  3  4  5

      ^

      F

// not the first bad version

L = pivot + 1

L = 3 + 1

L = 4

### Second Loop
pivot = L + (R - L) / 2

pivot = 4 + (5 - 4) / 2

pivot = 4 + (1) / 2

pivot = 4

1  2  3  4  5

         ^

         T


// we found a bad number!

// BASE CASE! BASE CASE!

// check if the number before the bad number is good

check = 4 - 1

check = 3

1  2  3  4  5

      ^

      T

// return pivot!