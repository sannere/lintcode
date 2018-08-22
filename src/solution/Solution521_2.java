package solution;

import java.util.Arrays;

public class Solution521_2 {
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int num = 1;
        int fast = 0, slow = 0;

        while (fast < nums.length) {
            if (nums[fast]!= nums[slow]) {
                slow++;
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                num++;
            }
            fast++;
        }
        return num;
    }
}
