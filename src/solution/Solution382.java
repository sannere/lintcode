package solution;

import java.util.Arrays;

public class Solution382 {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        if (S == null || S.length < 3) {
            return 0;
        }
        int left = 0, mid = 1, right = S.length - 1;
        int result = 0;

        Arrays.sort(S);

        while (left < mid && left < S.length - 2) {
            while (mid < right) {
                while (mid < right && S[left] + S[mid] <= S[right]) {
                    right--;
                }
                if (S[left] + S[mid] > S[right]) {
                    result += (right - mid);
                }
                mid++;
                right = S.length - 1;
            }
            left++;
            mid = left + 1;
        }
        return result;
    }
}
