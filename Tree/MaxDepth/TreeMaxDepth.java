package Tree.MaxDepth;
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
// GIVEN
//
// a tree node
//
// TASK
//
// find the max depth
// [104. Maximum Depth of Binary Tree - Easy](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
public class TreeMaxDepth {
    private int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode root, int count){
        if(root == null){
            // once you get to a leaf check to see if we need to update the max
            if(count > this.maxDepth){
                this.maxDepth = count;
            }
            return 0;
        }        
        // use DFS
        dfs(root.left, count + 1);
        dfs(root.right, count + 1);
        return this.maxDepth;
    }
}
