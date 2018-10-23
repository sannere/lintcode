package solution;

public class Solution197 {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        long index = 0, fac = 1;
        int len = A.length;

        for (int cur = len - 1; cur >= 0; cur--) {
            int smaller = 0;
            for (int right = cur + 1; right < len; right++) {
                if (A[right] < A[cur]) {
                    smaller++;
                }
            }

            index += smaller * fac;

            fac *= (len - cur);
        }
        return index + 1;
    }
}
