package solution;

import basicStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution69 {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> results = new ArrayList();
        queue.offer(root);
        queue.offer(null);

        while (queue.element()!=null) {
            List<Integer> list = new ArrayList();
            while (queue.element()!=null) {
                TreeNode t= queue.poll();
                list.add(t.val);
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            queue.poll();
            queue.offer(null);
            results.add(list);

        }

        return results;
    }
}
