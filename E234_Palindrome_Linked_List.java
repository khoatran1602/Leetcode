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
    public boolean isPalindrome(ListNode head) {
        ListNode current = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = slow;
            slow = slow.next;
            temp.next = current;
            current = temp;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (current != null) {
            if (current.val != slow.val) return false;
            current = current.next;
            slow = slow.next;
        }
        return true;
    }
}
