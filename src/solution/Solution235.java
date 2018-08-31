package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution235 {
    /**
     * @param num: An integer
     * @return: an integer array
     */
    public List<Integer> primeFactorization(int num) {
        if (num == 1) {
            return new ArrayList<>(1);
        }

        List<Integer> results = new ArrayList();
        int i = 2, up = (int) Math.sqrt(num);;

        while (i < up ) {
            if (num % i == 0) {
                results.add(i);
                num = num / i;
                up = (int) Math.sqrt(num);
            }
            else {
                i++;
            }
        }
        if (num > 1) {
            results.add(num);
        }

        return results;
    }
}
