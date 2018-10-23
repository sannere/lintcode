package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution198 {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndexII(int[] A) {
        long  factorial = 1, duplicate = 1, index = 0;
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int cur = len - 1; cur >= 0; cur--) {
            if (map.containsKey(A[cur])) {
                map.put(A[cur], map.get(A[cur]) + 1);
                duplicate *= map.get(A[cur]);
            }
            else {
                map.put(A[cur], 1);
            }

            int smaller = 0;
            for (int right = cur + 1; right < len; right++) {
                if (A[right] < A[cur]) {
                    smaller++;
                }
            }

            index += smaller * factorial / duplicate;

            factorial *= (len - cur);
        }
        return index + 1;
    }

}
