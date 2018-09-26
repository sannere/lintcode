package solution;

import basicStructure.TreeNode;
import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution901_2 {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> upperStack = new Stack();//nodes > target
        Stack<TreeNode> lowerStack = new Stack();//nodes <= target
        List<Integer> results = new ArrayList();
        //upperStack：栈底的点因为大于target，所以下一个点肯定要左拐，所以点越来越小，即从栈顶到栈底递增
        //lowerStack：栈底的点因为小于target，所以下一个点肯定要右拐，所以点越来越大，即从栈顶到栈底递减
        //可以利用这个特点，化简moveLower和moveUpper的过程
        //lowerStack要往move lower的话，只需要看当前节点有没有左节点leftchild，即需不需要往下走
        // 如果左节点还有更大的leftchild.right,就按续加到栈里，即在节点的左下方找next
        // 如果没有leftchild，而lowerStack递减的，那么直接pop掉当前节点，下一个栈顶为该节点的祖父，而且在左上方。
        //upperStack同理

        while (root != null) {
            if (root.val > target) {
                upperStack.push(root);
                root = root.left;
                continue;
            }
            lowerStack.push(root);
            root = root.right;
        }

        while (k > 0) {
            if (upperStack.isEmpty() ||
                    !lowerStack.isEmpty() && target - lowerStack.peek().val < upperStack.peek().val - target) {
                results.add(lowerStack.peek().val);
                moveLower(lowerStack);
            }
            else if (lowerStack.isEmpty() ||
                    (!upperStack.isEmpty() &&
                            target - lowerStack.peek().val >= upperStack.peek().val - target)) {
                results.add(upperStack.peek().val);
                moveUpper(upperStack);
            }
            k--;
        }

        return results;
    }

    private void moveLower(Stack<TreeNode> stack) {
        TreeNode node = stack.pop().left;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }

    }
    private void moveUpper(Stack<TreeNode> stack) {
        TreeNode node = stack.pop().right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
