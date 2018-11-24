package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution486 {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();


        return merge(arrays, 0, arrays.length - 1);
    }

    private int[] merge (int[][] arrays, int start, int end) {
        if (start == end) {
            return arrays[start];
        }

        int mid = (start + end) / 2;
        int[] left = merge(arrays, start, mid);
        int[] right = merge(arrays, mid + 1, end);

        return mergeHelper(left, right);
    }

    private int[] mergeHelper(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int l = 0, r = 0, index = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                result[index++] = left[l++];
            }
            else {
                result[index++] = right[r++];
            }
        }

        while (l < left.length) {
            result[index++] = left[l++];
        }
        while (r < right.length) {
            result[index++] = right[r++];
        }

        return result;
    }
}
