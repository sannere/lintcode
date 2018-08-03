package solution;

public class Solution200_2 {
    public String longestPalindrome(String s) {
        int middle = 0;
        String result = "", temp = "";
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }
        for (; middle < s.length() - 1; middle++) {
            temp = subPalindrome(s, middle, middle);
            if (temp.length() > result.length()) {
                result = temp;
            }
            temp = subPalindrome(s, middle, middle + 1);
            if (temp.length() > result.length()) {
                result = temp;
            }
        }
        return result;
    }
    private String subPalindrome(String str, int left, int right) {
        while(left >= 0 && right <= str.length() - 1 && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }
}
