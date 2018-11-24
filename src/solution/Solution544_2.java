package solution;

import java.util.Arrays;

public class Solution544_2 {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, k);

        return Arrays.copyOfRange(nums, 0, k);
    }
    private void quickSort(int[] A, int start, int end, int k) {
        if (start >= end || start >= k) {
            return;
        }
        int pivot = A[(end + start) / 2];

        int left = start, right = end;

        while (left <= right) {
            while (left <= right && A[left] > pivot) {
                left++;
            }
            while (left <= right && A[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(A, start, right, k);
        quickSort(A, left, end, k);
    }
}
