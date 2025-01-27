class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int isTen = 0;
      int sum = 0;
      ListNode dummy = new ListNode(0);
      ListNode curr = dummy;
      while (l1.next != null || l2.next != null || isTen != 1) {
        if (l1.next != null) {
          sum = sum + l1.val;
          l1 = l1.next;
        }
        if (l2.next != null) {
          sum = sum + l2.val;
          l2 = l2.next;
        }
        sum = sum + isTen;
        if (sum >= 10) isTen = 1;
        ListNode node = new ListNode(sum % 10);
        curr.next = node;
        curr = curr.next;
        sum = 0;
      }
      return dummy.next();
    }
  }
}

