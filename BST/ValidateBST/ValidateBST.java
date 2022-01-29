package BST.ValidateBST;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {
    
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
    private boolean isValid = true;
    private List<Integer> path = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        if(!isValid){
            return false;
        }
        for(int i=1;i<path.size();i++){
            if(path.get(i-1) >= path.get(i)){
                return false;
            }
        }
        return isValid;
    }
    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        path.add(node.val);
        if(node.left != null){
            if(node.left.val >= node.val){
                isValid = false;
            }                           
        }
        if(node.right != null){
            if(node.right.val <= node.val){
                isValid = false;
            }                
        }
        dfs(node.right);
    }
}