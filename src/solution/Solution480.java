package solution;

import basicStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution480 {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */

    //travers版
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList();
        if (root == null) {
            return results;
        }
        DFS(root, results, String.valueOf(root.val));
        return results;
    }
    private void DFS(TreeNode root, List<String> results, String s) {
        if (root.left == null && root.right == null) {
            results.add(s);
            return;
        }
        if (root.right != null) {
            DFS(root.right, results, s + "->" + String.valueOf(root.right.val));
        }
        if (root.left != null) {
            DFS(root.left, results, s + "->" + String.valueOf(root.left.val));
        }
    }
}
