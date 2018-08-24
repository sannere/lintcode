package solution;

import basicStructure.TreeNode;
class resultType {
    public boolean isBST;
    public TreeNode min;
    public TreeNode max;
    public resultType (boolean isBST) {
        this.isBST = isBST;
        this.min = null;
        this.max = null;
    }
}

public class Solution95_2 {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */

    public boolean isValidBST(TreeNode root) {
        return isvalid(root).isBST;
    }
    private resultType isvalid (TreeNode root) {
        if (root == null) {
            return new resultType(true);
        }

        resultType left = isvalid(root.left);
        resultType right = isvalid(root.right);

        if (!left.isBST || !right.isBST) {
            return new resultType(false);
        }
        if (left.max != null && left.max.val >= root.val) {
            return new resultType(false);
        }
        if (right.min != null && right.min.val <= root.val) {
            return new resultType(false);
        }

        //isBST
        resultType result = new resultType(true);
        result.max = right.max != null ? right.max : root;
        result.min = left.min != null ? left.min : root;

        return result;

    }
}
