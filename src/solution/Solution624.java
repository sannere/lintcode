package solution;

import java.util.Set;

public class Solution624 {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {

    }
    private String getSubString(String s, String sub) {
        for (int i = 0,j = 0; i < s.length() - sub.length(); i++) {
            while (i < s.length() && j < sub.length() && s.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            }
            if (j == sub.length()) {
                String SubString = s.substring(0,)
            }
        }

    }
    private String remove(String s, int index, ) {

    }
}