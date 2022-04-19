package TwoPointers.LinkedListCycle;

public class TwoPointersLinkedListCycle {
    
}

/*
    given
        - head of a linked list
        
    task
        - determine if list has a cycle
        - return true if there is a cycle, else false
        
    what is a cycle?
        - if there is a node that can be reached again by continusouly following the next pointer
    
    q
        - how big can list by
        - how big can value be
        - single LL
        - space or time contraints
    
    edge cases
        - null head
        - one node
        - two nodes
        - no nodes
        
    food for thought
        - maybe two pointers
        - keep one pointer at the head and try to get another one to the tail...
        - slow and fast pointer
        - fast pointer would eventually catch up to slow pointer
        
    impl
        - has a slow and fast pointer
        - have slow pointer more move node at a time
        - have fast pointer move two nodes at a time
        - if there is a cycle the slow pointer will eventually catch up to the fast one
        - hm when would you stop...
            - when the slower pointer visits a node that the fast pointer has visited...

    complexity
        - time -  O(n)
        - space - O(1)            
*/


 
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                return true;
            }
        }
        return false;    
    }
}