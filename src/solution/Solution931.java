package solution;

public class Solution931 {
    /**
     * @param nums: the given k sorted arrays
     * @return: the median of the given k sorted arrays
     */

    public double findMedian(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = countNums(nums);

        if (count % 2 != 0) {
            return getKthNum(nums, (count + 1)/ 2);
        }
        return getKthNum(nums, count / 2) / 2 + getKthNum(nums, count / 2 + 1) / 2;
    }
    private int countNums(int[][] nums) {
        int count = 0;
        for (int[] arr : nums) {
            count += arr.length;
        }
        return count;
    }
    private double getKthNum(int[][] nums, int k) {
        int start = 0, end = 0, mid, count;

        for (int[] arr : nums) {
            if (arr.length != 0) {
                start = Math.min(start, arr[0]);
                end = Math.max(end, arr[arr.length - 1]);
            }
        }

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            count = countSE(nums, mid);//smaller or equal to pivot

            if (count >= k) {
                end = mid;
            }
            else {
                start = mid;
            }
        }

        if (countSE(nums, start) >= k) {
            return start;
        }
        return end;
    }
    private int countSE(int[][] nums, int mid) {
        int count = 0;
        for (int[] arr : nums) {
            count += countSE_arr(arr, mid);
        }
        return count;
    }
    private int countSE_arr(int[] arr, int pivot) {
        if (arr.length == 0) {
            return 0;
        }
        int start = 0, end = arr.length - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= pivot) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (arr[end] <= pivot) {
            return end + 1;
        }
        if (pivot < arr[start]) {
            return 0;
        }
        return start + 1;
    }
}
