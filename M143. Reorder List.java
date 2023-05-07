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
    // Method to reorder a linked list
    public void reorderList(ListNode head) {
        // If the linked list is empty or has only one element, return
        if (head == null || head.next == null) return;
        
        // Initialize pointers p1 and p2 to the head of the linked list
        ListNode p1 = head;
        ListNode p2 = head;
        
        // Move p1 one step and p2 two steps at a time until p2 reaches the end of the list
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        // Set the middle of the linked list as the node pointed by p1
        ListNode middle = p1;
        // Set prev as the node next to the middle of the linked list
        ListNode prev = middle.next;
        
        // Reverse the second half of the linked list
        while (prev.next != null) {
            ListNode curr = prev.next;
            prev.next = curr.next;
            curr.next = middle.next;
            middle.next = curr;
        }
        
        // Merge the two halves of the linked list
        p1 = head;
        p2 = middle.next;
        while (p1 != middle) {
            middle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = middle.next;
        }
    }
}
