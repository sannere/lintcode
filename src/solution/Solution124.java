package solution;

import java.util.HashSet;
import java.util.Set;

public class Solution124 {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int max = 0;

        for (int i : num) {
            set.add(i);
        }

        for (int i : num) {
            int left = 0, right = 1;
            if (!set.contains(i)) {
                continue;
            }
            while (set.contains(i + left)) {
                set.remove(i + left);
                left--;
            }
            while (set.contains(i + right)) {
                set.remove(i + right);
                right++;
            }
            max = Math.max(max, (right - left));
        }
        return max;
    }
}
