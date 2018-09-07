package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution135 {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);

        DFS(candidates, 0, target, new ArrayList(), 0, results);

        return results;
    }
    private void DFS(int[] candidates,
                     int index,
                     int target,
                     List<Integer> combination,
                     int sum,
                     List<List<Integer>> results) {
        if (sum > target) {

            return;
        }
        if (sum == target) {
            List<Integer> result = new ArrayList(combination);
            results.add(result);

            return;
        }
        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && i > index) {
                continue;
            }
            combination.add(candidates[i]);
            DFS(candidates, i, target, combination, sum + candidates[i], results);
            combination.remove(combination.size() - 1);
        }
    }

}
