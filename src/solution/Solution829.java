package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution829 {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote maping string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null && str != null || str == null && pattern != null) {
            return false;
        }

        return helper(pattern , 0, str, 0,
                new HashMap(), new HashSet(), new boolean[pattern.length()]);
    }
    private boolean helper(String pattern,
                           int pIndex,
                           String str,
                           int sIndex,
                           Map<Character,String> map,
                           Set<String> set,
                           boolean[] memo) {
        if (pIndex == pattern.length()) {
            return sIndex == str.length();
        }

        if (memo[pIndex]) {
            return true;
        }

        char letter = pattern.charAt(pIndex);
        boolean isMatch = false;

        //pattern当前字母出现过
        if (map.containsKey(letter)) {
            String mapedStr = map.get(letter);
            int len = mapedStr.length();


            isMatch =  (sIndex + len) <= str.length() &&
                    mapedStr.equals(str.substring(sIndex, sIndex + len)) &&
                    helper(pattern, pIndex + 1, str, sIndex + len, map, set, memo);

        }

        //pattern当前字母第一次出现
        else {
            for(int i = sIndex; i < str.length(); i++) {
                String sub = str.substring(sIndex, i + 1);
                if (set.contains(sub)) {
                    continue;
                }
                map.put(letter, sub);
                set.add(sub);
                if (helper(pattern, pIndex + 1, str, i + 1, map, set, memo)) {
                    isMatch = true;
                }
                map.remove(letter, sub);
                set.remove(sub);
            }
        }

        if (isMatch) {
            memo[pIndex] = true;
        }

        return isMatch;
    }
}
