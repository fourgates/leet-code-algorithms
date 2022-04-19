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

# BST

## Search Complexity - worst case (unbalanced tree)
- Time - `O(h)` where `h` = the height of the tree
- Space - `O(1)` when iterative.

## Search Complexity - best case (balanced tree)
- Time - `log(n)`


## DP
1. DS to store or compute result
2. Recursive relation to transition between states
3. Base Case - which case does not require DP?        

- when to use? when each decision is dependent on a previous one, and/or it is a min/max problem

## Greedy
- similiar to DP, but each decision is independent of each other
- often a min/max problem

### Algo
- either sort data structure or use a min heap
- take the min or max that you want
- continue until you get to the expected metric

# Graphs

## How to detect cycles in a graph?
- Union-Find cycle detection works for undirected graphs
- Topological Sort cycle detection works for directed graph
- Bellman Ford Algorithm

## DAG
- Directed Acyclic Graph
- a directed graph without cycles connecting the other edges
- its impossible to transverse the entire graph starting at one edge
- user caes, scheudling, circuit design, networks

## DAG DFS
```
- optionally, convert 2D array to a list of lists for ease of use
- pick a starting node, this is sometimes put in the question
- keep track of visited nodes, if visited a node, return
- else mark the current node visited
- perform business logic
- do a dfs on each edge of the current node
- since a dag has more than one path, you may need to "unwind"
    - and mark the current node as not visisted if you
    - are looking for some type of aggregate
```

# Graphs

## BFS
- search is typically `O(N)`. you need to tranverse each node once. using a visited node
    helps confirm this. although if you need to backtrack that is a diff story
- if you need to keep track of a path you can use a list of arrays. each array would be a coordinate. this is useful if you are transversing a matrix, which is pretty much the same problem

### When to use BFS?
- when you need to transverse a tree or graph level by level

### When yo use DFS?
- asked to transverse in order, pre order, or post order
- if you are required to search for something that will be closer to a leaf node

### algo
- queue a starting node
- for each node in the queue queue all the neightbors
- continue until all nodes have been visited

## Topological
- algo that takes a directed graph and returns an array of nodes where each node appears all the nodes it points to
- not valid if there is a cycle, but you can use this to detect a cycle
- you cant do top sort if there are no zero degree nodes

### algo
```
start with zero degress nodes
add node to result
decrement the degree of each node conencted to it
queue up any new zero degree nodes
    if there are none, there is a cycle
return result
```

# Heap

## K-Way Merge
- can be used when there is a set of sorted arrays
- problem asks you to merge sorted lists or find the smallest element in a sorted list
- merging sorted lists can be a metaphor for how many items do you need. e.g. how many meeting rooms, boats, cars, etc

## Sliding Window
- used for sub array problems
- e.g. find the subarray that has a min or max value

```
start with the first sub array
slide the window by removing the first element and adding the new next element
```

## Min Spanning Tree
- spanning tree - a tree than includes every vertex of graph G and is a subgraph of G (evey edge in the tree belongs to G)
- min spanning tree - a spanning tree where the cost is minimized to span the entire tree. This implies the graph is weighted
- use cases
    - cluster analysis
    - handwriting recognition
    - image sementation
- how to solve?
    - kruskals algorithm
        - use in a sparse graph, more edges than vertices
        - easier to implement
        - use dijoint sets + Priority Queue
    - prims algorithm
        - use on dense graphs, more edges than vertices
        - harder to implement
        - also uses a priority queue

### Cut Property

### What is a cut?
- A cut is a partion of a graph into two **disjoint subsets** (remember union-find?)
- A **crossing edge** is an edge that connects two nodes in the two disjoint sets

### What is the "Cut Property"?
- This provides support for both Kruskals and Prims algorithms
- For any cut `C` of the graph, if the weight of an edge E is the cut-set of C is strictly smaller than the weights of all other edges in the cut-set of `C`, then this edge belongs to all MST's of the graph
- Esstentially, if you break a graph down into "cuts" or disjoint sets and only keep the smallest edges, these edges should be apart of the MST.         

## Kruskal's Algorithm
1. sort all edges by weight
2. create the MST by adding the smallest edges first. if the edge creates a cycle you cannot add it
3. repeat until you get to n-1 edges

## Time Complexity
- `O(E log(E))`
-- `O(E log(E))` to sort the edges
-- `O(theta(V))` to to process the sorted edges, the worst case is `O(E theta(V))` bc you have to iterate over each edge + vert
-- `O(E log(E) + E theta(V))` = `O(E log(E))`

## Space Complexity
- `O(V)`
- Keeping track of the root of each V requires `V` space

## Prim's Algorithm
- Starts with two sets, `Visited` and `Non-Visited`
1. Pick a vertex at random
2. Remove vertex from `Non-Visited`
3. Add vertex to `Visited`
4. Find the minimum edge from the `Visited` disjoint set which connects to the `Non-Visited` disjoint set and add it to the MST. This is AKA the **crossing edge**. 
5. Remove a vertex from `Non-Visited`
6. Add that vertex to `Visited`
7. Continue until `Non-Visited` is empty or `Visited` = n

## Time Complexity
- `O(E log(V))` for a Binary heap and `O(E + V log(V))` for a Fibonacci heap