package Graphs.DisjointSets;

public class FullOptimizedDisjointSet {
    private int[] root; // data
    private int[] rank; // weighted ranks

    public FullOptimizedDisjointSet(int size){
        this.root = new int[size];
        this.rank = new int[size];
        for(int i=0;i<size;i++){
            root[i] = i;
            rank[0] = 1; // each rank is init to 1 since it points to itself
        }
    }

    public int find(int x){
        if(x == root[x]){ // root
            return x;
        }  
        return root[x] = find(root[x]);
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX > rootY){
            root[rootY] = rootX;
        }
        else if(rootY > rootX){
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
