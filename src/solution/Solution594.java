package solution;

public class Solution594 {
    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */

    public int strStr2(String source, String target) {
        int mod = 10000000;

        if (source.isEmpty() || target.isEmpty()) {
            return -1;
        }

        int m = target.length();
        if (m == 0) {
            return 0;
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
                return i - m + 1;
            }
        }

        return -1;
    }
}
