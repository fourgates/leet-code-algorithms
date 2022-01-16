package Graphs.ShortestPath.NetworkDelay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ShortestPathNetworkDelay {
    
}
// Dijkstra's algorithm
//
// start with node k
// explore its connected node
// update their prev node and weight
// pick the next node with the smallest weight (which was connected to k)
// explore all the edges from curr
// continue if the node is already visited
// if its not visited and the weight to reach it is < the current path weight
//  -update prev and rank
// make node as visited
// move on to the next smallest edge
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // init
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        // create graph
        // i usually use List<List<Integer>> graph..., but this graph is not zero based :(
        for (int[] time : times) {
            if(graph.get(time[0]) == null){
                graph.put(time[0], new ArrayList<>());
            }
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        // min heap to process cheapest edges first
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1] - b[1]);
        
        // start with edge k!
        // k = starting edge
        // 0 = the initial weight
        queue.offer(new int[]{k, 0});
        
        // a map to keep track of distance for each node
        Map<Integer, Integer> dist = new HashMap<>();
        
        // lets get started!
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            int node = curr[0];
            int weight = curr[1];
            
            // since we are using a min heap we only need to iterate over each node once
            if(dist.containsKey(node)){
                continue;
            }
            dist.put(node, weight);
            
            // queue up the neighbors
            if(graph.containsKey(node)){
                for(int[] edge : graph.get(node)){
                    // add the weight between this edge and the current node we are visiting
                    // the weight to get from the src to this egde is n-1 + n
                    queue.offer(new int[]{edge[0], edge[1] + weight});
                }
            }
            
        }
        // we are missing a node :(
        if(dist.size() != n){
            return -1;
        }
        
        // essentially, the max delay time is going to be the longest path
        int result = Integer.MIN_VALUE;
        
        // iterate over each node and find the max distance (total weight) 
        for(int node : dist.keySet()){
            result = Math.max(result, dist.get(node));
        }
        return result;
    }
}
