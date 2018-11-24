package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution139 {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int min = Math.abs(nums[0]);
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            if (map.containsKey(prefixSum[i + 1])) {
                result[0] = map.get(prefixSum[i + 1]);
                result[1] = i;
            }
            else {
                map.put(prefixSum[i + 1], i);
            }
        }
        Arrays.sort(prefixSum);
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < min) {
                result[0] = i;
                result[1] = i;
                min = nums[i];
            }
            if (prefixSum[i + 1] - prefixSum[i] < min) {
                int a = map.get(prefixSum[i + 1]), b = map.get(prefixSum[i]);
                result[0] = Math.min(a, b);
                result[1] = Math.max(a, b);
                min = prefixSum[i + 1] - prefixSum[i];
            }
        }
        return result;
    }
}
