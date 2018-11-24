package solution;

public class Solution130 {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        for (int i = (A.length - 2) / 2; i >= 0; i--) {
            siftDown(A, i);
        }
    }
    private void siftDown(int[] A, int father) {
        int leftChild = 2 * father + 1;
        int smallerChild = leftChild;

        while (leftChild < A.length) {
            if (leftChild + 1  < A.length && A[leftChild] > A[leftChild + 1]) {
                smallerChild = leftChild + 1;
            }
            if (A[smallerChild] > A[father]) {
                break;
            }

            int temp = A[father];
            A[father] = A[smallerChild];
            A[smallerChild] = temp;

            father = smallerChild;
            leftChild = 2 * father + 1;
            smallerChild = leftChild;
        }
    }
}
