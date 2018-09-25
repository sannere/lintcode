package solution;

import basicStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution480_2 {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */

    //divide and conquer
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList();
        if (root == null) {
            return paths;
        }

        if (root.left != null) {
            List<String> leftPath = binaryTreePaths(root.left);
            for (String s : leftPath) {
                paths.add(String.valueOf(root.val) + "->" + s);
            }
        }
        if (root.right != null) {
            List<String> rightPath = binaryTreePaths(root.right);
            for (String s : rightPath) {
                paths.add(String.valueOf(root.val) + "->" + s);
            }
        }
        if (root.left == null && root.right == null) {
            paths.add(String.valueOf(root.val));
        }
        return paths;
    }
}
