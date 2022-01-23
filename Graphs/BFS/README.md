# Overview of Breadth-First Search Algorithm

BFS is very similiar to DFS. it gives you a way to transverse all the nodes in a graph and all paths between two nodes. 

## Overview
- Use BFS when you want to find the shortest path
- BFS is very similiar to DFS but utilizes a queue and doesnt use recursion very often

## Why use BFS?

BFS is best used to find the shortest path between two nodes where **all edges have equal and positive weights**

DFS must transverse all nodes to be able to do this. BFS is much more efficient. 

## Why is it more efficient?
When BFS finds the dest node, it's guaranteed to be the shortest path

## Whats the diff between the DFS and BFS algo?
- DFS uses a stack or a FILO algo
- BFS uses a queue or a FIFO algo
- DFS goes deep first and searches along one path at a time
- BFS transverses all nodes at a given level before moving on

## Transversing All Verticies
1. Add starting node to queue
2. Remove node from queue
2. Mark it as visited
3. Add all neighbors to queue
4. Dequeue
5. if not visited, mark visited
6. add neighbors to queue
7. continue until you find dest

This is very similiar to DFS but bc we use a queue, we will process the nodes we find find instead of the nodes we find last

## Find Shortest Distance
a. tranvsverse all paths (DFS) and return the shortest on
b. find the shortest one (BFS)
1. start with start node, add it to the queue (path of 1)
2. dequeue path
3. add path (two verts e.g. A->C)
4. mark node as visited
5. dequeue path
6. add neighbors
7. mark visited