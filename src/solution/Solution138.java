package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution138 {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int sum = 0;
        int[] prefixSum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                result.add(0);
                result.add(i);
                return result;
            }
            prefixSum[i] = sum;
        }

        for (int left = 0; left < nums.length; left++) {
            for (int right = left + 1; right < nums.length; right++) {
                if (prefixSum[left] == prefixSum[right]) {
                    result.add(left + 1);
                    result.add(right);
                    return result;
                }
            }
        }
        return result;
    }
}
