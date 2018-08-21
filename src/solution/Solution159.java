package solution;

public class Solution159 {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        int border = nums[end];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > border) {
                start = mid;
            }
            else if (nums[mid] < border) {
                end = mid;
            }
        }

        if (nums[start] < border) {
            return nums[start];
        }
        return nums[end];

    }
}
