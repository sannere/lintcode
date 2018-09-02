package solution;

public class Solution5 {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return quickSelect(n, nums, 0, nums.length - 1);
    }
    private int quickSelect(int n, int[] nums, int start, int end) {
        int pivot = nums[(end + start) / 2];
        int left = start, right = end;

        if (start == end) {
            return nums[start];
        }

        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right--;
            }
        }
        if ( n - 1 <= right) {
            return quickSelect(n, nums, start, right);
        }
        if (n - 1 >= left) {
            return quickSelect(n, nums, left, end);
        }

        return nums[right + 1];
    }
}
