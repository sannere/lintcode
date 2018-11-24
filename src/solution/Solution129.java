package solution;

import basicStructure.ListNode;

public class Solution129 {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null) {
            return null;
        }

        int oldSize = hashTable.length;
        ListNode[] reHash = new ListNode[oldSize * 2];

        for (ListNode node : hashTable) {
            while (node != null) {
                unfold(reHash, node);
                node = node.next;
            }
        }
        return reHash;
    }
    private void unfold(ListNode[] reHash, ListNode head) {
        int capacity = reHash.length;
        int num = head.val;
        int index = num < 0 ? (num % capacity + capacity) % capacity : num % capacity;

        if (reHash[index] == null) {
            reHash[index] = new ListNode(head.val);
        }
        else {
            ListNode node = reHash[index];
            while( node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(head.val);
        }
    }
}
