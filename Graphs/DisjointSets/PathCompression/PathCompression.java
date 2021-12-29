package Graphs.DisjointSets.PathCompression;

public class PathCompression {
    private int[] root;

    public PathCompression(int size){
        this.root = new int[size];

        // initialize the root of each node to itself
        // e.g. each node is its own parent
        for(int i=0;i<size;i++){
            root[i] = i;
        }
    }

    // this is a O(N) operation
    public int find(int x){
        if(x == root[x]){
            return x;
        }
        // iterate over each node until you find the root
        // the root nodes value = its index!        
        return root[x] = find(root[x]);
    }

    public void union(int x, int y){
        int rootX = find(x); // O (n)
        int rootY = find(y); // O (n)

        // if the two parent roots do not match...
        if(rootX != rootY){
            root[rootY] = rootX; // set the parent node of Y to X so they are now connected
        }
    }

    public boolean connected(int x, int y){
        // to determine if two nodes are connected we need to compare their parent nodes
        int rootX = find(x); // O(n)
        int rootY = find(y); // O(n)

        return rootX == rootY;
    }
}
