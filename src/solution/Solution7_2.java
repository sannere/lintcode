package solution;

import basicStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution7_2 {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        StringBuilder sb = new StringBuilder();
        List<TreeNode> list = new ArrayList();

        list.add(root);
        sb.append(root.val);

        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);


            if (node.left == null) {
                sb.append(",#");
            }
            else {
                sb.append("," + node.left.val);
                list.add(node.left);
            }

            if (node.right == null) {
                sb.append(",#");
            }
            else {
                sb.append("," + node.right.val);
                list.add(node.right);
            }
        }
        while (sb.charAt(sb.length() - 1) == '#') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
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

        TreeNode root = new TreeNode(Integer.parseInt(string[0]));
        ArrayList<TreeNode> list = new ArrayList();
        list.add(root);

        int index = 0;//list的坐标，代表正在添加list中第index的节点的左右子树
        for (int i = 0; 2 * i < string.length; i++) {//
            if (2 * i + 1 < string.length && !string[ 2 * i + 1].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(string[ 2 * i + 1]));
                list.get(index).left = left;
                list.add(left);
            }
            if (2 * i + 2 < string.length && !string[ 2 * i + 2].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(string[ 2 * i + 2]));
                list.get(index).right = right;
                list.add(right);
            }
            index++;
        }
        return root;
    }
}
