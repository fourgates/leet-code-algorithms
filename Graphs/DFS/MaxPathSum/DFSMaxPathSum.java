package Graphs.DFS.MaxPathSum;

public class DFSMaxPathSum {
    
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode() {}
    
    public TreeNode(int _val) {
        val = _val;
    }

    public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        
        // use max with 0 to deal with negative edges
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        
        int newPath = root.val + left + right;
        
        max = Math.max(max, newPath);
        
        return root.val + Math.max(left, right);
    }
}