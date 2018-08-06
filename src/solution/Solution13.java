package solution;

public class Solution13 {
    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        int s = 0, t = 0, index = -1;


        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }
        if (target.isEmpty()) {
            return 0;
        }

        while (s < source.length() && t < target.length()) {
            while (s < source.length() && source.charAt(s) != target.charAt(t)) {
                s++;
            }
            while (s <source.length() && t < target.length() && source.charAt(s) == target.charAt(t)) {
                s++;
                t++;
            }
            if (t == target.length()) {
                index = s - target.length();
            }
            else {
                s = s - t + 1;
                t = 0;
            }

        }
        return index;
    }
}
