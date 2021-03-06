package Graphs.DFS.RightPointers;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

/**
 * 116. Populating Next Right Pointers in Each Node - Medium
 * 
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 */
public class RightPointers {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }   
        if(root.right != null){
            root.left.next = root.right;    
        }
        if(root.right != null && root.next != null){
            root.right.next = root.next.left;
        }        
        // dfs
        connect(root.left);
        connect(root.right);

        return root; 
    }
}
