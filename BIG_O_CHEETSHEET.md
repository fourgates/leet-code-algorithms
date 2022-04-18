## BST

## Search Complexity - Worst Case
- This occurs from a very unbalanced tree
- Time - `O(h)` where `h` = the height of the tree
- Space - `O(1)` when iterative.

## Search Complexity - Best Case
- This occurs from a balanced tree
- Time - `O(log(n))`
- Space - `O(1)` when iterative.

## DAG DFS
- Time `O(n * 2^n)`
- 2^n is the power set of an n-1 element set
- The power set is a set which includes all the subsets including the empty set and the original set itself.
- every time you add a new node to the graph, the number of paths double
- `2^n-1 -1` is the number of possible paths, `n` is the number of nodes. this
breaks down to `2^n`