package solution;

import java.util.Hashtable;

public class Solution841 {
    /**
     * @param a: The A array
     * @param b: The B array
     * @param s: The S string
     * @return: The answer
     */
    public String stringReplace(String[] a, String[] b, String s) {

        Hashtable<Integer, Integer> hash  = new Hashtable();
        int start = 0;
        int strIndex;
        int min = 0;

        while (min != s.length()) {
            min = s.length();

            for (int i = 0; i < a.length; i++) {
                strIndex = isSubstring(s, a[i], start);
                if (strIndex != -1) {
                    if (min == s.length()) {
                        min = strIndex;
                        hash.put(strIndex, i);
                    }
                    else if (strIndex < min || strIndex == min && a[i].length() > a[hash.get(min)].length()) {
                        hash.put(strIndex, i);
                        min = strIndex;
                    }
                }
            }
            if (min != s.length()) {
                start = min + b[hash.get(min)].length();
                s = s.substring(0,min) + b[hash.get(min)] + s.substring(start);
            }
        }



        return s;


    }
    private int isSubstring(String s, String target, int start) {
        String source = s.substring(start);

        int mod = 10000000;

        if (source.isEmpty() || target.isEmpty()) {
            return -1;
        }

        int m = target.length();
        if (m == 0) {
            return start;
        }

        //get 31^m
        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % mod;
        }

        //get targetHash

        int targetHash = 0;
        for (int i = 0; i < m; i++) {
            targetHash = (targetHash * 31 + target.charAt(i)) % mod;
        }

        int sourceHash = 0;
        for (int i = 0; i < source.length(); i++) {
            sourceHash = (sourceHash * 31 + source.charAt(i)) % mod;
            if (i < m - 1) {
                continue;
            }

            if (i >= m) {
                sourceHash = sourceHash - source.charAt(i - m) * power % mod;
                if (sourceHash < 0) {
                    sourceHash += mod;
                }
            }

            if (sourceHash == targetHash && source.substring(i - m + 1, i + 1).equals(target)) {
                return i - m + 1 + start;
            }
        }

        return -1;
    }
}
