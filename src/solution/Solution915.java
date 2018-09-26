package solution;

import basicStructure.TreeNode;

public class Solution915 {
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;

        while (root != null && root.val != p.val) {
            if (root.val < p.val) {
                pre = root;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }

        if (root == null) {
            return null;
        }
        root = root.left;
        while (root != null) {
            pre = root.right;
        }
        return pre;
    }

}
