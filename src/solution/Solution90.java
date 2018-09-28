package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        List<List<Integer>> results = new ArrayList();
        List<Integer> list = new ArrayList();
        if (A == null) {
            return results;
        }
        Arrays.sort(A);
        DFS(A, k, target, 0, list, results);
        return results;
    }
    private void DFS(int[] A, int k, int target, int startIndex, List<Integer> list, List<List<Integer>> results) {
        if (k == 0) {
            if (target == 0) {
                results.add(new ArrayList(list));
            }
            return;
        }

        for (int i = startIndex; i < A.length; i++) {
            if (A[i] > target) {
                break;
            }
            list.add(A[i]);
            DFS(A, k - 1, target - A[i], i + 1, list, results);
            list.remove(list.size() - 1);
        }
    }
}
