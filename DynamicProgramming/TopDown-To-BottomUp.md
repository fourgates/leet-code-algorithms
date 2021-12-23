#  Top-down to Bottom-up

Top down is normally easier to think about how to solve. But you may be asked to convert top down to bottom up to increase efficiency. Here is a outline to do so.

1. Start with top down
2. Initialize `dp` array to the size of the state variables. initialize the variables to something other than what you want (min / max infinity)
3. Set the base cases
4. Write a for loop starting from the base cases (since they were already handled). Multiple states may need nested loops
5. use the innter most loop to put the reccurence logic. replace alls to `dp()` with `dp[]`
6. instead of returning `dp()` return `dp[]`