## Binary Search
- The idea here is that you cut the array in half each time you search.
- This is only useful when you are dealing with an already sorted array

```
int left = 0, right = nums.length;
int pivot = left + (right - left) / 2;
``` 

## Two Pointer
- Very similiar to Binary Search bc we have "two" pointers

## In Order
```
dfs(node.left)
print(node)
dfs(right)
```

## Pre order
```
print(node)
dfs(node.left)
dfs(right)
```

## Post order
```
dfs(node.left)
dfs(right)
print(node)
```

# BFS Pseduo code

```
 foreach row
     foreach col
         queue up the neccessary rows

 you may need to keep track of visited nodes
 while the queue is not empty
     get the current cell and visit all its neighbors
     do a bounds check 
     mark the cell visited
     queue up the neighbor
```

## Complexity
- `O(N * M)`

## Space
- `O(N * M)`


## How to detect cycles in a graph?
- Union-Find cycle detection works for undirected graphs
- Topological Sort cycle detection works for directed graph
- Bellman Ford Algorithm
