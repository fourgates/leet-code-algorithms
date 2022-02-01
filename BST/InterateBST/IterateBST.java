package BST.InterateBST;

import java.util.ArrayList;
import java.util.List;

public class IterateBST {
    
}
// GIVEN
//
// - input will be a tree node which is a BST
//
// TODO
//
// - implement class that reps an iterator over the in order traveral of a bst
// - methods 
//      - constructor - init class. a root of the BST is given
//      - hasNext - return true if there is a number to the right
//      - next - moves pointer to the right and returns the pointer
//
// QUESTIONS
//
// can true be null or empty?
// constraint on time or space complexity?
// what happens if you call next and ther eis no next?
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
class BSTIterator {
    private List<TreeNode> nodes = new ArrayList<>();
    private int pointer = 0;
    public BSTIterator(TreeNode root) {
        dfs(root);
    }
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        nodes.add(root);
        dfs(root.right);
    }
    
    public int next() {
        return nodes.get(pointer++).val;
    }
    
    public boolean hasNext() {
        return pointer <= nodes.size() -1;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */