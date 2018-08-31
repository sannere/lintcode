package solution;

public class Solution8 {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        int len = str.length;

        if (str == null || len == 0 ) {
            return;
        }
        offset = offset % len;
        reverse(str, 0, len - 1 - offset);
        reverse(str, len - offset, len - 1);
        reverse(str, 0, len - 1);
    }
    private void reverse(char[] str, int start, int end) {
        for (; start < end; start++, end--) {
            char temp = str[end];
            str[end] = str[start];
            str[start] = temp;
        }
    }
}
