package solution;

import basicStructure.TreeNode;

import java.util.HashMap;

public class Solution596 {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    int min;
    TreeNode subnode;
    public TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return null;
        }

        DFS(root);
        return subnode;
    }
    private int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + DFS(root.left)+ DFS(root.right);

        if (subnode == null || min > sum) {
            min = sum;
            subnode = root;
        }
        return sum;
    }
}
