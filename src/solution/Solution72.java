package solution;

import basicStructure.TreeNode;

public class Solution72 {
    /**
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    int root = 0, leftch = 1, rightch = 2;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null ||
                inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        GetTree(inorder, postorder, 0);
    }

    private TreeNode GetTree(int[] inorder, int[] postorder, int index) {
        TreeNode cur = 
    }



}
