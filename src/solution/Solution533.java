package solution;

import java.util.Arrays;

public class Solution533 {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */

    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        if (nums.length == 2) {
            return Math.abs(target - nums[0] - nums[1]);
        }
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1, result = Math.abs(target - nums[0] - nums[1]);

        while (left < right) {
            right = FindCloset(nums, left, right, target);
            int difference = Math.abs(nums[right] + nums[left] - target);
            if (difference == 0) {
                return 0;
            }
            result = Math.min(result, difference);
            left++;
        }
        return result;
    }
    private int FindCloset(int[] nums, int start, int end, int target) {
        target = target - nums[start];
        start++;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid;
            }
            else if (nums[mid] <= target) {
                start = mid;
            }
        }
        return Math.abs(nums[start] - target) < Math.abs(nums[end] - target) ? start : end;
    }
}
