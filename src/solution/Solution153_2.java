package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution153_2 {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList();
        List<Integer> combination = new ArrayList();

        if (num == null || num.length == 0) {
            return results;
        }

        Arrays.sort(num);
        DFS(num, target, 0, combination, results);
        return results;
    }
    private void DFS(int[] num,
                     int target,
                     int startIndex,
                     List<Integer> combination,
                     List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList(combination));
        }

        for (int i = startIndex; i < num.length; i++) {
            if (i > startIndex && num[i] == num[i - 1]) {
                continue;
            }
            if (num[i] > target) {
                break;
            }
            combination.add(num[i]);
            DFS(num, target - num[i], i + 1, combination, results);
            combination.remove(combination.size() - 1);
        }
    }
}
