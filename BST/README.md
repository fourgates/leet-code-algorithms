# Definition of the Binary Search Tree

- A binary tree with the following properties:

1. the value in each node must be **greater than** any values in the left sub tree
2. the value in each node much be **less than** any values in the right sub tree

- You can use any of the order transversals, preorder, inorder, postorder, or level order
- Doing an inorder traversal with produce asc order and is the most frequently used

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