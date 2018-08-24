package solution;

import basicStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution68 {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    private List<Integer> list = new ArrayList();
    public List<Integer> postorderTraversal(TreeNode root) {
        recursion(root, list);
        return list;
    }
    private void recursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        recursion(root.left, list);
        recursion(root.right, list);
        list.add(root.val);
    }
}
