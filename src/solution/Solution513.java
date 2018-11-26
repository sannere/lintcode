package solution;

import java.util.HashMap;
import java.util.Map;

public class Solution513 {
    /**
     * @param n: a positive integer
     * @return: An integer
     */
    public int numSquares(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 0);
        return helper(n, map);
    }
    private int helper(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int root = (int)Math.sqrt(n);
        int min = n;
        for (int i = root; i > 0; i--) {
            int num = 1 + helper(n - i * i, map);
            min = Math.min(min, num);
        }
        map.put(n, min);
        return min;
    }
}
