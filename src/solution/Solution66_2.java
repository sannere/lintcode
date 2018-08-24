package solution;

import basicStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution66_2 {
        /**
         * @param root: A Tree
         * @return: Preorder in ArrayList which contains node values.
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList();
            }

            List<Integer> list = new ArrayList();
            Stack<TreeNode> stack = new Stack();

            stack.push(root);

            while (!stack.empty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
            return list;
        }
}
