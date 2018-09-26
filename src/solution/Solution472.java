package solution;

import basicStructure.ParentTreeNode;
import com.sun.management.GarbageCollectionNotificationInfo;
import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution472 {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        List<List<Integer>> results = new ArrayList();

        if (root == null) {
            return results;
        }

        helper(root, target, results);
        return results;
    }
    private void helper(ParentTreeNode root, int target, List<List<Integer>> results) {
        if (root == null) {
            return;
        }

        List<Integer> path = new ArrayList();
        findPath(root, target, results, path, null);

        helper(root.left, target, results);
        helper(root.right, target, results);
    }

    private void findPath(ParentTreeNode root,
                          int target,
                          List<List<Integer>> results,
                          List<Integer> path,
                          ParentTreeNode from) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;

        if (target == 0) {
            results.add(new ArrayList(path));
        }
        if (from != root.parent) {
            findPath(root.parent, target, results, path, root);
        }
        if (from != root.left) {
            findPath(root.left, target, results, path, root);
        }
        if (from != root.right) {
            findPath(root.right, target, results, path, root);
        }
        path.remove(path.size() - 1);
    }

}
