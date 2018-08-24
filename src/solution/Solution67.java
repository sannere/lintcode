package solution;

import basicStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution67 {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */

    private List<Integer> list = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        recursion(root, list);
        return list;
    }
    private void recursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        recursion(root.left, list);
        list.add(root.val);
        recursion(root.right, list);
    }
}
