package solution;

import java.util.HashMap;
import java.util.Map;

public class Solution685 {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int result = nums[0];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
            if (i == number) {
                break;
            }
        }

        if (!map.containsKey(number)) {
            return -1;
        }

        for (int i : nums) {
            if (map.get(i) == 1) {
                return i;
            }

            if (i == number) {
                break;
            }
        }
        return -1;
    }
}
