package Tree.BFS.LevelOrderTraversalReverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSLevelOrderTraversalReverse {
    
}

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> order = new ArrayList<>();
        if(root == null){
            return order;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curr = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                curr.add(node.val);
                if(node.left != null){
                    queue.add(node.left);    
                }
                if(node.right != null){
                    queue.add(node.right);    
                }
            }
            order.add(0, curr);
        }
        //Collections.reverse(order);
        return order;
    }
}