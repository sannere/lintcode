package solution;

import java.util.HashMap;
import java.util.Map;

public class Solution149 {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfix = prices[1] - prices[0];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(prices.length - 1, prices[prices.length - 1]);

        for (int i = prices.length - 2; i >= 0; i--) {
            int max = prices[i] > map.get(i + 1) ? prices[i] : map.get(i + 1);
            maxProfix = Math.max(maxProfix, max - prices[i]);
            map.put(i, max);
        }
        return maxProfix;
    }
}
