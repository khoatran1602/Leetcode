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
// class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         if (head == null) return null;
//         if (head.next == null) return head;
//         ListNode res = new ListNode();
//         res.next = head;
//         ListNode temp = res;
//         while (temp.next != null && temp.next.next != null) {
//             if (temp.next.val == temp.next.next.val) {
//                 int value = temp.next.val;
//                 while (temp.next != null && temp.next.val == value) {
//                     temp.next = temp.next.next;
//                 }
//             } else {
//                 temp = temp.next;
//             }
//         }
//         return res.next;
//     }
// }
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Create a dummy node and set its next pointer to the head of the given linked list
        ListNode dummy = new ListNode(0, head);
        // Create a new current pointer and set it to the dummy node
        ListNode curr = dummy;
        // Traverse the linked list until two nodes ahead of the current node is null
        while (curr.next != null && curr.next.next != null) {
            // If the value of the next node and the next node after that is the same, remove duplicates
            if (curr.next.val == curr.next.next.val) {
                int val = curr.next.val;
                while (curr.next != null && curr.next.val == val) {
                    curr.next = curr.next.next;
                }
            } else {
                // Move the current pointer to the next node
                curr = curr.next;
            }
        }
        // Return the head of the modified linked list (i.e., the node after the dummy node)
        return dummy.next;
    }
}
