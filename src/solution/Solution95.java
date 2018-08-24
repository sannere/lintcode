package solution;

import basicStructure.TreeNode;

public class Solution95 {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private TreeNode lastNode;
    private boolean isValid;

    public boolean isValidBST(TreeNode root) {
        lastNode = null;
        isValid = true;
        inorder(root);
        return isValid;
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (!isValid || lastNode != null && lastNode.val >= root.val) {
            isValid = false;
            return;
        }

        lastNode = root;
        inorder(root.right);
    }
}
