class Solution {
    public ListNode partition(ListNode head, int x) {
        // Initialize two dummy nodes to hold smaller and bigger elements
        ListNode smaller = new ListNode(0);
        ListNode bigger = new ListNode(0);
        // Initialize two pointers to the dummies
        ListNode small = smaller;
        ListNode big = bigger;
        // Traverse the linked list
        while (head != null) {
            // If the current node is smaller than x, add it to the smaller list
            if (head.val < x) {
                small.next = head;
                small = small.next;
            // If the current node is bigger than or equal to x, add it to the bigger list
            } else {
                big.next = head;
                big = big.next;
            }
            // Move to the next node in the original list
            head = head.next;
        }
        // Set the end of the bigger list to null
        big.next = null;
        // Join the smaller and bigger lists together
        small.next = bigger.next;
        // Return the head of the smaller list (excluding the dummy node)
        return smaller.next;
    }
}
