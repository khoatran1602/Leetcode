/**
 * Solution for finding the middle node of a linked list using two-pointer technique
 * Time Complexity: O(n), Space Complexity: O(1)
 */
class Solution {
    /**
     * Definition for singly-linked list node
     */
    public static class ListNode {
        int value;
        ListNode next;

        ListNode() {}
        ListNode(int value) { this.value = value; }
        ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
    
    /**
     * Finds the middle node of a linked list using fast and slow pointers
     * @param headNode The head node of the linked list
     * @return The middle node (for even length lists, returns the second middle node)
     */
    public ListNode middleNode(ListNode headNode) {
        ListNode slowPointer = headNode;
        ListNode fastPointer = headNode;
        
        // Fast pointer moves twice as fast as slow pointer
        // When fast reaches end, slow will be at middle
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        return slowPointer;
    }
    
    /**
     * Main method for testing the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Create test linked list: 1->2->3->4->5
        ListNode testList = new ListNode(1, 
            new ListNode(2, 
                new ListNode(3, 
                    new ListNode(4, 
                        new ListNode(5)))));
                        
        System.out.println("Middle node value: " + solution.middleNode(testList).value);
    }
}
