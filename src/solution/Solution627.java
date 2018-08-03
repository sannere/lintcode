package solution;

import java.util.Hashtable;

public class Solution627 {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        int length = 0;

        Hashtable<Character, Integer> hash = new Hashtable();

        if (s.length() < 2) {
            return s.length();
        }

        for (int i = 0; i < s.length(); i++) {
            if (!hash.containsKey(s.charAt(i)) || hash.get(s.charAt(i)) == 0) {
                hash.put(s.charAt(i), 1);
            }
            else if(hash.get(s.charAt(i)) == 1) {
                hash.put(s.charAt(i),0);
                length+=2;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (hash.get(s.charAt(i)) == 1) {
                length++;
                break;
            }
        }

        return length;

    }
}
