package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList();
        if (nums == null) {
            return results;
        }

        List<Integer> permutation = new ArrayList();
        if (nums.length == 0) {
            results.add(permutation);
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length)
        nextPermute(nums, 0, results);

        return results;
    }
    private void nextPermute(int[] nums, List<List<Integer>> results) {
        if ()
    }
}
