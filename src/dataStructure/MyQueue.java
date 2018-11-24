package dataStructure;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        pushStack.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (popStack.empty()) {
            swap();
        }

        return popStack.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        if (popStack.empty()) {
            swap();
        }

        return popStack.peek();
    }
    private void swap() {
        while (!pushStack.empty()) {
            popStack.push(pushStack.pop());
        }
    }
}
