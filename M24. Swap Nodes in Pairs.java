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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode slow = head;
        while (slow.next != null) {
            int slowTemp = slow.val;
            slow.val = slow.next.val;
            slow.next.val = slowTemp;
            if (slow.next.next == null) break;
            slow = slow.next.next;
        }
        return head;
    }
}
