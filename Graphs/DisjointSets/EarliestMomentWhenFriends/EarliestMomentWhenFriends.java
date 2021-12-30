package Graphs.DisjointSets.EarliestMomentWhenFriends;

import java.util.Arrays;

public class EarliestMomentWhenFriends {
    
}

class Solution {
    private int[] root;
    private int[] rank;
    private int groups;
    
    public int earliestAcq(int[][] logs, int n) {
        if(n <= 0){
            return -1;
        }
        this.root = new int[n];
        this.rank = new int[n];
        this.groups = n;
        for(int i=0;i<n;i++){
            this.root[i] = i;
            this.rank[i] = 1;
        }
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));
        for(int i=0;i<logs.length;i++){
            int timestamp = logs[i][0];
            int x = logs[i][1];
            int y = logs[i][2];
            union(x, y);
            if(groups == 1){
                return timestamp;
            }
        }
        return -1;
    }
    private int find(int x){
        if(root[x] == x){
            return x;
        }
        return x = find(root[x]);
    }
    private void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX == rootY){
            return;
        }
        groups--;
        if(rootX > rootY){
            root[rootY] = rootX;
        }
        else if(rootY > rootX){
            root[rootX] = rootY;
        }
        else{
            root[rootY] = rootX;
            rank[rootY] +=1;
        }
    }
} 