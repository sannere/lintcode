package solution;

import java.util.HashSet;

public class Solution627_2 {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        int sinCharNum = 0;
        HashSet<Character> hash = new HashSet();

        for (char ch : s.toCharArray()) {
            if (hash.contains(ch)) {
                hash.remove(ch);
            }
            else {
                hash.add(ch);
            }
        }

        if (hash.size() > 0) {
            sinCharNum = hash.size() - 1;
        }

        return s.length() - sinCharNum;

    }
}
