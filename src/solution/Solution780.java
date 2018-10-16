package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution780 {
    /**
     * @param s: The input string
     * @return: Return all possible results
     */

    int leftSum, rightSum;
    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList();
        Set<String> set1 = new HashSet();
        Set<String> set2 = new HashSet();

        if (s == null || s.length() == 0) {
            results.add("");
            return results;
        }
        s = CountNums(s);

        if (leftSum > rightSum) {
            removeLeft(s, s.length() - 1, 0, 0, set1);
            for (String str : set1) {
                removeBoth(str, 0, 0, 0, set2);
            }
        }
        if (leftSum < rightSum) {
            removeRight(s, 0, 0, 0, set2);

        }
        if (leftSum == rightSum) {
            removeBoth(s, 0, 0, 0, set2);
        }

        results.addAll(set2);
        return results;
    }

    private String CountNums(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder(s);

        //去掉不合法的头
        while (i < sb.length() && sb.charAt(i) != '(') {
            if (sb.charAt(i) == ')') {
                sb.deleteCharAt(i);
            }
            else {
                i++;
            }
        }

        //去掉不合法的尾巴
        i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) != ')') {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                i = sb.length() - 1;
            }
            else {
                i--;
            }
        }

        //分别计数
        i = 0;
        while (i < sb.length()) {
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

    private void removeLeft(String s, int index, int left, int right, Set<String> set) {
        if (index < 0) {
            set.add(s);
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
            removeLeft(s, index - 1, left, right, set);
            return;
        }

        //left > right:

        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) != '(') {
                removeLeft(s.substring(0,i) + s.substring(i + 1), index - 1,
                        left - 1, right, set);
            }
        }
    }

    private void removeRight(String s, int index, int left, int right, Set<String> set) {
        if (index == s.length()) {
            set.add(s);
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
            removeRight(s, index + 1, left, right, set);
            return;
        }

        //left < right:

        for (int i = index; i >= 0; i--) {
            if (s.charAt(i) == ')' && s.charAt(i - 1) != ')') {
                removeRight(s.substring(0,i) + s.substring(i + 1), index,
                        left, right - 1, set);
            }
        }
    }

    private void removeBoth(String s, int index, int left, int right, Set<String> set) {
        if (index == s.length()) {
            set.add(s);
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
                    0, 0, set);

        }
        else {
            removeBoth(s, index + 1, left , right, set);
        }
    }



}
