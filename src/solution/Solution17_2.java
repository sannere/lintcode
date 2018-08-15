package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution17_2 {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null) {
            return results;
        }

        results.add(new ArrayList<>());
        if (nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        dfs(results, new ArrayList<>(), nums,0);


        return results;
    }
    private void dfs (List<List<Integer>> results, List<Integer> subset, int[] nums, int index) {
        if (index >= nums.length ) {
            if (!subset.isEmpty()) {
                results.add(new ArrayList<>(subset));
            }

        }
        else {
        //    List<Integer> temp = new ArrayList<>(subset);
            subset.add(nums[index]);

            dfs(results, subset, nums,  index +1);

            subset.remove(subset.size() - 1);
            dfs(results, subset, nums, index + 1);
        }
    }
}
