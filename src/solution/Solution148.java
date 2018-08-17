package solution;

public class Solution148 {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    //三指针
    public void sortColors(int[] nums) {
        int start = 0, mid = 0, end = nums.length - 1;

        while (mid <= end) {
            if (nums[mid] == 2) {
                swap(nums, mid, end);
                end--;
                continue;
            }
            if (nums[mid] == 0) {
                swap(nums, start, mid);
                start++;
                mid++;
                continue;
            }
            if (nums[mid] == 1) {
                mid++;
                continue;
            }
        }
    }


    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
