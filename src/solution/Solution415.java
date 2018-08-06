package solution;

public class Solution415 {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        s = s.trim().toLowerCase();

        return isPal(s,0,s.length() - 1);
    }
    private boolean isPal(String s, int i, int j) {
        while (i < s.length() && (s.charAt(i) > 'z' || s.charAt(i) <'a' && s.charAt(i) > '9' || s.charAt(i) < '0')) {
            i++;
        }
        while (j >= i && (s.charAt(j) > 'z' || s.charAt(j) <'a' && s.charAt(j) > '9' || s.charAt(j) < '0')) {
            j--;
        }

        if (j - i < 1) {
            return true;
        }
        return isPal(s,i+1,j-1) && s.charAt(i) == s.charAt(j);

    }
}
