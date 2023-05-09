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
    // This method swaps the kth node from the beginning and the end of a linked list
    public ListNode swapNodes(ListNode head, int k) {
        // Initialize two pointers to the head of the linked list
        ListNode p1 = head;
        ListNode p2 = head;
        // Initialize two nodes to null
        ListNode first = null;
        ListNode second = null;
        
        // Move p1 to the kth node
        for (int i = 1; i < k; i++) {
            p1 = p1.next;
        }
        first = p1;
        
        // Move p1 and p2 simultaneously until p1 reaches the end of the list
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        second = p2;
        
        // Swap the values of the two nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        // Return the head of the linked list
        return head;
    }
}

