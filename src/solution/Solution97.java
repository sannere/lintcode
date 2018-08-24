package solution;

import basicStructure.TreeNode;

public class Solution97 {
    private int max;
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        //traverse
        max = 0;
        traverse(root, 1);
        return max;
    }
    private void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        max = Math.max(max, depth);
        traverse(root.left, depth + 1);
        traverse(root.right,depth + 1);
    }
}
