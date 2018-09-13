package basicStructure;

import java.util.ArrayList;

public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */

    ArrayList<Integer> list = new ArrayList();
    public void push(int x) {
        list.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        if (list.size() > 0) {
            list.remove(list.size() - 1);
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        if (list.size() > 0) {
            return list.get(list.size() - 1);
        }
        return 0;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }
}

