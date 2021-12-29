# Quick Find - Disjoint Set

- if you always keep track of the nodes parent node this can require you need to do a lot of iteration

- instead you can always store the root node. this way you could always tell if two nodes are connected

- The tradeoff here is that if you want to union two sets you have have to update n-1 nodes

- but you can `find()` in constant time!