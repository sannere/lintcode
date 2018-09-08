package solution;

public class Solution52 {
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int i = nums.length - 1;
        int j = i;

        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i == 0) {//the last permutation, return the first permutation
            swapArray(nums, 0);
            return nums;
        }

        while (nums[j] <= nums[i - 1]) {
            j--;
        }
        swapNumbers(nums, i - 1, j);
        swapArray(nums, i);
        return nums;
    }
    private void swapArray(int[] nums, int start) {
        for (int end = nums.length - 1; end > start; start++, end--) {
            swapNumbers(nums, start, end);
        }
    }
    private void swapNumbers(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
