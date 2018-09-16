package solution;

public class Solution461_2 {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        int[] temp = new int[nums.length];
        MergeSort(nums, 0, nums.length - 1, temp);
        return nums[k - 1];
    }
    private void MergeSort(int[] nums, int start, int end, int[] temp) {
        if (start == end) {
            return;
        }
        MergeSort(nums, start, (start + end) / 2, temp);
        MergeSort(nums, (start + end) / 2 + 1, end, temp);
        merge(nums, start, end, temp);
    }
    private void merge(int[] nums, int start, int end, int[] temp) {
        int leftIndex = start, midIndex = (start+ end ) / 2,
                rightIndex = (start + end) / 2 + 1, index = start;

        while (leftIndex <= midIndex && rightIndex <= end) {
            if (nums[leftIndex] < nums[rightIndex]) {
                temp[index++] = nums[leftIndex++];
            }
            else {
                temp[index++] = nums[rightIndex++];
            }
        }
        while (leftIndex <= midIndex) {
            temp[index++] = nums[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[index++] = nums[rightIndex++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }
}
