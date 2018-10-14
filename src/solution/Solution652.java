package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution652 {
    /**
     * @param n: An integer
     * @return: a list of combination
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> results = new ArrayList();
        List<Integer> factors = new ArrayList();

        helper(n, 2, factors, results);
        return results;
    }
    private void helper(int n, int factor, List<Integer> factors, List<List<Integer>>results) {
        if (n < 2) {
            return;
        }

        for (int i = factor; i <= n / i; i++) {
            if (n % i != 0) {
                continue;
            }

            factors.add(i);
            List<Integer> combination = new ArrayList(factors);
            combination.add(n / i);
            results.add(combination);
            helper(n / i, i, factors, results);
            factors.remove(factors.size() - 1);
        }
    }
}
