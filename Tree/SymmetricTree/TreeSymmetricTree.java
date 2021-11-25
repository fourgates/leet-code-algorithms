package Tree.SymmetricTree;
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
// a tree
//
// TASK
//
// return a boolean to determine if the tree is symmetric around the center
//
// What makes a tree symmetric?
//
// - the same number of nodes on the left and the right
// - each node at the same level as the same value
// [101. Symmetric Tree - easy](https://leetcode.com/problems/symmetric-tree/)
public class TreeSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // go left and go right should be the same
        // do we need two roots?
        return isSymTree(root.left, root.right);
    }
    private boolean isSymTree(TreeNode leftTree, TreeNode rightTree){
        // TODO - i feel like these can prob be simplified

        // if the converse values do not match, return false
        if(leftTree == null && rightTree == null){
            return true;
        }
        if(leftTree == null && rightTree != null){
            return false;
        }
        if(leftTree != null && rightTree == null){
            return false;
        }
        if(leftTree.right == null && rightTree.left != null){
            return false;
        }
        if(leftTree.right != null && rightTree.left == null){
            return false;
        }        

        // check the actual values
        int left = leftTree.val;
        int right = rightTree.val;
        if(left != right){
            return false;
        }
        boolean isLeftSym = isSymTree(leftTree.left, rightTree.right);
        boolean isRightSym = isSymTree(leftTree.right, rightTree.left);
        return isLeftSym && isRightSym;
    }
}
