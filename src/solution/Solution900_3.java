package solution;

import basicStructure.TreeNode;

import java.util.Stack;

public class Solution900_3 {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        TreeNode lowerBound = FindLowerBound(root, target);//lowerBound <= target
        TreeNode upperBound = FindUpperBound(root, target);//UpperBound > target

        if (lowerBound == null) {
            return upperBound.val;
        }
        if (upperBound == null) {
            return lowerBound.val;
        }

        return target - lowerBound.val < upperBound.val - target ? lowerBound.val : upperBound.val;
    }
    private TreeNode FindLowerBound(TreeNode root, double target) {
        if (root == null) {
            return null;
        }
        //find the node that equals to target
        if (root.val == target) {
            return root;
        }
        //root's val is bigger, continue searching on left child
        if (root.val > target) {
            return FindLowerBound(root.left, target);
        }
        //root's val is smaller, continue searching on right child, if right can't find one, return root
        TreeNode rightResult = FindLowerBound(root.right, target);
        return rightResult != null ? rightResult : root;
    }
    private TreeNode FindUpperBound(TreeNode root, double target) {
        if (root == null) {
            return null;
        }
        //root's val is not bigger than target, continue searching on right child
        if (root.val <= target) {
            return FindUpperBound(root.right, target);
        }
        //root's val is bigger, continue searching on left child, if left can't find one, return root
        TreeNode leftResult = FindUpperBound(root.left, target);
        return leftResult != null ? leftResult : root;

    }
}
