package Graphs.DisjointSets.RankOptimized;

public class QuickUnionRankOptimized {
    private int[] root;
    private int[] rank;

    public QuickUnionRankOptimized(int size){
        this.root = new int[size];
        this.rank = new int[size];

        // initialize the root of each node to itself
        // e.g. each node is its own parent
        for(int i=0;i<size;i++){
            root[i] = i;
            // init the weight to 1 since each has one parent
            rank[i] = 1;
        }
    }

    // this is a O(N) operation
    public int find(int x){
        // iterate over each node until you find the root
        // the root nodes value = its index!
        while(root[x] != x){
            x = root[x];
        }
        return x;
    }

    public void union(int x, int y){
        int rootX = find(x); // O (n)
        int rootY = find(y); // O (n)

        if(rootX == rootY){
            // nothing to do here...
            return;
        }

        // if the two parent roots do not match...
        // lets compare the height of each node
        // set the parent node of Y to X so they are now connected
        if(rank[rootX] > rank[rootY]){
            root[rootY] = rootX;
        }
        else if(rank[rootX] < rank[rootY]){
            root[rootX] = rootY;
        }
        else{ // heights are equal
            root[rootY] = rootX;
            rank[rootX] += 1;
        }
    }

    public boolean connected(int x, int y){
        // to determine if two nodes are connected we need to compare their parent nodes
        int rootX = find(x); // O(n)
        int rootY = find(y); // O(n)

        return rootX == rootY;
    }
}
