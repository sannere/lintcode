package solution;

import java.util.Arrays;
import java.util.HashMap;

public class Solution610 {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        int i = 0;
        int[] results = new int[2];
        HashMap<Integer, Integer> map = new HashMap();

        for (; i < nums.length; i++) {
            if (map.containsKey(nums[i] - target)) {
                results[0] = map.get(nums[i] - target) + 1;
                break;
            }
            if (map.containsKey(nums[i] + target)) {
                results[0] = map.get(nums[i] + target) + 1;
                break;
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }

        results[1] = i + 1;
        return results;
    }

}
