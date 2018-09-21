package solution;

import basicStructure.TreeNode;

public class Solution88 {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    private TreeNode ances;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        DFS(root, A, B);
        return ances;
    }
    private boolean DFS(TreeNode root , TreeNode A, TreeNode B) {
        if (root == null) {
            return false;
        }

        boolean lefttree = DFS(root.left, A, B);
        boolean righttree = DFS(root.right, A, B);

        if (root == A || root == B) {
            if (lefttree || righttree || A == B) {
                ances = root;
            }
            return true;
        }
        if (lefttree && righttree) {
            ances = root;
            return true;
        }
        return lefttree || righttree;
    }

}
