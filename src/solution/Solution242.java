package solution;

import basicStructure.ListNode;
import basicStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution242 {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        Queue<TreeNode> queue = new LinkedList();
        List<ListNode> results = new LinkedList();
        int depth = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode listnode = null;

            while (size > 0) {
                TreeNode node = queue.poll();
                if (listnode == null) {
                    listnode = new ListNode(node.val);
                    results.add(listnode);
                }
                else {
                    listnode.next = new ListNode(node.val);
                    listnode = listnode.next;
                }

                size--;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return results;
    }
}
