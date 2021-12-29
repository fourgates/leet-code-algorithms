package Graphs.DisjointSets.QuickFind;

class App {
    public static void main(String[] args) throws Exception {
        QuickFind uf = new QuickFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
class QuickFind {
    private int[] root;

    public QuickFind(int size){
        this.root = new int[size];

        // initialize the root of each node to itself
        // e.g. each node is its own parent
        for(int i=0;i<size;i++){
            root[i] = i;
        }
    }

    // find a node's parent
    // this is constant time O(1)
    public int find(int x){
        return root[x];
    }   

    // union two nodes
    // this is a linear operation
    // O(N)
    public void union(int x, int y){
        // find each root
        int rootX = find(x);
        int rootY = find(y);

        // they are already in the same set!
        if(rootX == rootY){
            return;
        }
        // change each root Y to root X
        for(int i=0;i<root.length;i++){
            if(root[i] == rootY){
                root[i] = rootX;
            }
        }
    }

    // determine if two nodes are conencted
    // we check to see if their two root nodes are the same
    // that means that are in the same set!
    // this is done in constant time
    public boolean connected(int x, int y){
        return root[x] == root[y];
    }
}
