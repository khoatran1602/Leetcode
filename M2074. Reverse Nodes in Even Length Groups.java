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
    // This method reverses nodes in even-length groups in a linked list
    public ListNode reverseEvenLengthGroups(ListNode head) {
        // If the list has 0 or 1 nodes, return the head
        if (head.next == null || head.next.next == null) {
            return head;
        }
        
        // Start at the head of the list
        ListNode current = head;
        // Initialize a counter for the group number
        int group = 1;
        while (current != null) {
            // Store the current node in a temporary variable
            ListNode temp = current;
            // Create a stack to hold the values of nodes in the current group
            Stack<Integer> stack = new Stack<>();
            // Initialize a counter for the number of steps taken in the current group
            int step = 0;
            // Traverse the linked list, pushing each node's value onto the stack
            while (step != group) {
                stack.push(current.val);
                current = current.next;
                step++;
            }
            // If the number of steps is even, reverse the order of nodes in the group
            if (step % 2 == 0) {
                while (current != temp) {
                    temp.val = stack.pop();
                    temp = temp.next;
                }
            }
            // Move to the next group
            group++;
        }
        // Return the head of the modified linked list
        return head;
    }
}
