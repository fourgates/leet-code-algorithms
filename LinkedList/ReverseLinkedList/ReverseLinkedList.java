package LinkedList.ReverseLinkedList;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * 206. Reverse Linked List - Easy
 * 
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * 
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        // stacks are first in last out
        // so the last one put onto the stack
        // will be the first one popped off
        Stack<Integer> stack = new Stack<Integer>();
        
        // put all the values onto the stack
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }

        // create a base node
        ListNode out = new ListNode(-1);

        ListNode n = out;
        while(!stack.isEmpty()){
            Integer v = stack.pop();
            n.next = new ListNode(v);
            // we need the links to be pointed in backwards order
            n = n.next;
        }
        // we dont want to return the -1 we instantiated
        return out.next;
    }
}
