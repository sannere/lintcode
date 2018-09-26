package solution;

import basicStructure.TreeNode;

import java.util.Stack;

public class SolutIon448 {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode next = null;

        while (root != null && root != p) {
            if (root.val > p.val) {
                next = root;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }

        if (root == null) {
            return null;
        }

        root = root.right;
        while (root != null) {
            next = root;
            root = root.left;
        }

        return next;
    }
}
