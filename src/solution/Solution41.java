package solution;

import java.util.HashMap;
import java.util.Map;

public class Solution41 {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        int sum = 0;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i + 1] = sum;
        }

        for (int left = 0; left < prefixSum.length; left++) {
            for (int right = left + 1; right < prefixSum.length; right++) {
                max = Math.max(max, prefixSum[right] - prefixSum[left]);
            }
        }

        return max;
    }
}
