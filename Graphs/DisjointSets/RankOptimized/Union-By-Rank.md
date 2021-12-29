# Union by Rank

- If you randomally union nodes together you may get a REALLY long tree! this is not efficient!

- To try to keep the depth of the tree as short as possible we can use a weight. We can look at the depth of both tries we are trying to union and pick the shortest one as the new parent. 

- the `find()` will have a worst case of `O(H)` where `h` = the height / depth of the tree

- this is an optimization for the `find()` method. since quick find is already constant time, this optimization is best used for quick union

- we can accomplish this by simplying add a new variable to keep track of the rank of each node

- The time complexity for find, union and connected is now `O(logn)`!