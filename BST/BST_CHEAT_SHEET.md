# Search
1. return the node if the target value is **equal** to the value of the node
2. continue search in the **left** subtree if the target value is **less than** the value of the node
3. continue search in the **right** subtree if the target value is **greater than** the value of the node

## Search Complexity
- Time - `O(h)` where `h` = the height of the tree
- Space - `O(1)` when iterative.

## Insertion
1. search left or right subtree according to the relation of the target and the current root
2. repeat step 1 until reaching an external node...
3. add the new node as its left or right child depending on the relation of the value of the node and the value of the target node