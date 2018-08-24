package solution;

import basicStructure.TreeNode;

public class Solution93 {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    private int Not_balanced = -1;
    public boolean isBalanced(TreeNode root) {
        return depth(root) != Not_balanced;
    }
    private int depth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == Not_balanced || right == Not_balanced) {
            return Not_balanced;
        }
        if (Math.abs(left - right) > 1) {
            return Not_balanced;
        }

        return Math.max(left, right) + 1;
    }
}
