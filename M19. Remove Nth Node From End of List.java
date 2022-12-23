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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null || head == null) return null;
        ListNode current = head;
        int len = 0;
        while (current != null) {
            current = current.next;
            len = len + 1;
        }
        if (len == n) return head.next;
        int temp = len - n;
        current = head;
        for (int i = 0; i < temp - 1; i++) {
            current = current.next;
        }
        if (n == 1) current.next = null;
        else current.next = current.next.next;
        return head;
    }
}
