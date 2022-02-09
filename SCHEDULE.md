## 12

# Docs
https://seanprashad.com/leetcode-patterns/
https://www.youtube.com/watch?v=QT0dS9C9uwo&list=PLwRnjprOJ9HyxpQCzZRH1M0NTiPQqvwqF&index=8

## Week 1
Problem Types:
BFS, Recursion, Backtracking, Dynamic Programming

Distinct Problems: 9

Mon: done
https://leetcode.com/problems/01-matrix/
https://leetcode.com/problems/rotting-oranges/

Tue: done
https://leetcode.com/problems/merge-two-sorted-lists/
https://leetcode.com/problems/reverse-linked-list/

Wed: done
https://leetcode.com/problems/combinations/
https://leetcode.com/problems/permutations/
https://leetcode.com/problems/letter-case-permutation/
https://leetcode.com/problems/01-matrix/
https://leetcode.com/problems/rotting-oranges/

Thur: done
https://leetcode.com/problems/climbing-stairs/
https://leetcode.com/problems/house-robber/
https://leetcode.com/problems/merge-two-sorted-lists/
https://leetcode.com/problems/reverse-linked-list/

Fri: BREAK!

Sat: done
https://leetcode.com/problems/combinations/
https://leetcode.com/problems/permutations/
https://leetcode.com/problems/letter-case-permutation/

Sun: done
https://leetcode.com/problems/course-schedule/
https://leetcode.com/problems/course-schedule-ii/
https://leetcode.com/problems/01-matrix/
https://leetcode.com/problems/climbing-stairs/

## Week 2

TODO - need to switch up some topics
maybe some of the shortest path stuff, greedy, disjoint sets, union find, binary search

Mon: done
https://leetcode.com/problems/merge-two-sorted-lists/
https://leetcode.com/problems/reverse-linked-list/
https://leetcode.com/problems/rotting-oranges/
https://leetcode.com/problems/house-robber/
https://leetcode.com/problems/meeting-rooms-ii/

Tue:
https://leetcode.com/problems/combinations/
https://leetcode.com/problems/permutations/
https://leetcode.com/problems/letter-case-permutation/
https://leetcode.com/problems/course-schedule-ii/

Wed:
https://leetcode.com/problems/climbing-stairs/
https://leetcode.com/problems/house-robber/
https://leetcode.com/problems/triangle/
https://leetcode.com/problems/meeting-rooms-ii/

Thur:

Fri:
https://leetcode.com/problems/course-schedule-ii/

Sat:
https://leetcode.com/problems/meeting-rooms-ii/





https://www.tryexponent.com/courses?ref=pramp&utm_source=pramp&utm_medium=referral&utm_campaign=pramp_nav_courses
NEWYEAR22 - 10% of

TODO
https://leetcode.com/problems/pascals-triangle/
https://leetcode.com/problems/minimum-falling-path-sum/
https://leetcode.com/problems/alien-dictionary/


feedback for overlap problems
min(A[1], B[1]) - max(A[0], B[0])
-this gives you a upper and lower limit of both
you can use two pointers
- keep incrementing the pointer which has the earliest start 

// LCU cache
// binary tree, all elem between [x,y]

Time Planner
Implement a function meetingPlanner that given the availability, slotsA and slotsB, of two people and a meeting duration dur, returns the earliest time slot that works for both of them and is of duration dur. If there is no common time slot that satisfies the duration requirement, return an empty array.

Time is given in a Unix format called Epoch, which is a nonnegative integer holding the number of seconds that have elapsed since 00:00:00 UTC, Thursday, 1 January 1970.

Each person’s availability is represented by an array of pairs. Each pair is an epoch array of size two. The first epoch in a pair represents the start time of a slot. The second epoch is the end time of that slot. The input variable dur is a positive integer that represents the duration of a meeting in seconds. The output is also a pair represented by an epoch array of size two.

In your implementation assume that the time slots in a person’s availability are disjointed, i.e, time slots in a person’s availability don’t overlap. Further assume that the slots are sorted by slots’ start time.

Implement an efficient solution and analyze its time and space complexities.