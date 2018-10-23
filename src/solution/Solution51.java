package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution51 {
    /*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        List<Integer> results = new ArrayList<>();

        if (nums == null || nums.size() == 0) {
            return results;
        }
        int len = nums.size();
        int index = -1;
        for (int i = len - 1; i > 0; i--) {
            if (nums.get(i - 1) > nums.get(i)) {
                index = i - 1;
            }
        }

        if (index == -1) {
            Collections.reverse(nums);
        }

        for (int j = len - 1; j > index; j--) {
            if (nums.get(j) < nums.get(index)) {
                int temp = nums.get(j);
                nums.set(j, nums.get(index));
                nums.set(index, temp);
            }
        }

        Collections.swap(nums, index + 1, len - 1);
        return nums;
    }
}
