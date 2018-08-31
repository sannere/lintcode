package solution;

public class Solution604 {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] results = new int[nums.length - k + 1];
        int left = 0, right = 0;
        int sum = 0;
        while (left <= nums.length - k) {
            while (right - left + 1 < k) {
                sum += nums[right];
                right++;
            }
            sum += nums[right];
            results[left] = sum;
            sum -= nums[left];
            left++;
            right++;
        }
        return results;
    }
}
