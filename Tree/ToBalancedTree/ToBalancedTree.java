package Tree.ToBalancedTree;

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

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ToBalancedTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return new TreeNode();
        }
        return bstHelper(nums, 0, nums.length-1);
        
    }
    private TreeNode bstHelper(int[] nums, int start, int end){
        // base case, similar to two pointers
        if(start > end){
            return null;
        }
        // on each iteration we want to take the middle of the sub array and make it the root
        int mid = (start + end) / 2;
        
        TreeNode root = new TreeNode(nums[mid]);

        // the left and the right are the root of ths sub arrays
        root.left = bstHelper(nums, start, mid-1);
        root.right = bstHelper(nums, mid+1, end);
        
        return root;
    }
}
