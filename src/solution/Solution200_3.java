package solution;

public class Solution200_3 {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     **/
    public String longestPalindrome(String s) {
        int length = s.length(), max = 0;
        boolean[][] arr = new boolean[length][length];
        String str= "";

        if (s.isEmpty() || s == null) {
            return str;
        }
        if (length == 1) {
            return s;
        }
        for (int len = 0; len < length ; len++) {
            for (int index = 0; index < length - len; index++) {
                if (len == 0) {
                    arr[index][index] = true;
                }
                else if(len ==1) {
                    arr[index][index + len] = (s.charAt(index) == s.charAt(index + len));
                    if (index < (length - len) && arr[index][index + len]) {
                        max = 2;
                        str = s.substring(index, index+2);
                    }
                }
                else {
                    arr[index][index + len] = arr[index + 1][index + len - 1] && (s.charAt(index) == s.charAt(index + len));
                    if (arr[index][index + len] && len + 1 > max) {
                        max = len + 1;
                        str = s.substring(index, index + max);
                    }
                }
            }
        }

        return str;
    }
}
