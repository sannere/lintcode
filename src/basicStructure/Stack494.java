package basicStructure;

import java.util.LinkedList;
import java.util.Queue;

public class Stack494 {
    /*
     * @param x: An integer
     * @return: nothing
     */

    Queue<Integer> q1 = new LinkedList();
    Queue<Integer> q2 = new LinkedList();


    public void push(int x) {
        q1.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        reverse(q1, q2);
        q1.poll();
        swap();
    }

    /*
     * @return: An integer
     */
    public int top() {
        if (q1.size() == 1) {
            return q1.peek();
        }
        int ele;
        reverse(q1, q2);
        ele = q1.poll();
        q2.offer(ele);
        swap();
        return ele;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return q1.size() == 0;
    }

    public void reverse(Queue<Integer> q1, Queue<Integer> q2) {//q1倒给q2
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
    }
    public void swap() {
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
}
