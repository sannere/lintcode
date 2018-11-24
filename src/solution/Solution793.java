package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution793 {
    /**
     * @param arrs: the arrays
     * @return: the number of the intersection of the arrays
     */
    public int intersectionOfArrays(int[][] arrs) {
        if (arrs == null || arrs.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] arr : arrs) {
            for (int i : arr) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                }
                else {
                    map.put(i, 1);
                }
            }
        }

        int length = arrs.length;
        int count = 0;

        for (int i : map.keySet()) {
            if (map.get(i) == length) {
                count++;
            }
        }
        return count;
    }
}
