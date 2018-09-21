package solution;

import basicStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution70 {
    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList();
        if (root == null) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            results.add(0, list);
        }
        return results;
    }
}
