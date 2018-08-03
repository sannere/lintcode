package solution;

import basicStructure.TreeNode;

public class Solution880 {
    /**
     * Definition of TreeNode:
     * public class TreeNode {
     *     public int val;
     *     public TreeNode left, right;
     *     public TreeNode(int val) {
     *         this.val = val;
     *         this.left = this.right = null;
     *     }
     * }
     */

    public TreeNode str2tree(String s) {
        //char ch = s.charAt(0);
        int val = 0,i = 0;
        TreeNode t = new TreeNode(val);
        String number = "";

        if (s.isEmpty()) {
            return null;
        }

        for(; i < s.length() && s.charAt(i) != '('; i++) {
            number = number + s.charAt(i);
        }
        if (number.charAt(0) == '-') {
            val = 0 - StringToInt(number.substring(1));
            s = s.substring(i - 1);
        }
        else {
            val = StringToInt(number);
            s = s.substring(i - 1);
        }

        t.val = val;
        if (s.length() == 1) {
            return t;
        }
        else {
            int leftTreeRightIndex = FindRightIndex(s.substring(1));
            t.left = str2tree(s.substring(2,leftTreeRightIndex));
            if (s.length() > leftTreeRightIndex + 1) {
                int rightTreeRightIndex = FindRightIndex(s.substring(leftTreeRightIndex + 1));
                t.right = str2tree(s.substring(leftTreeRightIndex + 2, leftTreeRightIndex + rightTreeRightIndex));
            }
            return t;
        }

    }
    private int FindRightIndex(String childs) {
        int num = 1, index = 1;
        char[] arr = childs.toCharArray();
        for (; index < arr.length && num != 0; index++) {
            if (arr[index] == '(') {
                num++;
            }
            else if (arr[index] == ')'){
                num--;
            }
        }
        return index;
    }
    private int StringToInt (String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num = num * 10 + s.charAt(i) - '0';
        }
        return num;
    }
}

