package solution;

import basicStructure.TreeNode;

public class Solution453_2 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    private TreeNode lastNode;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            lastNode = root;
            return;
        }
        if (root.right == null) {
            flatten(root.left);
            root.right = root.left;
            root.left = null;
            return;
        }
        if (root.left == null) {
            flatten(root.right);
            return;
        }

        flatten(root.left);
        lastNode.right = root.right;
        flatten(root.right);
        root.right = root.left;
        root.left = null;
    }
}
