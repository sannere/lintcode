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

        int length = numbers.length;
        int b = length - 3, c = length - 2, d = length - 1;

        for (int a = 0; a < length - 3; a++) {
            if (a > 0 && numbers[a] == numbers[a - 1]) {
                continue;
            }
            if (numbers[a] + numbers[b] + numbers[c] + numbers[d] < target) {
                continue;
            }
            if (numbers[a] + numbers[b] + numbers[c] + numbers[d] == target) {


                continue;
            }

            for (b = a + 1; b < length - 2; b++) {
                if (b > a + 1 && numbers[b] == numbers[b - 1]) {
                    continue;
                }

                c = b + 1;
                while (c < d) {
                    int sum = numbers[a] + numbers[b] + numbers[c] + numbers[d];
                    if (c > b + 1 && numbers[c] == numbers[c - 1]) {
                        c++;
                        continue;
                    }
                    if (sum == target) {
                        quadruplet.add(numbers[a]);
                        quadruplet.add(numbers[b]);
                        quadruplet.add(numbers[c]);
                        quadruplet.add(numbers[d]);
                        results.add(new LinkedList(quadruplet));
                        quadruplet.clear();
                        c++;
                        d--;
                        continue;
                    }
                    if (sum < target) {
                        c++;
                        continue;
                    }
                    d--;
                }

            }

        }
        return results;
    }
}
