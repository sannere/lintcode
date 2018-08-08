package solution;

import java.util.Hashtable;

public class Solution667 {
    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] arr = new int[len][len];

        if (len <= 1) {
            return len;
        }
        for (int i = len - 1; i >= 0; i--) {
            arr[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    arr[i][j] = arr[i + 1][j - 1] + 2;
                }
                else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i + 1][j]);
                }
            }
        }

        return arr[0][len - 1];
    }
}
