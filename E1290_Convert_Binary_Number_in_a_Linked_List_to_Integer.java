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
    public int getDecimalValue(ListNode head) {
        int len = 0;
        int sum = 0;
        ListNode current = head;
        while (head != null) {
            len++;
            head = head.next;
        }
        len = len - 1;
        while (current != null) {
            System.out.print(len + " ");
            sum = sum + current.val * (int) Math.pow(2, len);
            current = current.next;
            len--;
        }
        return sum;
    }
}
