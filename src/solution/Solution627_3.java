package solution;

public class Solution627_3 {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        int[] chars = new int[52];
        int length = 0;

        for (char ch : s.toCharArray()) {
            if (ch > 'Z') {
                chars[ch - 'a' + 26]++;
            }
            else {
                chars[ch - 'A']++;
            }
        }

        for (int i : chars) {
            if (i != 0) {
                length = length + (i / 2) * 2;
                if (length % 2 == 0 && i % 2 == 1) {
                    length++;
                }
            }
        }

        return length;
    }
}
