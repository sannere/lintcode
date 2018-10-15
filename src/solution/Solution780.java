package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution780 {
    /**
     * @param s: The input string
     * @return: Return all possible results
     */

    int leftSum, rightSum;
    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList();

        if (s == null || s.length() == 0) {
            results.add("");
            return results;
        }
        s = CountNums(s);

        if (leftSum > rightSum) {
            removeLeft(s, s.length() - 1, 0, 0, results);
        }
        if (leftSum < rightSum) {
            removeRight(s, 0, 0, 0, results);
        }
        if (leftSum == rightSum) {
            removeBoth(s, 0, 0, 0, results);
        }
        return results;
    }

    private String CountNums(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder(s);
        while (i < s.length()) {
            //去掉不合法的头
            if (sb.charAt(0) == ')') {
                sb.deleteCharAt(0);
                continue;
            }
            //去掉不合法的尾巴
            int len = sb.length();
            if (sb.charAt(len - 1) == '(') {
                sb.deleteCharAt(len - 1);
                continue;
            }
            //分别计数
            if (sb.charAt(i) == '(') {
                leftSum++;
            }
            if (sb.charAt(i) == ')') {
                rightSum++;
            }
            i++;
        }
        return sb.toString();
    }

    private void removeLeft(String s, int index, int left, int right, List<String> results) {
        if (index < 0) {
            results.add(s);
            return;
        }
        char c = s.charAt(index);

        if (c == '(') {
            left++;
        }
        if (c == ')') {
            right++;
        }

        if (left <= right) {
            removeLeft(s, index - 1, left, right, results);
            return;
        }

        //left > right:

        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) != '(') {
                removeLeft(s.substring(0,i) + s.substring(i + 1), index - 1,
                        left - 1, right, results);
            }
        }
    }

    private void removeRight(String s, int index, int left, int right, List<String> results) {
        if (index == s.length()) {
            results.add(s);
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            left++;
        }
        if (c == ')') {
            right++;
        }

        if (left >= right) {
            removeRight(s, index + 1, left, right, results);
            return;
        }

        //left < right:

        for (int i = index; i >= 0; i--) {
            if (s.charAt(i) == ')' && s.charAt(i - 1) != ')') {
                removeLeft(s.substring(0,i) + s.substring(i + 1), index + 1,
                        left, right - 1, results);
            }
        }
    }

    private void removeBoth(String s, int index, int left, int right, List<String> results) {
        if (index == s.length()) {
            results.add(s);
            return;
        }

        char c = s.charAt(index);
        if (c == '(') {
            left++;
        }
        if (c == ')') {
            right++;
        }

        if (right > left) {
            removeLeft(s.substring(0,index) + s.substring(index + 1), s.length() - 2,
                    0, 0, results);

        }
        else {
            removeBoth(s, index + 1, left , right, results);
        }
    }


}
