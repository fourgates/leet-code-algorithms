package Graphs.DFS.CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class DFSCloneGragh {
    class Solution {
        HashMap<Node, Node> visited = new HashMap<>();
        public Node cloneGraph(Node node) {
            
            // base case
            if(node == null){
                return null;
            }
            
            // check if we processed this node already
            if(visited.containsKey(node)){
                return visited.get(node);
            }
            
            // clone node (can only do val right now)
            Node clonedNode = new Node(node.val, new ArrayList<>());
            
            // mark visited
            visited.put(node, clonedNode);
            
            for(Node neightbor: node.neighbors){
                clonedNode.neighbors.add(cloneGraph(neightbor));
            }
            return clonedNode;
        } 
    }
}
