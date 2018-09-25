package solution;

import basicStructure.TreeNode;

import java.util.*;

public class Solution901 {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> results = new ArrayList();
        if (k == 0 || root == null) {
            return results;
        }

        Stack<TreeNode> stack = new Stack();
        Stack<Integer> pre = new Stack();
        Queue<Integer> next = new LinkedList();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode firstbigger = null;
        int count = 0;
        while (!stack.isEmpty() && count < k) {
            TreeNode node = stack.peek();
            if (node.val <= target) {
                    pre.push(node.val);
            }
            else {
                if (firstbigger == null) {
                    firstbigger = node;
                }
                next.add(node.val);
                count++;
            }
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
                    stack.pop();
                }
            }
        }
        for (count = 0; count < k && !pre.isEmpty() && !next.isEmpty(); count++) {
            if (target - pre.peek() < next.peek() - target) {
                results.add(pre.pop());
            }
            else {
                results.add(next.poll());
            }
        }
        if (count < k && pre.isEmpty()) {
            while (count < k) {
                results.add(next.poll());
                count++;
            }
        }
        if (count < k && next.isEmpty()) {
            while (count < k) {
                results.add(pre.pop());
                count++;
            }
        }
        return results;
    }

}
