package solution;

public class Solution200 {
    public String longestPalindrome(String s) {
        int left = 0, right = s.length() - 1, len = -1;
        String result = "";
        for (; left <= s.length() - 1 && (right - left) > len; left++) {
            for (; right >= left && (right - left) > len; right--) {
                if (isPalindrome(s, left, right) && (right - left) > len) {
                    //System.out.println("判断：" + isPalindrome(s, left, right));
                    len = right - left;
                    result = s.substring(left, right + 1);

                }
            }
            right = s.length() - 1;
        }
        return result;
    }

    private boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            else {
                i++;
                j--;
            }
        }
        System.out.println("true");
        return true;
    }
}
