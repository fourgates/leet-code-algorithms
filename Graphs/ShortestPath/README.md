# Overview of Single Source Shortest Path

- We need to discover some algorithms that will help us navigate a weighted graph. DFS and BFS can only solve shortest path problems in non-weighted graphs

## Edge Relaxation

- This is a technique of finding a shorter edge between two nodes. If you have a path of weight 3 between node A and B and you find a path of weight 2, you can `relax` this path and optimize it. The term relax can be thought of as a rope. Since the rope was length 3 and now you are using length 2 there is some slack in the rope, it is more relaxed!

## Dijkstra's Algorithm

- This is an algo that can solve `the single source shortest path` problem in a weighted graph with **non-negative weights**.
- To use this algo you typically have a data structure which keeps track of the previous node in the path (`prev`)  and a data structure that keeps track of the optimal weight (`weights` or `dist`) for a given node

1. Start with a src node. mark the node visited, if needed
2. Explore all of its neighbors (connected nodes)
3. Update `prev` and `weights` to mark the neighbors previous node the current node and the weight the current node's edges weight + the current weight of the neighbor
4. Add the neightbors and their weight to a queue to be explored
5. Pick the next node with the smallest weight (can leverage a `PriortiyQueue`)
6. Explore all of its neighbors (connected nodes - step 2)
7. Continue if the node is already visited
8. If the current path if < than the stored path update it. This may not be neccessary if you are using a heap bc we are already using the cheapest edge
9. Mark node as visited
10. Move onto the next smallest node

- Once you are dont you should have all of the shortest distances stored for each edge
- You can simply transverse the table to find the shortest path from `src` to `target`
- If you are missing a distance that means it is impossible to transverse all the nodes

## Bellman Ford Algorithm
- Dijkstra's algo is restricted to shortest paths with non-negative weights. Bellman Ford is a way to accomplish the shortest path with negative weights.

- Directed Acyclic Graph (DAG) - can sometimes be referred to as a "regular graph"

### Theorem 1
- In a "graph with no negative-weight cycles" with `N` vertices,  the shortest path between any two vertices has **AT MOST N-1** edges
- This theorem is specific for graphs **without cycles**
- Positive Cycle - A graph with a cycle in wich the weight for the path is > 0. The shortest path in a graph with this cycle will hace `N-1` edges. If you end up getting lower neights with more than `N-1` edges, you have identified a cycle!
- Negative Cycle - A graph with a cycle in wich the weight for the path is < 0

### Theorem 2
- In a `graph with negative weight cycles` there is no shortest path!
- There is no shortest path because each time you go through the cycle the weight of the path gets smaller!

### Using Dynamic Programming
- You can use **up to N-1** edges to find the shortest path from `A`->`B`
- `N-1` means you can use 1,2,3,... etc up to `N-1` edges to find the shortest path
- Make sure there is not a negative cycle, otherwise there is no shortest path!

1. Create a `N` * `E` matrix where `N` is the total number of edges and `E` is the maxium number of edges you are allowed to use. `E` will either be `N-1` or some small value defined in the problem. This matrix stores ths shortest distance from your source node to each verticie using up to `N-1` verticies.
2. Init each cell to positive infinity (or `Integer.MAX_VALUE`)
3. Start with 0 edges. You will only be able to get to the src node with 0 edges, thus its distance is 0. 
4. Next, look for the shortest distances using `AT MOST` 1 edge. (AT MOST 1 means you could use 0 edges or 1 edge)
5. The distance to the source using 1 edge is still 0. 
6. Look at the next vert and identify which edges are directed at it. 
7. Lookup the distance from the neighbors from N-1 edges. If the current distance + the N-1 distance we < than the neighbor we can update out table to store current_distance + n-1_distance
- which N-K edge do you choose to use? You may need to count how many edges you are allowed to use at this cell. Else you can choose to use the cheapest distance. 

`DP[k][u] min(DP([k][u], DP[k-1][v] + W(u,v)`
> k = at most number of edges
> u = the target vertex. (we are assuming the question defined a src node)
> W() = weight algorithm
> DP[k][u] = shortest path to u with at most k edges
> DP[k-1][v] + W(u,v) = (assume we have edge u->v) shortest path from the previous verticie + the weight of the current distance from u->v

> Base Cae = N = N-1