package solution;

import basicStructure.TreeNode;

import java.util.Stack;

public class Solution902 {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k == 0) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (k > 1) {
            TreeNode node = stack.peek();

            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            else {
                node = stack.pop();
                while (!stack.isEmpty() && node == stack.peek().right) {
                    node = stack.pop();
                }
            }
            k--;
        }

        return stack.peek().val;
    }
}
