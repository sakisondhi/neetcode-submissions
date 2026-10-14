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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prevNode = head;
        ListNode changeLinkNode = head.next;
        ListNode nextNode = head.next.next;

        prevNode.next = null;

        while(nextNode != null){
            changeLinkNode.next = prevNode;
            prevNode = changeLinkNode;
            changeLinkNode = nextNode;
            nextNode = changeLinkNode.next;
        }
        changeLinkNode.next = prevNode;

        return changeLinkNode;
    }
}
