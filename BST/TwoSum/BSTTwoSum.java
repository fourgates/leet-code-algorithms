package BST.TwoSum;

public class BSTTwoSum {
    
}
/*

    NOTES
        
        given
            root of BST
            target number k
            
        todo
            return true if there exists two elements in the BST such that their sum is equal to the target
            
        notes
            what is a bst?
                all elements to the left are less than the curr root
                all elements to the right are greater than the curr root
            
        how big is tree?
            can be very large!
        values?
            also VERY large
        valid BST
        k has a higer range than the bst values
        
        thoughts...
            at any given node you can subtract and get the complement of the current node
            
            e.g.
            find 9
            root = 5
            9-5 =4
            transfer left side of tree looking for 4
            if 4 exists return true
            
            what do you do next.. if 4 did not exist?
            how do you transverse a BST?
                post order transversal
            
            pruning
                if you transverse the tree looking for n >= k/2
                if that doent exists you cannot find a solution
*/

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
    public boolean findTarget(TreeNode root, int k) {
        return helper(root, root, k);
    }
    private boolean helper(TreeNode root, TreeNode current, int k){
        if(current == null){
            return false;
        }
        int complement = k - current.val;
        if(current.val != complement && findComplement(root.left, complement)){
            return true;
        }
        if(current.val != complement && findComplement(root.right, complement)){
            return true;
        }
        if(helper(root, current.left, k)){
            return true;
        }
        if(helper(root, current.right, k)){
            return true;
        }
        return false;        
    }
    private boolean findComplement(TreeNode curr, int complement){
        while(curr != null){
            if(curr.val == complement){
                return true;
            }
            if(curr.val > complement){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
        return false;
    }
}