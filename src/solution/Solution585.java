package solution;

import java.util.Arrays;

public class Solution585 {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            int temp = mid + 1;
            while (temp <= end && nums[temp] == nums[mid]) {
                temp++;
            }
            if (temp == end + 1) {
                end = mid;
                continue;
            }
            if (nums[mid] > nums[temp]) {
                end = mid;
            }
            if (nums[mid] < nums[temp]) {
                start = mid;
            }
        }

        if (nums[start] > nums[end]) {
            return nums[start];
        }
        return nums[end];

    }

}
