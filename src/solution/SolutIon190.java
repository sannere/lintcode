package solution;

public class SolutIon190 {
    /**
     * @param nums: An array of integers
     * @return: nothing
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 1;
        int j = i;

        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i == 0) {//the last permutation, return the first permutation
            swapArray(nums, 0);
            return;
        }

        while (nums[j] <= nums[i - 1]) {
            j--;
        }
        swapNumbers(nums, i - 1, j);
        swapArray(nums, i);
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
