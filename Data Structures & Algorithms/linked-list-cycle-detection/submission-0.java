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

class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return false;

        ListNode singleTraverse = head, doubleTraverse = head.next.next;

        while(true){
            if(singleTraverse == doubleTraverse) break;
            if(singleTraverse.next != null ) singleTraverse = singleTraverse.next;
            else return false;
            
            if(doubleTraverse.next != null && doubleTraverse.next.next !=null)
                doubleTraverse = doubleTraverse.next.next;
            else return false;
        }

        return true;


    }
}
