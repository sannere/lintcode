package solution;

import basicStructure.TreeNode;
class treeAverage {
    public TreeNode subtree;
    public int count, sum;
    public float maxAvr;
    public treeAverage(TreeNode subtree, float maxAvr, int count, int sum) {
        this.subtree = subtree;
        this.maxAvr = maxAvr;
        this.count = count;
        this.sum = sum;
    }
}

public class Solution597 {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */

    public TreeNode findSubtree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        return DFS(root).subtree;
    }
    private treeAverage DFS(TreeNode root) {
        if (root == null) {
            return new treeAverage(null, Integer.MIN_VALUE,0,0);
        }
        if (root.left == null && root.right == null) {
            return new treeAverage(root, root.val,1,root.val);
        }
        treeAverage leftchild = DFS(root.left);
        treeAverage rightchild = DFS(root.right);
        int sum = leftchild.sum + rightchild.sum + root.val;
        int count = leftchild.count + rightchild.count +1;
        float ave = (float)sum / count;
        if (leftchild.maxAvr > rightchild.maxAvr && leftchild.maxAvr > ave) {

            return new treeAverage(leftchild.subtree, leftchild.maxAvr, count, sum);
        }
        if (rightchild.maxAvr > leftchild.maxAvr && rightchild.maxAvr > ave) {
            return new treeAverage(rightchild.subtree, rightchild.maxAvr, count, sum);
        }
        return new treeAverage(root, ave, count, sum);
    }
}
