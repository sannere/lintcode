package solution;

public class Solution62_2 {
    /**
     * @param nums:   an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target > nums[end] && nums[mid] < nums[end] ||
                    target <= nums[end] && nums[mid] > nums[end]) {//target and nums[mid] are at the different sides of pivot

                if (target > nums[end]) {//target is at the left of mid
                    end = mid;
                }
                else {//target is at the left of mid
                    start = mid + 1;
                }
            }
            else {//sorted array, classical Binary Sort
                if (nums[mid] > target) {
                    end = mid;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }

        return -1;
    }
}

