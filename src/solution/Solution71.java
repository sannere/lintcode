package solution;

import basicStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution71 {
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        List<List<Integer>> results = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);
        boolean flag = false;
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
            if (flag) {
                reverse(list);
            }
            results.add(list);
            flag = !flag;
        }
        return results;
    }
    private void reverse(List<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left,list.get(right));
            list.set(right,temp);
            left++;
            right--;
        }
    }
}
