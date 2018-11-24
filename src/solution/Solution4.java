package solution;

import java.util.*;

public class Solution4 {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        Long result = Long.valueOf(1);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();

        int[] factors = {2, 3, 5};

        pq.add(Long.valueOf(1));

        while (n > 0) {
            result = pq.poll();

            for (int f : factors) {
                if (!set.contains(f * result)) {
                    pq.add(result * f);
                    set.add(result * f);
                }
            }
            n--;
        }

        return result.intValue();
    }
}
