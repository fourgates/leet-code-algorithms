package Tree.BFS.LevelOrderTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
// tree root
//
// TASK
// return the level order traversal
//
// what is level order?
// - left to right level by level
// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // given the root
        // go left print, go right print
        // go to the next level
        // each new level can have more roots than the previous
        
        // print root
        // left print
        // queue left
        // right print
        // queue right
        if(root == null){
            return new ArrayList<>();
        }
        Queue<List<TreeNode>> levelQueue = new LinkedList<>();
        List<List<Integer>> order = new ArrayList<>();
        
        // initialize the first level and order from the root
        levelQueue.add(Arrays.asList(root));
        order.add(Arrays.asList(root.val));
        while(!levelQueue.isEmpty()){
            List<TreeNode> currentNodes = levelQueue.poll();
            
            // keep track of the order for the current level
            // and queue up the next nodes
            List<Integer> currentOrder = new ArrayList<>();
            List<TreeNode> nextNodes = new ArrayList<>();
            
            // add each node to the order (left to right)
            // and queue up their children
            for(TreeNode currentNode : currentNodes){      
                if(currentNode.left != null){
                    currentOrder.add(currentNode.left.val);
                    nextNodes.add(currentNode.left);
                }
                if(currentNode.right != null){
                    currentOrder.add(currentNode.right.val);
                    nextNodes.add(currentNode.right);
                }              
            }
            // append the order and next nodes
            if(currentOrder.size() > 0){
                order.add(currentOrder);   
            }        
            if(nextNodes.size() > 0){
                levelQueue.add(nextNodes);
            }
        }
        return order;
    }   
}
