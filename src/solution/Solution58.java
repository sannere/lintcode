package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution58 {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 4) {
            return new LinkedList<>();
        }
        List<Integer> quadruplet = new LinkedList();
        List<List<Integer>> results = new LinkedList();
        Arrays.sort(numbers);

        int a = 0, length = numbers.length;
        int b = length - 3, c = length - 2, d = length - 1;

        while (d >= 3) {
            while (c >= 2) {
                int sum = numbers[a] + numbers[b] + numbers[c] + numbers[d];
                if (a > 0 && numbers[a] == numbers[ a- 1]) {
                    continue;
                }
                if (sum < target) {
                    a++;
                    continue;
                }
                if (sum == target) {
                    quadruplet.add(numbers[a]);
                    quadruplet.add(numbers[b]);
                    quadruplet.add(numbers[c]);
                    quadruplet.add(numbers[d]);
                    results.add(quadruplet);
                }
            }
        }
    }
}
