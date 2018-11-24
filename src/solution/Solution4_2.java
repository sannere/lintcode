package solution;

import java.util.*;

public class Solution4_2 {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        int p2 = 0, p3 = 0, p5 = 0;
        list.add(1);

        for (int i = 0; i < n - 1; i++) {
            int tail = list.get(i);

            while (2 * list.get(p2) <= tail) {
                p2++;
            }
            while (3 * list.get(p3) <= tail) {
                p3++;
            }
            while (5 * list.get(p5) <= tail) {
                p5++;
            }

            int next = Math.min(Math.min(2 * list.get(p2), 3 * list.get(p3)), 5 * list.get(p5));

            list.add(next);
        }

        return list.get(n - 1);
    }
}
