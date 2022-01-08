package Graphs.DFS.AllPathsLeadToDest;

import java.util.ArrayList;
import java.util.List;

public class DFSAllPathsLeadToDest {
    
}
// GIVEN 
//
// a set of edges
// source, dest
// number of verts
//
// TODO
//
// return true if all paths from source lead to dest
//
// NOTES
//
// - very similiar to just finding a path from src to dest problem
// - DFS can be used here to find all pather
// - need to be able to detect a cycle 
//      - this will occur if a vertex is in a path more than once
// - need to be able to detect a deadend
//      - this will occur if you get to a node that has no other
//        non-visited edges and it is not the dest
// 
// ALGO
//
// 1. construct a graph out of the edges
// 2. start at the source node
// 3. mark the node as visited
// 4. if current path contains the subsequent node we are looking for, return false
// 5. if the current node has no unvisited paths and its not dest, return false
// 6. if the current node had no unvisted paths and it is the dest, return true 
// 7. iterate through node edges / node
// 8. unwind. explore all other paths
//
class Solution {
    private List<List<Integer>> graph = new ArrayList<>();
    // alternatively, instead of using a list for the path
    // we can use WHITE, BLACK, GREY state array to keep track
    // of the nodes being processed. that may use less memory
    private List<Integer> path = new ArrayList<>();
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        // init
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        // construct graph
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        // start at source node
        return dfs(source, destination);
        
    }
    private boolean dfs(Integer vertex, int dest){        
        // check to see the edge is already on the path
        // this is a back edge (cycle found)!
        if(path.contains(vertex)){
            return false;
        }           
        
        // add vertex to path
        path.add(vertex);
        
        // iterate through node edges / node
        boolean visitedAnEdge = false;
        for(Integer edge : graph.get(vertex)){
            // check if this is a self directed edge
            // e.g. 1 -> 1
            if(edge == vertex){
                return false;
            }
          
            // we found a new edge to explore!
            visitedAnEdge = true;
            boolean success = dfs(edge, dest);
            
            // fail fast
            if(!success){
                return false;
            }            
        }
        // dead end!
        if(!visitedAnEdge && dest != vertex){
            //if the current node has no unvisited paths and its not dest, return false
            return false;
        }
        
        // unwind
        path.remove(vertex);
        
        return true;
    }
}