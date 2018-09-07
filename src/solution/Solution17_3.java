package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution17_3 {
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
        DFS(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    private void DFS(int[] nums, int index, List<Integer> subset, List<List<Integer>> results) {
        if (index == nums.length) {
            results.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        DFS(nums, index + 1, subset, results);
        subset.remove(subset.size() - 1);
        DFS(nums, index + 1, subset, results);
    }
}
