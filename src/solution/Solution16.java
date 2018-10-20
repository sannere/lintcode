package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution16 {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList();

        if (nums == null || nums.length == 0) {

            results.add(new ArrayList());
            return results;
        }

        Arrays.sort(nums);
        helper(nums, new boolean[nums.length], new ArrayList(), results);
        return results;
    }
    private void helper(int[] nums,
                        boolean[] visited,
                        List<Integer> permutation,
                        List<List<Integer>> results) {
        int len = nums.length;
        if (len == permutation.size()) {
            results.add(new ArrayList(permutation));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            permutation.add(nums[i]);
            helper(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}
