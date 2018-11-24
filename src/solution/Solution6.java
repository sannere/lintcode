package solution;

public class Solution6 {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }

        int a = 0, b = 0, index = 0;
        int[] result = new int[A.length + B.length];

        while (a < A.length && b < B.length) {
            if (A[a] < B[b]) {
                result[index++] = A[a++];
            }
            else {
                result[index++] = B[b++];
            }
        }

        while (a < A.length) {
            result[index++] = A[a++];
        }
        while (b < B.length) {
            result[index++] = B[b++];
        }
        return result;
    }
}
