package solution;

import basicStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution7 {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        return serializeBFS(root);
    }
    private String serializeBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        StringBuilder string = new StringBuilder();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                string.append("#,");
                continue;
            }
            string.append(String.valueOf(node.val) + ",");
            if (node.left != null || node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return string.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        return deserializeBFS(data, 0);
    }
    private TreeNode deserializeBFS(String data, int index) {
        if (index > data.length() || data.charAt(index) == '#') {
            return null;
        }

        TreeNode node = new TreeNode(data.charAt(index) - '0');
        node.left = deserializeBFS(data, index + 1);
        node.right = deserializeBFS(data, index + 2);
        return node;
    }
}
