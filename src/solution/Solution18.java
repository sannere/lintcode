package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList();
        List<Integer> subset = new ArrayList();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        helper(nums, 0, results, subset);
        return results;
    }
    private void helper(int[] nums, int start, List<List<Integer>> results, List<Integer> subset) {
        results.add(new ArrayList(subset));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            helper(nums, i + 1, results, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
