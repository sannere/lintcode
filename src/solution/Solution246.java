package solution;

import basicStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution246 {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> results = new ArrayList();
        List<Integer> path = new ArrayList();
        if (root == null) {
            return results;
        }
        DFS(root, target, results, path);
        return results;
    }
    private void DFS(TreeNode node, int target, List<List<Integer>> results, List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        int sum = 0;
        int size = path.size();
        for (int i = size - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == target) {
                results.add(new ArrayList(path.subList(i, size)));
            }
        }

        DFS(node.left, target, results, path);
        DFS(node.right, target, results, path);
        path.remove(size - 1);
    }
}
