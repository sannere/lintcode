package solution;

import basicStructure.TreeNode;

public class Solution453 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        DFS(root);

    }
    private TreeNode DFS(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftLast = DFS(root.left);
        TreeNode rightLast = DFS(root.right);

        TreeNode temp = root.right;

        //左右子树都为空
        if(rightLast == null && leftLast == null) {
            return root;
        }
        //左子树为空，右子树不为空
        if (leftLast == null) {
            return rightLast;
        }
        //左子树不为空：
        root.right = root.left;
        root.left = null;
        //左子树不为空 && 右子树为空
        if (rightLast == null) {
            return leftLast;
        }
        //左右子树都不空
        leftLast.right = temp;
        return rightLast;
    }
}
