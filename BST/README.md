# Definition of the Binary Search Tree

## BST Properties
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

## Search in BST

BST supports 3 opertions
- search
- insert
- delete

Each node in a BST has the following property:
1. return the node if the target value is **equal** to the value of the node
2. continue search in the **left** subtree if the target value is **less than** the value of the node
3. continue search in the **right** subtree if the target value is **greater than** the value of the node

## Search Complexity
- Time - `O(h)` where `h` = the height of the tree
- Space - `O(1)` when iterative.

## Insertion

1. search left or right subtree according to the relation of the target and the current root
2. repeat step 1 until reaching an external node...
3. add the new node as its left or right child depending on the relation of the alue of the node and the value of the target node

One of the huge BST advantages is a search for arbitrary element in `O(log(n))` time.

The problem solution is very simple - one could always insert new node as a child of the leaf!

The recursion implementation is very straightforward :

If root is null - return TreeNode(val).

If val > root.val - go to insert into the right subtree.

If val < root.val - go to insert into the left subtree.

Return root.