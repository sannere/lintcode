package solution;

import java.util.Arrays;

public class Solution443 {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1, result = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) {
                left++;
            }
            else {
                result += (right - left);
                right--;
            }
        }
        return result;
    }
}
