package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution152 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList();
        List<Integer> combine = new ArrayList();

        if (n == 0) {
            return results;
        }
        if (k == 0) {
            results.add(combine);
            return results;
        }

        helper(n, k, 0,1, results, combine);
        return results;
    }
    private void helper(int n, int k, int count,int start, List<List<Integer>> results, List<Integer> combine) {
        if (count == k) {
            results.add(new ArrayList(combine));
            return;
        }

        for (int i = start; i <= n; i++) {
            combine.add(i);
            helper(n, k, count + 1, i + 1, results, combine);
            combine.remove(combine.size() - 1);
        }
    }
}
