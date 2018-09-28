package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution153 {
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
                     int index,
                     List<Integer> combination,
                     List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList(combination));
            return;
        }
        if (index == num.length || target < 0) {
            return;
        }
        combination.add(num[index]);
        DFS(num, target - num[index], index + 1, combination, results);
        combination.remove(combination.size() - 1);
        while (index < num.length - 1 && num[index] == num[index + 1]) {
            index++;
        }
        DFS(num, target, index + 1, combination, results);
    }
}
