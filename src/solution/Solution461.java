package solution;

import java.util.Arrays;

public class Solution461 {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        return QuickSelect(nums, 0, nums.length - 1, k - 1);

    }
    private int QuickSelect(int[] nums , int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int left = start, right = end;
        int pivot = nums[(left + right) / 2];

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (k >= left) {
            return QuickSelect(nums, left, end, k);
        }
        else if (k <= right) {
            return QuickSelect(nums , start, right, k);
        }
        else {
            return nums[k];
        }
    }
    private void swap(int[] nums ,int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
