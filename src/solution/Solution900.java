package solution;

import basicStructure.TreeNode;

public class Solution900 {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    int closet;
    public int closestValue(TreeNode root, double target) {
        closet = root.val;
        DFS(root, target);
        return closet;
    }
    private void DFS(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        DFS(root.left, target);
        DFS(root.right, target);
        if (Math.abs((double)root.val -  target) < Math.abs((double)closet - target)) {
            closet = root.val;
        }
    }
}
