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
    public void reorderList(ListNode head) {
       if(head.next == null || head.next.next == null) return;

       ListNode curr = head, currNext = head.next;

       while(currNext!=null && currNext.next!=null){
        ListNode lastBefore = currNext;
        while(lastBefore.next.next != null){
            lastBefore = lastBefore.next;
        }
        curr.next = lastBefore.next;
        lastBefore.next.next = currNext;
        lastBefore.next = null;

        curr = currNext;
        currNext = currNext.next;

       }

    }
}
