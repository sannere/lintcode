package solution;

import basicStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution69_2 {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        int size = 0;
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> results = new ArrayList();

        queue.offer(root);

        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> level = new ArrayList();
            while (size > 0){
                TreeNode t = queue.poll();
                level.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
                size--;
            }
            results.add(level);
        }
        return results;
    }
}
