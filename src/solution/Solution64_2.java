package solution;

public class Solution64_2 {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if (A == null || B == null) {
            return;
        }
        int a = m - 1, b = n - 1, index = m + n - 1;

        while (a >= 0 && b >= 0) {
            if (A[a] > B[b]) {
                A[index--] = A[a--];
            }
            else {
                A[index--] = B[b--];
            }
        }

        while (a >= 0) {
            A[index--] = A[a--];
        }
        while (b >= 0) {
            A[index--] = B[b--];
        }
    }
}
