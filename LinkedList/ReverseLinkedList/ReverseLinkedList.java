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
        Stack<Integer> stack = new Stack<Integer>();
        
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        ListNode out = new ListNode(-1);
        ListNode n = out;
        while(!stack.isEmpty()){
            Integer v = stack.pop();
            n.next = new ListNode(v);
            n = n.next;
        }
        return out.next;
    }
}
