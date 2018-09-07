package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution17_4 {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        DFS(nums, 0, new ArrayList(), results);
        return results;
    }
    private void DFS(int[] nums, int startindex, List<Integer> subset, List<List<Integer>> results) {
        results.add(subset);

        for (int i = startindex; i < nums.length; i++) {
            subset.add(nums[i]);
            DFS(nums, i + 1, new ArrayList(subset), results);
            subset.remove(subset.size() - 1);
        }
    }
}
