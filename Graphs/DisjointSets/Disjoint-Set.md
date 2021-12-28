# Disjoint Set

- A data structure or algorithm that allows you to determine if two vertices are connected. A commo use case for this type of graph is a computer network. This can be used to address connectivity between two or more components. You can also use a social network. e.g. you can determine if two people share a common ancestor

- disjoint sets work by creating groups of vertices. these groups can be merged if they have overlapping values. At the end of the exercise you are left with `n` number of sets. You can utilize these sets to determine if a given verticie is connected to another

# Implementing Disjoint sets

- You will ne an underlying data structure. you can commonly use an array. You can map an array index to a vertex. and the value of the array index will be the parent vertex. A characteristic of a root node is that the value and the index equal the same value

1. initialize array so each value = its index. This essentially will set the parent of each node to itself

2. Next you need start to union together each pair in the disjoint set. You will have to pick a root, if one does not yet exists, for each set. You set the root by setting the index and the value to be the same. Then you change the child index value to point to the parent index. 

3. to use the array to determine if the nodes are connected, simply check to see if they have the same root. traverse up the tree via the array until you get to an value that has the same value as its index number.

# Important Characteristics

- Find Function - this finds the root of a graph
- Union Function - this joins two node into the same graph. This may require one of the root nodes to be replaced 