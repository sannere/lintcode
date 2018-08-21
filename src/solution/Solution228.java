package solution;

import basicStructure.ListNode;

public class Solution228 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;

        if (head == null) {
            return null;
        }
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
