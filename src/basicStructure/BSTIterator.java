package basicStructure;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack();
    /*
     * @param root: The root of binary tree.
     */
    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            return true;
        }
        while (!stack.isEmpty()) {
            if (node == stack.peek().left) {
                return true;
            }
            node = stack.pop();
        }
        return false;
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        TreeNode node = stack.peek();
        TreeNode cur =  node;

        if (node.right == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek() == node) {
                node = stack.pop();
            }
        }
        else {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return cur;
    }
}
