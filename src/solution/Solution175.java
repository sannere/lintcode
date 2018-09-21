package solution;

import basicStructure.TreeNode;

public class Solution175 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
