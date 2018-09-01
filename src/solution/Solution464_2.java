package solution;

public class Solution464_2 {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length, temp);
    }
    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        mergeSort(A, start, (start + end) / 2, temp);
        mergeSort(A, (start + end) / 2 + 1, end, temp);
        merge(A, start, end, temp);
    }
    private void merge(int[] A, int start, int end, int[] temp) {
        int leftIndex = start, middle = (start + end) / 2;
        int rightIndex = middle + 1;
        int tempIndex = start;

        while (leftIndex <= middle && rightIndex <= end) {
            if (A[leftIndex] < A[rightIndex]) {
                temp[tempIndex++] = A[leftIndex++];
            }
            else {
                temp[tempIndex++] = A[rightIndex++];
            }
        }
        while (leftIndex <= middle) {
            temp[tempIndex++] = A[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[tempIndex++] = A[rightIndex++];
        }

        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }

    }
}
