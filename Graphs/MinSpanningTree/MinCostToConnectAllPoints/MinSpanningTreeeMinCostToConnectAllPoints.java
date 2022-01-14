package Graphs.MinSpanningTree.MinCostToConnectAllPoints;

import java.util.PriorityQueue;

public class MinSpanningTreeeMinCostToConnectAllPoints {
    
}
// We can use Kruscals Algorithm
// 
// - sort all edges by weight
// - add edge if it does not create a cycle
// - continue until you added n-1 edges
class Solution {
    public int minCostConnectPoints(int[][] points) {
        // edge cases
        if(points == null || points.length == 0){
            return -1;
        }
        
        // init
        int edges = 0;
        int n = points.length;
        int totalWeight = 0;
        UnionFind uf = new UnionFind(n);
        
        // use a PQ to sort min weighted edge first
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b)-> a[2] - b[2]);
        
        // we need a nested look to calculate all the weights
        for(int i=0;i<points.length;i++){
            int[] coords = points[i];
            int x1 = coords[0];
            int y1 = coords[1];            
            for(int j=i+1;j<points.length;j++){
                int[] coords2 = points[j];
                int x2 = coords2[0];
                int y2 = coords2[1];                
                
                // calc weight and add it to queue
                int weight = Math.abs(x1 - x2) + Math.abs(y1-y2);
                queue.offer(new int[]{i, j, weight});
            }
        }
        
        // iterate over each edge until we are done
        while(!queue.isEmpty() && edges < n-1){
            int[] edge = queue.poll();
            
            // if the two nodes are already connected in the graph
            // we should not add this edge
            if(uf.isConnected(edge[0], edge[1])){
                continue;
            }
            
            // else union the two edges to build the graph
            uf.union(edge[0], edge[1]);
            
            // incrememnt counters
            totalWeight += edge[2];
            edges++;
        }
        return totalWeight;
    }
    public class UnionFind{
        // data
        private int[] root;
        // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
        private int[] rank;
        
        public UnionFind(int n){
            this.root = new int[n];
            this.rank = new int[n]; // each rank is init to 1 since it points to itself
            
            for(int i=0;i<n;i++){
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }
        private void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            
            if(rootY == rootX){
                return;
            }
            
            if(rank[rootY] > rank[rootX]){
                root[rootX] = rootY;
            }
            else if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }
            else{
                root[rootY] = rootX;
                rank[rootY]++;
            }
        }
        private int find(int x){
            if(root[x] == x){ // root
                return x;
            }
            return root[x] = find(root[x]);
        }
        private boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
}