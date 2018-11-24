package solution;

import basicStructure.ListNode;

import java.util.*;

public class Solution104 {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        ListNode result = new ListNode(0);
        ListNode pointer = result;


        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(),
                new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        while (!pq.isEmpty()) {
            pointer.next = pq.poll();
            pointer = pointer.next;
            if (pointer.next != null) {
                pq.offer(pointer.next);
            }
        }

        return result.next;
    }
}
