package solution;

import basicStructure.ListNode;

public class Solution380_2 {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }
        node.next = headB;

        ListNode fast = headA.next, slow = headA;
        while (slow != fast) {
            if (fast.next == null || fast == null) {
                node.next = null;
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = headA;
        fast = fast.next;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        node.next = null;
        return fast;
    }
}
