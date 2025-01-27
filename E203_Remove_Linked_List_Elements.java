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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            if (current.val == val) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    head = current.next;
                }
            } else {
                previous = current;
            }
            current = current.next;
        }
        return head;
    }
}
=====================================================================
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
  public ListNode removeElements(ListNode head, int val) {
      while (head != null && head.val == val) head = head.next;

      ListNode current = head;
      while (current != null && current.next != null) {
          if (current.next.val == val) current.next = current.next.next;
          else current = current.next;
      } 

      return head;
  }
}
