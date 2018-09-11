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
            return "#";
        }

        return serializeBFS(root);
    }
    private String serializeBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        StringBuilder string = new StringBuilder();

        queue.offer(root);
        boolean flag = true;

        while (!queue.isEmpty() && flag) {
            int size =queue.size();
            flag = false;
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                if (node == null && !queue.isEmpty()) {
                    string.append("#,");
                    continue;
                }
                string.append(String.valueOf(node.val) + ",");
                if (node.left != null || node.right != null) {
                    flag = true;
                }
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
        if (data.equals("#")) {
            return null;
        }
        String[] string = data.split(",");

        Queue<TreeNode> queue = new LinkedList();
        TreeNode root = new TreeNode(strToInt(string[0]));
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < string.length) {
            TreeNode node = queue.poll();

            if (string[index].equals("#")) {
                node.left = null;
            }
            else {
                node.left = new TreeNode(strToInt(string[index]));
                queue.offer(node.left);
            }
            index++;
            if (string[index].equals("#")) {
                node.right = null;
            }
            else {
                node.right = new TreeNode(strToInt(string[index]));
                queue.offer(node.right);
            }
            index++;
        }

        return root;
    }

    private int strToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num = num * 10 + s.charAt(i) - '0';
        }
        return num;
    }
}
