package solution;

public class Solution625 {
    /**
     * @param nums: an integer array
     * @param low: An integer
     * @param high: An integer
     * @return: nothing
     */
    public void partition2(int[] nums, int low, int high) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int left = 0, middle = 0, right = nums.length - 1;

        while (middle <= right) {
            if (nums[middle] < low) {
                swap(nums, left, middle);
                left++;
                middle++;
                continue;
            }
            if (nums[middle] > high) {
                swap(nums, right, middle);
                right--;
                continue;
            }
            middle++;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

