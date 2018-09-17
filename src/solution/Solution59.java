package solution;

import java.util.Arrays;

public class Solution59 {
    /**
     * @param nums: Give an array nums of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];//initial result

        for (int right = 2; right < nums.length; right++) {
            int mid = right - 1, left = 0;
            int twosum = target - nums[right];
            while (left < mid) {
                int targetMid = twosum - nums[left];
                mid = FindMidPos(nums, left + 1, mid, targetMid);
                if (targetMid == nums[mid]) {
                    return target;
                }
                if (Math.abs(result - target) > Math.abs(targetMid - nums[mid])) {
                    result = nums[left] + nums[mid] + nums[right];
                }
                left++;
            }
        }

        return result;
    }


    private int FindMidPos(int[] nums, int start, int end, int target) {
        if (end - start == 0) {
            return end;
        }
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid;
            }
            else if (nums[mid] < target) {
                start = mid;
            }
            else{
                return mid;
            }
        }
        return Math.abs(nums[start] - target) < Math.abs(nums[end] - target) ? start : end;
    }
}
