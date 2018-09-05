public class Test {
    public static void main(String args[]) {
        String s = "abcdefg";

        for (int i = 0; i < s.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String nextWord = s.substring(0, i) + ch + s.substring(i + 1);
                System.out.println("i:" + i + "  nextword：" + nextWord);
            }
        }


    }
}