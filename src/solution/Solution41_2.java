package solution;

public class Solution41_2 {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
}
