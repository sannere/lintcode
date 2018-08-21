package solution;

import java.util.HashSet;

public class Solution521 {
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet();
        int i = 0,dedup = 0, len = nums.length;

        while (i < nums.length - dedup) {
            if (set.contains(nums[i])) {
                dedup++;
                int temp = nums[len - dedup];
                nums[i] = temp;
            }
            else {
                i++;
            }

        }

        return set.size();
    }
}
