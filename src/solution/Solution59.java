package solution;

import java.util.Arrays;

public class Solution59 {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        Arrays.sort(numbers);

        for (int left = 0; left < numbers.length - 2; left++) {
            int mid = left + 1;
            int right = numbers.length - 1;
        }
    }

}
