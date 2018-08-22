package solution;

import java.util.Arrays;

public class Solution587 {
    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1, result = 0;
        Arrays.sort(nums);

        while (left < right) {

            if (left < right && nums[left] + nums[right] > target) {
                right--;
            }
            else if (left < right && nums[left] + nums[right] < target) {
                left++;
            }
            else if (left < right && nums[left] + nums[right] == target) {
                while (left < right && (nums[left] == nums[left + 1])) {
                    left++;
                }
                result++;
                left++;
                right--;
            }
        }
        return result;
    }
}
