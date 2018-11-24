package solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution209_3 {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        int left = 0, right = 0;

        while (left < str.length()) {
            if (right < str.length() && str.charAt(right) != str.charAt(left) || left == right ) {
                right++;
                continue;
            }
            if (right == str.length()) {
                return str.charAt(left);
            }
            left++;
            right = 0;
        }
        return '0';
    }
}
