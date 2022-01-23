package Graphs.ShortestPath.CheapestFlightsWithinKStops;

import java.util.Arrays;

public class ShortestPathCheapestFlightsWithinKStops {
    
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // init the a prev and current array to n+1 since this is not zero based storage
        int[] p = new int[n+1];
        int[] c = new int[n+1];
        
        // set the default values
        Arrays.fill(p, Integer.MAX_VALUE);
        Arrays.fill(c, Integer.MAX_VALUE);
        
        // base case
        p[src] = 0;
        // iterate k+1 times
        for(int i=0;i<k+1;i++){
            // source value is always 0
            c[src] = 0;
            for(int[] flight : flights){
                
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                
                if(p[from] < Integer.MAX_VALUE){ // the previous iteration has a value
                    // relax the current step to either the current value
                    // or the neighbor + its weight
                    // whichever is smaller
                    c[to] = Math.min(c[to], p[from] + price);
                }
            }
            p = c.clone();
        }
        return p[dst] == Integer.MAX_VALUE ? -1 : p[dst];
    }
}