package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    private Queue<Integer> window;
    private int size;
    private double sum = 0;

    /*
     * @param size: An integer
     */
    public MovingAverage(int size) {
        window = new LinkedList<>();
        this.size = size;
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        if (size == 0) {
            return 0;
        }
        if (window.size() == size) {
            sum -= window.poll();
        }
        window.offer(val);
        sum += val;
        return sum / window.size();
    }
}
