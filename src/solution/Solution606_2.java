package solution;

import java.util.PriorityQueue;

public class Solution606_2 {
    /**
     * @param nums: an integer unsorted array
     * @param k: an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : nums) {
            pq.offer(i);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
