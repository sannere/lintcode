package solution;

public class Solution606 {
    /**
     * @param nums: an integer unsorted array
     * @param k: an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int pivot = nums[start + (end - start) / 2];
        int left = start, right = end;

        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        if (k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        if (k - 1 >= left) {
            return quickSelect(nums, left, end, k);
        }
        return nums[k - 1];
    }
}
