package solution;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Solution17 {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        Stack<List<Integer>> stack = new Stack<>();

        List<Integer> list = new ArrayList<>();
        stack.push(list);

        if (nums.length == 0 ) {
            return new ArrayList<>(stack);
        }

        Arrays.sort(nums);

        for (int num : nums) {
            addToStack(num, stack);
        }

        return new ArrayList<>(stack);
    }

    private List<List<Integer>> addToStack(int num, Stack<List<Integer>> stack) {
        if (!stack.empty()) {
            List<Integer> list = stack.pop();
            addToStack(num, stack);
            stack.push(list);
            List<Integer> temp = new ArrayList<>(list);//复制一个list
            temp.add(num);

            stack.push(temp);
        }
        return stack;
    }
}
