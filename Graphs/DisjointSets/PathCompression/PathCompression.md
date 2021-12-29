# Path Optimization

- Minimzing paths means reducing the path by having nodes all point to the root node instead of being `n` levels deep

- We can optimize the find method from a Quick Union. We do not need to do this for QuickFind bc it is already `O(1)`

- with path compression you can set the root node for all the nodes along a path whenever you want to find the parent. this way you can easily find the root the next time around. 

- you can use recursion that that when the calls unwind you can set the root node

- you will only ever have to call `find()` twice in this instance. once to lookup the parent, and then another time to check if the parent is itself (this is a root node)

- This compression speeds up all the operations to `O(logn)`!