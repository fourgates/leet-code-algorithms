package DFS.MaxDepthOfBinaryTree;

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
public class DFSMaxDepth {
    private int maxDepthCount = 0;
    public int maxDepth(TreeNode root) {
        // so this is a DFS
        // we can use recursion or iteration
        dfs(root, 0);
        return this.maxDepthCount;
    }
    private void dfs(TreeNode root, int currentDepth){
        if(root == null){
            return;
        }
        currentDepth++;
        if(currentDepth > maxDepthCount){
            this.maxDepthCount = currentDepth;
        }        
        if(root.left != null){
            dfs(root.left, currentDepth);
        }
        if(root.right != null){
            dfs(root.right, currentDepth);
        }
    }
}
