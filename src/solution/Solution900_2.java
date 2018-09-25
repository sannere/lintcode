package solution;

import basicStructure.TreeNode;

import java.util.Stack;

public class Solution900_2 {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    //在第一版的基础上稍微改进一了一点：
    // 第一版不分情况，遍历左右两个子树，时间为o(n)。
    // 这一版里，如果已经能判断出右子树的值更close，就不再遍历左子树了，这样遍历时间应为log(n)的。
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
        if (root.right != null &&
                Math.abs((double)root.val - target) > Math.abs((double)root.right.val - target)) {
            DFS(root.right, target);
        }
        else {
            DFS(root.left, target);
        }
        if (Math.abs((double)root.val - target) < Math.abs((double)closet - target)) {
            closet = root.val;
        }
    }
}
