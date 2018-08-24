package solution;

import basicStructure.TreeNode;

public class Solution97_2 {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
