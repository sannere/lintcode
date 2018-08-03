package solution;




public class Solution1305 {
    /**
     * @param num: a non-negative integer
     * @return: english words representation
     */
    public String numberToWords(int num) {
        String words = "";
        String[] arr = initArr(words);
        System.out.println(initArr(words));
        if (num < 1000) {
            words = arr[num];
        }
        else if (num < 1000000) {
            words = arr[num / 1000] + " Thousand " + arr[num % 1000];
        }
        else if (num < 1000000000) {
            words = arr[num / 1000000] + " Million " + numberToWords(num % 1000000);
        }
        else {
            words = arr[num / 1000000000] + " Billion " + numberToWords(num % 1000000000);
        }
        return words;

    }
    private String[] initArr(String s) {
        String[] words = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
                "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] numbers = new String[1000];
        for (int num = 1; num < 1000; num ++) {
            if (num <= 20) {
                s = words[num];
            }
            else if (num < 100) {
                s = words[num / 10 + 18] + " " + words[num % 10];
            }
            else if (num < 1000) {
                s = words[num / 100] + " Hundred " + (num % 100 > 20 ? words[(num % 100) / 10 + 18] + " " + words[num % 10] : words[num % 10]);
            }
            numbers[num] = s;
        }
        numbers[0] = "Zero";
        return numbers;
    }
}
