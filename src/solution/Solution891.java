package solution;

public class Solution891 {
    /**
     * @param s: a string
     * @return: nothing
     */
    public boolean validPalindrome(String s) {
        int chance = 1,l = 0, r = 0;
        int left = 0, right = s.length() - 1;

        while (left < s.length() && right >= 0 && left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            else if(chance == 1 && s.charAt(left + 1) == s.charAt(right)) {
                left+=2;
                right--;
                chance++;
                l = left - 2;
                r = right;
            }
            else if (chance == 1 && s.charAt(left) == s.charAt(right - 1)) {
                left++;
                right-=2;
                chance--;
            }
            else if (chance == 2 && s.charAt(l) == s.charAt(r)) {
                left = l + 1;
                right = r - 1;
                chance = 0;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
