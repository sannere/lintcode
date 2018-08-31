package solution;

public class Solution254 {
    /**
     * @param n: An integer
     * @return: The sum of a and b
     */
    public int dropEggs(int n) {
        int m;
        long floor = n;
        m = (int)(Math.sqrt(2 * floor + 0.25) -0.5);

        return n > (m * (m + 1)) / 2 ? m + 1 : m;
    }
}
