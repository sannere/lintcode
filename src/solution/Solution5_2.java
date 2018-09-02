package solution;

public class Solution5_2 {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        int print = 0;

        while (start <= end) {
            int k = start;

            for (int i = start; i < end; i++) {
                if (nums[i] > nums[end]) {
                    swap(nums, i, k);
                    k++;
                }
            }

            swap(nums, end, k);

            if (n -1 == k) {
                return nums[k];
            }
            else if (n - 1 > k) {
                start = k + 1;
            }
            else {
                end = k - 1;
            }
        }

        return -1;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
