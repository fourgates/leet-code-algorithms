package Graphs.DisjointSets.WaterDistribution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DisjointSetsWaterDistribution {
    
}

// GIVEN

// n house in a village

// TASK
//
// supply waster to all houses by building wells and laying pipes
//
// there are two choices for each house i
//
// 1 - build well inside it with a cost of wells[i - 1]
// 2 - pipe in water from another well to it
//      the cost to lay pipes between houses are given by the array of pipes
//      pipes[j] = [house_1_j, house_2_j, cost_j] = cost to connect house_1 and house_2
//          connections are bidirectional
//
// RETURN
//
// the minimum total cost to supply water to all houses
//
// a couple of options for a solution here...
//
//  greedy - but you cant use greedy bc if you remove one decision it affects the next...
//  dp - would be the next way to solve this...
//  disjoint sets - good for partition problems. this may be a good approach since we have a partion
//                  of pipes
//
//
//      https://en.wikipedia.org/wiki/Kruskal%27s_algorithm
class Solution {
    private int[] root;
    private int[] rank;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // init
        this.root = new int[n + 1];
        this.rank = new int[n + 1];
        
        for(int i=0;i<n+1;i++){
            this.root[i] = i;
            this.rank[i] = 0; // cost starts at 0
        }
        
        // lets order the edges
        List<int[]> orderedEdges = new ArrayList<>(n + 1 + pipes.length);
        
        // add a virtual edge (with index 0)
        // this allows us to determine if we should 
        // create the well using the cost of the well
        // or create a new edge between two vertices 
        for(int i=0;i<wells.length;++i){
            orderedEdges.add(new int[]{0, i+1, wells[i]});
        }
        
        // add the existing edges
        for(int i=0;i<pipes.length;++i){
            int[] edge = pipes[i];
            orderedEdges.add(edge);
        }
        
        // sort edges so we union the cheapest edgest first
        Collections.sort(orderedEdges, (a,b) -> a[2] - b[2]);
        
        // need to build at least one well
        // if wells[i -1] < pipes[x,y] -> build the well...
        
        // [
        //  [1, 2, 2]
        //  [2, 3, 1]
        // ]
        int totalCost = 0;
        for(int[] edge : orderedEdges){
            int house1 = edge[0];
            int house2 = edge[1];
            int cost = edge[2];

            // determine if we should add the new edge to the final MST
            // using a somewhat greedy algorithm we are going to union the least expensive
            // edges first. if the nodes have not been connected yet we will use this cost
            // (since this is going to be the least expensive way to supply water between these houses!)
            if(union(house1, house2)){
                totalCost += cost;
            }
        }
        return totalCost;
    }
    private int find(int x){
        if(root[x] == x){
            return x;
        }
        return root[x] = find(root[x]);
    }
    
    private boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        
        // houses are already connected
        if(rootX == rootY){
            return false;
        }
        
        if(rootX > rootY){
            root[rootY] = rootX;
        }
        else if (rootY > rootX){
            root[rootX] = rootY;
        }
        else{
            root[rootY] = rootX;
            rank[rootY] += 1;
        }

        // houses are now connected
        return true;
    }
}
