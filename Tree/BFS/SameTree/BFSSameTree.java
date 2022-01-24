package Tree.BFS.SameTree;

import java.util.ArrayList;
import java.util.List;

public class BFSSameTree {
    
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        bfs(p, a);
        bfs(q, b);
        return a.equals(b);
    }
    private void bfs(TreeNode node, List<Integer> t){
        if(node == null){
            return;
        }
        t.add(node.val);
        if(node.left == null){
            t.add(null);
        }
        bfs(node.left, t);
        if(node.right == null){
            t.add(null);
        }        
        bfs(node.right, t);
    }
}