package Graphs.DisjointSets;

public class FullOptimizedDisjointSet {
    private int[] root; // data
    
    // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
    private int[] rank; // weighted ranks

    public FullOptimizedDisjointSet(int size){
        this.root = new int[size];
        this.rank = new int[size];
        for(int i=0;i<size;i++){
            root[i] = i;
            rank[0] = 1; // each rank is init to 1 since it points to itself

            // The initial "rank" of each vertex is 1, because each of them is
            // a standalone vertex with no connection to other vertices.
        }
    }

	// The find function here is the same as that in the disjoint set with path compression.
    public int find(int x){
        if(x == root[x]){ // root
            return x;
        }  
        return root[x] = find(root[x]);
    }

    // The union function with union by rank
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rank[rootX] > rank[rootY]){
            root[rootY] = rootX;
        }
        else if(rank[rootY] > rank[rootX]){
            root[rootX] = rootX;
        }
        else{
            root[rootY] = rootX;
            rank[rootY] += 1;
        }
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
}
