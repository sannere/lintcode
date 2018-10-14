package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution570 {
    /**
     * @param n: An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    public int findMissing2(int n, String str) {
        //Exception judgement code
        if (n == 0 || str.equals("")) {
            return 0;
        }
        Set<Integer> cutted = new HashSet();
        helper(n, str, cutted);
        return findMissingNum(cutted, n);
    }
    private boolean helper(int n, String str, Set<Integer> cutted) {
        if (str.equals("")) {
            return true;
        }

        for (int len = 1; len <= str.length(); len++) {
            int num = strToNum(str, len);
            if (num > n) {
                return false;
            }
            if (num == 0) {
                return false;
            }
            if (cutted.contains(num)) {
                continue;
            }


            cutted.add(num);
            if (helper(n, str.substring(len), cutted)) {
                return true;
            }
            cutted.remove(num);
        }
        return false;
    }
    private int strToNum(String str, int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            num = num * 10 + str.charAt(i) - '0';
        }
        return num;
    }
    private int findMissingNum(Set<Integer> cutted, int n) {
        while (n > 0) {
            if (!cutted.contains(n)) {
                return n;
            }
            n--;
        }
        return n;
    }
}
