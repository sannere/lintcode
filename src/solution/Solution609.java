package solution;

import java.util.Arrays;

public class Solution609 {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;

            }
            else {
                result += (right - left);
                left++;
            }
        }
        return result;
    }
}
