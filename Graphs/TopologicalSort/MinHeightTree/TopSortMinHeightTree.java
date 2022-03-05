package Graphs.TopologicalSort.MinHeightTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopSortMinHeightTree {
    
}
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n < 2){
            List<Integer> out = new ArrayList<>();
            for(int i=0;i<n;i++){
                out.add(i);
            }
            return out;
        }
        // init graph
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new HashSet<>());
        }
        
        // build graph
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // find leaves
        List<Integer> leaves = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(graph.get(i).size() == 1){
                leaves.add(i);
            }
        }
        
        // trim leaves
        int remainingNodes = n;
        while(remainingNodes > 2){
            // remove the leaves
            remainingNodes -= leaves.size();
            
            // find the new leafs
            List<Integer> newLeaves = new ArrayList<>();
            // trimming step
            for(int leaf : leaves){
                Integer neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);
                // new leaf
                if(graph.get(neighbor).size() == 1){
                    newLeaves.add(neighbor);
                }
            }
            // new leaves
            leaves = newLeaves;
        }
        return leaves;
    }
}