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
  
}
// Given the head of a singly linked list, reverse the list, and return the reversed list.
//
// pseduo code 1 iterative
//
//  create a prev node and set it to null
//  while head is not null
//      create a current node and point it to head
//      increment head by setting head to next
//      point currents next node to prev
//      set prev to the curr node
//  return prev

// pseduo code 2 recursive
//  (curr, prev)
//      if curr is null return prev
//      create a new node (temp) and set it to curr's next node
//      set temps next to prev
//      recurve using (temp, prev)
class Solution {
    public ListNode reverseList(ListNode head) {
        //return iterate(head);
        return recurse(head, null);
    }
    private ListNode recurse(ListNode curr, ListNode prev){
        if(curr == null){
            return prev;
        }
        // create a pointer to the old curr next
        ListNode temp = curr.next;

        // set the new curr next to prev
        curr.next = prev;

        // recurse
        return recurse(temp, curr);
    }
    private ListNode iterate(ListNode head){
        ListNode prev = null;
        while(head != null){
            // keep a reference to head
            ListNode curr = head;
            
            // increment head
            head = head.next;

            // set the current node's nvext to the previous node
            curr.next = prev;

            // incremnt prev (really a decrement)
            prev = curr;
        }
        return prev;        
    }
}
