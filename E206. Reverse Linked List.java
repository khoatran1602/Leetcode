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
    // This method reverses a linked list
    public ListNode reverseList(ListNode head) {
        // If the head node is null, return null
        if (head == null) {
            return null;
        }
        
        // Initialize the previous, slow, and fast nodes
        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode nextNode = head.next;
        
        // Traverse the linked list and reverse the direction of the pointers
        while (nextNode != null) {
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.next;
        }
        
        // Reverse the pointer of the last node to the previous node
        currentNode.next = previousNode;
        previousNode = currentNode;
        
        // Return the new head node
        return previousNode;
    }
}
