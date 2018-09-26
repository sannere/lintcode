package solution;

import basicStructure.TreeNode;

public class Solution915_3 {
    /**
     * @param root: the given BST
     * @param p:    the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        TreeNode pre = null;
        while (root != null) {
            while (root != null && root.val >= p.val) {
                root = root.left;
            }
            if (root == null) {
                return pre;
            }
            pre = root;
            root = root.right;
        }
        return pre;
    }
}

