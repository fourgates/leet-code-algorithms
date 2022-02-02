package LinkedList.MergeTwoLinkedLists;

public class MergeIterator {
        

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// pseduo 1
//
//  if l1 is null or l2 is null
//      return l1 or l2, whichever is not null
//  if l1's value is less than l2
//      set l1's next to mergeList while incrementing l1 to next
//      return l1
//  if 12's value is less than l1
//      set l2's next to merge list while incrementing l2 to next
//      return l2
//
// pseduo 2
//
//  create a dummy node
//  create a tail node and set it equal to the dummy node
//  while l1 and l2 is not null
//      if l1's val is less than l2's val
//          set the tail's next to be l1
//          increment l1 by setting it to its next node
//      if l2's val is less than l1's val
//          set tails nexto tbe be l2
//          increment l2 by setting l2 to its next node
//      increment tail by setting it equal to next
//  since l1 or l2 might not be null set tail.next to whichever is not null
//  return dummy.next since the merge started at next
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return recursive(list1, list2);
        // return iterate(list1, list2);
    }
    private ListNode recursive(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = recursive(l1.next, l2);
            return l1;
        }
        else{
            l2.next = recursive(l1, l2.next);
            return l2;
        }
    }
    private ListNode iterate(ListNode list1, ListNode list2){
        ListNode root = new ListNode(-1);
        ListNode dummy = root;
        while(list1 != null && list2 !=null){
            if(list1.val < list2.val){
                dummy.next = list1;
                list1 = list1.next;
            }
            else{
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = list1 == null ? list2 : list1;
        return root.next;
    }
}
