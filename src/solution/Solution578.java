package solution;
import basicStructure.TreeNode;

public class Solution578 {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    TreeNode ancestor;
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        DFS(root, A, B);
        return ancestor;
    }
    private boolean DFS(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return false;
        }

        boolean left = DFS(root.left , A, B);
        boolean right = DFS(root.right , A, B);

        if (root == A || root == B ) {
            if (left || right || A == B) {
                ancestor = root;
            }
            return true;
        }
        if (left && right) {
            ancestor = root;
            return true;
        }
        return left || right;
    }
}
