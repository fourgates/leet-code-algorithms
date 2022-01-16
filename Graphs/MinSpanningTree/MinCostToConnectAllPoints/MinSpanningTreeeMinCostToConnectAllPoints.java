package Graphs.MinSpanningTree.MinCostToConnectAllPoints;

import java.util.PriorityQueue;

public class MinSpanningTreeeMinCostToConnectAllPoints {
    
}
class Solution {
    int n;
    public int minCostConnectPoints(int[][] points) {
        // edge cases
        if(points == null || points.length == 0){
            return -1;
        }
        this.n = points.length;
        // return kruscal(points);
        return prism(points);
    }
    private int prism(int[][] points){
        int size = points.length;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b)-> a[2] - b[2]);
        boolean[] visited = new boolean[size];
        int result = 0;
        int count = size - 1;
        
        // pick [0] as the first point
        int[] coord1 = points[0];
        
        // find all the edges for node 0
        for(int j=1;j<size;j++){
            int[] coord2 = points[j];

            int x1 = coord1[0];
            int y1 = coord1[1];
            int x2 = coord2[0];
            int y2 = coord2[1];

            // calc weight and add it to queue
            int weight = Math.abs(x1 - x2) + Math.abs(y1-y2);
            queue.offer(new int[]{0, j, weight});                
        }
        
        // mark noe 0 as visited
        visited[0] = true;
        while(!queue.isEmpty() && count > 0){
            int[] coord = queue.poll();
            int x1 = coord[0];
            int y1 = coord[1];
            int weight = coord[2];
            
            // ignore edge if we have visited it already
            if(visited[y1]){
                continue;
            }
            
            // add it to the MST and mark it visited
            result += weight;
            visited[y1] = true;
            
            // time to add the edges from the newest verticie (y1 -> i)
            for(int i = 0;i<size;i++){
                if(visited[i]){
                    continue;
                }
                // y1 is the new node
                // so we need to find the weight of the edges between that and the
                // edges we are iterating over (node i)
                int weight2 = Math.abs(points[y1][0] - points[i][0]) 
                    + Math.abs(points[y1][1]-points[i][1]);
                queue.offer(new int[]{y1, i, weight2});                
            }
            count--;
        }
        return result;
    }
    private int kruscal(int[][] points){
        // - sort all edges by weight
        // - add edge if it does not create a cycle
        // - continue until you added n-1 edges        
        // init
        int edges = 0;
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
}
class UnionFind{
        private int[] root;
        private int[] rank;
        
        public UnionFind(int n){
            this.root = new int[n];
            this.rank = new int[n];
            
            for(int i=0;i<n;i++){
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }
        public void union(int x, int y){
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
        public int find(int x){
            if(root[x] == x){
                return x;
            }
            return root[x] = find(root[x]);
        }
        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }