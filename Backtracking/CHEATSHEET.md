## Backtracking

When to use?
- enumerations (permutations, combinations, subsets, variations)
- decision problems - (is a number prime?)
- optimization - finding the best solution of all feasible solutions

## Difference between backtracking and DP
- DP is used for breaking complex problems into smaller steps
- useful when there are overlapping sub problems 
- Backtracking is used to find all (or some) solutions to a computation that incrementally builds candidates to the solution and abandonss each partial candidate ("backtracks") as soon as it determiens that it cannot possibly be used for a valid solution

## Pseduo Code
```
    create a data structure to return
    if solution is found
        process a solution
    iterate over values
        apply value n
        find solution for n+1
        remove n  (backtrack step)
```