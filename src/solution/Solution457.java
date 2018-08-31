package solution;

public class Solution457 {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            }
            else if (nums[mid] < target) {
                start = mid;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
