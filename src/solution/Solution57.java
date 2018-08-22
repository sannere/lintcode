package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution57 {
    public List<List<Integer>> threeSum(int[] numbers) {
        if (numbers == null || numbers.length < 3) {
            return new ArrayList();
        }

        int target = 0, left = 1, right = numbers.length - 1;
        List<List<Integer>> results = new ArrayList();

        Arrays.sort(numbers);

        while (target < numbers.length - 2) {
            int negMin = 0 - numbers[target];
            while (left < right) {
                if (left < right && numbers[left] + numbers[right] > negMin) {
                    right--;
                }
                else if (left < right && numbers[left] + numbers[right] < negMin) {
                    left++;
                }
                else if (left < right && numbers[left] + numbers[right] == negMin) {
                    List<Integer> list = new ArrayList();
                    list.add(numbers[target]);
                    list.add(numbers[left]);
                    list.add(numbers[right]);
                    results.add(list);
                    while (left < numbers.length - 2 && numbers[left] == numbers[left + 1]) {
                        left++;
                    }
                    left++;
                    right--;
                }
            }

            while (target < numbers.length - 3 && numbers[target] == numbers[target + 1]) {
                target++;
            }
            target++;
            left = target + 1;
            right = numbers.length - 1;


        }
        return results;
    }
}
