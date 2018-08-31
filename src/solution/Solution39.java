package solution;

import java.util.List;

public class Solution39 {
    public void recoverRotatedSortedArray(List<Integer> nums) {

        if (nums == null || nums.size() == 0) {
            return;
        }
        int i = 0;
        for (; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                break;
            }
        }
        reverse(nums, 0, i);
        reverse(nums, i + 1, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }
    private void reverse (List<Integer> nums, int start, int end) {
        while (start < end) {
            int temp;
            temp = nums.get(end);
            nums.set(end, nums.get(start)) ;
            nums.set(start, temp);
            start++;
            end--;
        }
    }
}
