package solution;

public class Solution62 {
    /**
     * @param nums: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        int border = nums[end];


        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > border) {
                start = mid + 1;
            }
            else if (nums[mid] < border) {
                end = mid;
            }
        }
        if (target <= border) {
            return findIndex(nums, start, nums.length - 1, target);
        }
        else {
            return findIndex(nums, 0, start, target);
        }
    }

    private int findIndex(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target) {
                end = mid;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                return mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;

    }
}
