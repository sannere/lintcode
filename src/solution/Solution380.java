package solution;

import basicStructure.ListNode;

import java.util.HashSet;

public class Solution380 {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        HashSet<ListNode> set = new HashSet();



        for (ListNode node = headA; node != null; node = node.next) {
            set.add(node);
        }
        for (ListNode node = headB; node != null; node = node.next) {
            if (set.contains(node)) {
                return node;
            }
        }

        return null;
    }
}
