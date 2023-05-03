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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Set up a current node pointer to the head of the linked list, and a counter to track the number of nodes processed so far
        ListNode currNode = head;
        int nodeCount = 0;
        
        // While the current node pointer is not null, and the number of nodes processed so far is less than k
        while (currNode != null && nodeCount != k) { 
            // Move the current node pointer to the next node, and increment the node count
            currNode = currNode.next;
            nodeCount++;
        }
        
        // If we have processed k nodes
        if (nodeCount == k) { 
            // Recursively reverse the next k nodes and set the result to the current node pointer
            currNode = reverseKGroup(currNode, k);
            
            // While there are still nodes to reverse
            while (nodeCount-- > 0) { 
                // Set up temporary variables to hold the next node and the current head node
                ListNode nextNode = head.next; 
                head.next = currNode; 
                currNode = head; 
                head = nextNode; 
            }
            
            // Set the head node to the current node pointer
            head = currNode;
        }
        
        // Return the head node
        return head;
    }
}
