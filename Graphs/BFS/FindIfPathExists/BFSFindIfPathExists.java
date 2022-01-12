package Graphs.BFS.FindIfPathExists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSFindIfPathExists {
    
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
    private List<List<Integer>> graph = new ArrayList<>();
    private boolean[] visited;
    
    // for BFS
    private Queue<Integer> queue = new LinkedList<>();
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(n <= 1){
            return true;
        }
        // init
        this.visited = new boolean[n];
        for(int i=0;i<n;i++){
            this.graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            this.graph.get(src).add(dest);
            this.graph.get(dest).add(src);
        }        
        //return dfs(start, end);
        
        queue.add(start);
        return bfs(end);
        
    }
    private boolean bfs(int end){
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node == end){
                return true;
            }
            visited[node] = true;
            for(Integer next : graph.get(node)){
                if(visited[next]){
                    continue;
                }
                queue.add(next);
            }
        }
        return false;
    }
    private boolean dfs(int start, int end){
        if(start == end){
            return true;
        }
        visited[start] = true;
        for(Integer node : graph.get(start)){
            if(visited[node]){
                continue;
            }
            boolean found = dfs(node, end);
            if(found){
                return true;
            }
        }
        
        return false;
    }
}
class Solution2 {
    private Queue<List<Integer>> queue = new LinkedList<>();
    private boolean[] visited;
    private List<List<Integer>> answer = new ArrayList<>();
    private int n;
    private int[][] graph;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // edge cases
        if(graph.length <= 0){
            return answer;
        }
        
        // init
        this.n = graph.length;
        this.graph = graph;
        this.visited = new boolean[n];
        
        List<Integer> firstPath = new ArrayList<>();
        firstPath.add(0);
        queue.add(firstPath);
        bfs();
        return answer;    
    }
    private void bfs(){
        while(!queue.isEmpty()){
            List<Integer> path = queue.poll();
            int node = path.get(path.size() - 1);
            if(node == n-1){
                // add path to answer
                answer.add(path);
            }
            for(int edge : graph[node]){
                if(visited[edge]){
                    continue;
                }
                List<Integer> newPath = new ArrayList<>();
                for(Integer currentEdge : path){
                    newPath.add(currentEdge);
                }
                newPath.add(edge);
                queue.add(newPath);
            }
        }
    }
}