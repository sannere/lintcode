package solution;

import java.util.*;

public class Solution545 {

    PriorityQueue<Integer> pq;
    int size;
    /*
     * @param k: An integer
     */
    public Solution545(int k) {
        this.size = k;
        pq = new PriorityQueue<>();
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        pq.offer(num);
        if (pq.size() > size) {
            pq.poll();
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        List<Integer> results= new ArrayList<>(pq);
        Collections.sort(results, Collections.reverseOrder());
        return results;
    }
}
