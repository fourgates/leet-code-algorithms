# Overview of Depth-First Search Algorithm

Disjoin sets check for connectivity (parity) between two vertices. But how do you final all its vertices, and how can you find all paths between two vertices?

DF is ideal in solving these types of problems. It can explore all pathers from the start vertex to all others. 

When do use DFS?
- to transverse all vertices in a graph
- transverse all pathers between any two verticies

# What is DFS?

depth - search a path until you cannot go any further

## What do you need?

you ofen need a aux data structure (stack) to return to prev stat or use recusion
- first in, last in

## Transverse all Vertices

1. Pick a starting node
2. pop the node and mark is as visited
3. add the connected nodes to the stack
4. pop from stack
5. check if node has been visited
    - if not visited mark it as visited
    - add its connected nodes
6. continue until stack is empty

## Complexity

Time - O(V + E)
Space - O(V)

## Transverse all Edges

1. pick a starting node
2. pop the first node
3. make it as visited
4. look at all the paths (two nodes) from the current node and put them on the stack
5. pop the next element, mark it as visited
6. check to see if this is the final path, if so store it
7. pop the next values
8. unmark nodes as visited when going in reverse 
9. continue until stack is empty

## Complexity

Time - O((V-1)!)
Space - O(V^3)