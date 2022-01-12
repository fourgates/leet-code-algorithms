package Graphs.BFS.AllPaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BFSAllPaths {
    
}

class Solution {
    private List<List<Integer>> g = new ArrayList<>();
    private List<List<Integer>> answers = new ArrayList<>();
    private boolean[] visited;
    private int n;
    private int target;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // init
        this.n = graph.length;
        this.visited = new boolean[n];
        this.target = n - 1;
        // init graph with n nodes
        for(int i=0;i<n;i++){
            this.g.add(new ArrayList<>());
        }
        
        // add edges
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                this.g.get(i).add(graph[i][j]);
            }
        }
        dfs(Arrays.asList(0), 0);
        return this.answers;
    }
    
    private void dfs(List<Integer> path, int curr){
        // been there, done that
        if(visited[curr]){
            return;
        }
        // found a path!
        if(curr == target){
            this.answers.add(path);
            return;
        }
        
        // we need to keep going...
        visited[curr] = true;
        
        // find all the edges for curr
        List<Integer> edges = g.get(curr);
        for(int i=0;i<edges.size();i++){

            // update the path with the new edge
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(edges.get(i));

            // do a search with the new path
            dfs(newPath, edges.get(i));
        }

        // unwind
        visited[curr] = false;        
    }
}