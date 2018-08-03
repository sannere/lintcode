package solution;

public class Solution1243 {
    /**
     * @param s: a string
     * @return: the number of segments in a string
     */
    public int countSegments(String s) {
        char[] arr = s.toCharArray();
        int num = 0;
        int i = 0;

        if(s.isEmpty()) {
            return 0;
        }
        while (i < arr.length && arr[i] == ' ') {
            i++;
        }
        while (i < arr.length) {

            if (arr[i] == ' ') {
                int j = i;
                while (j < arr.length && arr[i] == ' ') {
                    i++;
                }
                num++;
            }
            if (i < arr.length) {
                i++;
            }
        }
        if(arr[i- 1] == ' ') {
            num--;
        }
        return num + 1;
    }

}
