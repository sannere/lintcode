package solution;



public class Solution656 {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int[] ch3 = new int[ch1.length + ch2.length];
        int z = 0;
        String str = "";

        for (int i = ch2.length - 1; i >= 0; i--) {
            z = i + ch1.length;
            for (int j = ch1.length - 1; j >= 0; j--) {
                ch3[z] = ch3[z] + (ch2[i] - '0') * (ch1[j] - '0');
                if (ch3[z] > 9) {
                    ch3[z - 1] += ch3[z] / 10;
                    ch3[z] = ch3[z] % 10;
                }
                z--;
            }
        }
        for (int in : ch3) {
            str = str + in;
        }
        return str.substring(z);
    }
}

