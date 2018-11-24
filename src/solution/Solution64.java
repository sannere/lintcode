package solution;

public class Solution64 {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if (A == null || B == null) {
            return ;
        }

        int[] copyA = new int[m];
        for (int i = 0; i < m; i++) {
            copyA[i] = A[i];
        }
        int a = 0, b = 0, index = 0;
        while (a < m && b < n) {
            if (copyA[a] < B[b]) {
                A[index++] = copyA[a++];
            }
            else {
                A[index++] = B[b++];
            }
        }

        while (a < m) {
            A[index++] = copyA[a++];
        }
        while (b < n) {
            A[index++] = B[b++];
        }
    }
}
