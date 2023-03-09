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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // If 'left' and 'right' are same, return the linked list as it is
        if (left == right) return head;
        // Create a dummy node with value '-1' to keep track of the new head of the linked list
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 'prev' will point to the node just before the 'left' position
        ListNode prev = dummy;
        // Traverse the linked list to reach the 'left' position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        // Set 'curr' to point to the 'left' position
        ListNode curr = prev.next;
        
        // Reverse the linked list from position 'left' to position 'right'
        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        // Return the new head of the linked list
        return dummy.next;
    }
}
