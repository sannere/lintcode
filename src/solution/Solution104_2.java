package solution;

import basicStructure.ListNode;

import java.util.List;

public class Solution104_2 {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        return merge(lists, 0, lists.size() - 1);
    }
    private ListNode merge(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }

        int mid = start + (end - start) / 2;
        ListNode leftHead = merge(lists, start, mid);
        ListNode rightHead = merge(lists, mid + 1, end);

        return mergeTwoList(leftHead, rightHead);
    }
    private ListNode mergeTwoList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            }
            else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if (left != null) {
            tail.next = left;
        }
        else {
            tail.next = right;
        }
        return dummy.next;
    }
}
