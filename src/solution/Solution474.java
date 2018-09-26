package solution;

import basicStructure.ParentTreeNode;

public class Solution474 {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        if (root == null) {
            return null;
        }

        ParentTreeNode a = A;
        ParentTreeNode b = B;

        while (a != null) {
            while (b != null) {
                if (a == b) {
                    return a;
                }
                b = b.parent;
            }
            a = a.parent;
        }
        return null;
    }
}
