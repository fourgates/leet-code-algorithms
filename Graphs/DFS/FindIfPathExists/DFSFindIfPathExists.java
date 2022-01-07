package Graphs.DFS.FindIfPathExists;

import java.util.ArrayList;
import java.util.List;

public class DFSFindIfPathExists {
    
}
// GIVEN
//
// bi directtional graph
// n verts
// each vert labeled 0 to n-1
// edges[i] = [u_i,v_i] = bi directional edge betwen vertex u_i and v_i
// each vertex is connected by at most one edge
// no vertex has an edge to itself
//
// TASK
//
// determine if there is a valid path from start to finish
//
// RETURN
//
// true if there is a path
// false otherwise
class Solution {
    private boolean[] visited;
    private List<List<Integer>> graph = new ArrayList<>();
    
    public boolean validPath(int n, int[][] edges, int start, int end) {
        // init
        this.visited = new boolean[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        // construct graph (add edges)
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        
        return dfs(start, end);
    }
    
    private boolean dfs(int src, int dest){
        if(src == dest){
            return true;
        }
        visited[src] = true;
        
        // iterate over all edges from the src vertice
        for(int i=0;i<graph.get(src).size();i++){
            int newDest = graph.get(src).get(i);
            if(visited[newDest]){
                continue;
            }
            
            // try to find a new path between the edge and the given end
            boolean foundPath = dfs(newDest, dest);
            if(foundPath){
                return true;
            }
        }
        return false;
    }
}