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