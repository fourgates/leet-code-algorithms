# Overview of Minimum Spanning Tree

## What is a spanning tree?
- A connected subgraph in an **undirected graph** where all vertices are connected with the minimum number of edges. 
- Graphs can have more than one spanning tree. 

## What is a min spanning tree?
- This is used in a **weighted undirected graph**.
- This is a tree with the minimum edge weight to connect all the vertices

# Cut Property

## What is a cut?
- A cut is a partion of a graph into two **disjoint subsets** (remember union-find?)
- A **crossing edge** is an edge that connects two nodes in the two disjoint sets

## What is the "Cut Property"?
- This provides support for both Kruskals and Prims algorithms
- For any cut `C` of the graph, if the weight of an edge E is the cut-set of C is strictly smaller than the weights of all other edges in the cut-set of `C`, then this edge belongs to all MST's of the graph
- Esstentially, if you break a graph down into "cuts" or disjoint sets and only keep the smallest edges, these edges should be apart of the MST. 

## Kruskal's Algorithm
1. sort all edges by weight
2. create the MST by added the smallest edges first. if the edge creates a cycle you cannot add it
3. repeat until you get to n-1 edges

## Time Complexity
- `O(E log(E))`
-- `O(E log(E))` to sort the edges
-- `O(theta(V))` to to process the sorted edges, the worst case is `O(E theta(V))` bc you have to iterate over each edge + vert
-- `O(E log(E) + E theta(V))` = `O(E log(E))`

## Space Complexity
- `O(V)`
- Keeping track of the root of each V requires `V` space

## Prim's Algorith
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

-- Binary heap
--- `O(V + E)` to transverse all the vertices and store in the heap
--- `O(log(V))` to extract min element and key in decreasing order
--- `O(V + E)` * `O(log(V))` = `O(E log(V))`

-- Fibonacci heap
--- `O(log(V))` to get the min element
--- `O(1)` to decrement keys
--- Therefore `O(E + V log(V))`

## Space Complexity
- `O(V)`

## When to use each algorithm?

### KrusKal
- Use Kruskal in sparse graphs, more edges than vertices
- Easier to implement
- Use Disjoint Sets + Priority Queue

### Prim
- Use Prim in dense graphs, more edges than vertices
- Harder to implement
- Use Priority Queue