package DFS.NextPointer;

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
 * 
 * 116. Populating Next Right Pointers in Each Node - Medium
 * 
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 */
public class DFSNextPointer {
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
        connect(root.left);
        connect(root.right);

        return root; 
    }
}
