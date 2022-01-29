package BST.SearchBST;

public class SearchBST {
    
}
// GIVEN
//
// - the root of a BST
// - an integer targer
//
// TASK
//
// - find the node which equals the target
//
// OUTPUT
//
// subtree rooted with that node if it exists
// else reutrn null

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
    private TreeNode res = null;
    public TreeNode searchBST(TreeNode root, int val) {
        //dfs(root, val);
        TreeNode curr = root;
        while(curr != null){
            if(curr.val == val){
                return curr;
            }
            if(curr.val > val){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
        return res;
    }
    private void dfs(TreeNode root, int target){
        if(res != null || root == null){
            return;
        }
        if(root.val == target){
            res = root;
        }
        else if(root.val > target){
            dfs(root.left, target);    
        }
        else{
            dfs(root.right, target);    
        }
    }
}