package Graphs.DisjointSets.NumberOfProvinces;

public class GraphsNumberOfProvinces {
    
}
// GIVEN
// 
// n number of cities
// some are connected while others are not
// there is transitive connectivity 
//
// province is a set of cities that are connected
//
// you are given a n x n matrix
//
// m[i][j] = 1 if city i and j are directly conected
//
// this is a disjoint set question
//
// we can create a dijoint set ds, union the connected cities and then count the number of 
// distinct root nodes
class Solution {
    private Integer[] root;
    private Integer[] rank;
    private int count;
    public int findCircleNum(int[][] isConnected) {
        if(isConnected.length == 0){
            return 0;
        }
        this.root = new Integer[isConnected.length];
        this.rank = new Integer[isConnected.length];
        
        // assume each city is independent and we will
        // determine the provinces when we union them
        this.count = isConnected.length;
        for(int i=0;i<root.length;i++){
            root[i] = i;
            rank[i] = 1;
        }
        
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j] == 1 && !isConnected(i,j) && i != j){
                    union(i,j);    
                }
            }
        }
        return count;
        //return new HashSet<Integer>(Arrays.asList(root)).size();
    }
    
    private int find(int x){
        if(x == root[x]){
            return x;
        }
        return root[x] = find(root[x]);
    }
    private void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return;
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
        // connecting two nodes that are not already connected will reduce the number
        // of privinces by 1
        count--;
    }
    private boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
}