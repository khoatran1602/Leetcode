/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode current = head;
        ListNode after = head.next;
        while (after != null && after.next != null) {
            if (current == after) {
                return true;
            }
            current = current.next;
            after = after.next.next;
        }
        return false;
    }
}
