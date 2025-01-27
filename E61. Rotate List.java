// class Solution {
//     public ListNode rotateRight(ListNode head, int k) {
//         if (head == null || k == 0 || head.next == null) return head;
//         ListNode current = head;
//         List<Integer> list = new ArrayList<>();
//         while (current != null) {
//             list.add(current.val);
//             current = current.next;
//         }
//         if (k % list.size() == 0) return head;
//         ListNode newHead = head;
//         int index = 0;
//         for (int i = list.size() - (k % list.size()); i < list.size(); i++) {
//             index = i;
//             newHead.val = list.get(i);
//             newHead = newHead.next;
//         }
//         for (int i = 0; i < index; i++) {
//             if (newHead == null) break;
//             newHead.val = list.get(i);
//             newHead = newHead.next;
//         }
//         return head;
//     }
// }

class Solution {
    // Method to rotate a linked list to the right by k places
    public ListNode rotateRight(ListNode head, int k) {
        // Return head if it's null or k is 0 or there's only one node in the list
        if (head == null || k == 0 || head.next == null) return head;
        
        // Get the length of the list and the tail node
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            n++;
            tail = tail.next;
        }
        
        // Connect the tail to the head to form a circular linked list
        tail.next = head;
        
        // Mod k by n to handle cases where k is greater than n
        k %= n;
        
        // Find the new tail node by moving n - k steps from the current tail
        for (int i = 0; i < n - k; i++) {
            tail = tail.next;
        }
        
        // The new head is the node next to the new tail
        ListNode newHead = tail.next;
        
        // Break the circular linked list by setting the next node of the new tail to null
        tail.next = null;
        
        // Return the new head
        return newHead;
    }
}
