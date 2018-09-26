package solution;

import basicStructure.TreeNode;

public class Solution915_2 {
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (root.val > p.val) {
            return inorderPredecessor(root.left, p);
        }

        TreeNode right = inorderPredecessor(root.right, p);
        return right != null ? right : root;
    }
}
