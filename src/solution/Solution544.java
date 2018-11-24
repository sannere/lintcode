package solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution544 {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : nums) {
            minHeap.offer(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];

        while (k > 0) {
            result[--k] = minHeap.poll();
        }
        return result;
    }
}
