package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution426 {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList();
        List<String> address = new ArrayList();

        if(s.length() <4 || s.length() > 12)
            return results;

        helper(s, address, results, 0, 1);
        return results;
    }
    private void helper(String s,
                        List<String> address,
                        List<String> results,
                        int start,
                        int count) {
        //1.address的个数已经满了
        if (count == 4) {
            //s剩余的part不能构成一部分address
            if (!isvalid(s, start, s.length() - 1)) {
                return;
            }
            //s剩余的part刚好构成一部分address
            String str = "";
            for (int i = 1; i < 3; i++) {
                str += address.get(i) + ".";
            }
            str += s.substring(start);
            results.add(str);
            return;
        }

        //2.address的个数没有满，还可以继续切
        for (int i = start; i < s.length() && s.length() - i - 1 >= 4 - count; i++) {
            if (!isvalid(s, start, i)) {
                break;
            }

            address.add(s.substring(start, i + 1));
            helper(s, address, results, i + 1, count + 1);
            address.remove(address.size() - 1);
        }
    }

    private boolean isvalid(String s, int start, int end) {
        if (s.charAt(start) == '0') {
            return start == end;
        }

        int num = 0;
        for (int i = start; i <= end; i++) {
            num = num * 10 + s.charAt(i) - '0';
        }
        return num <= 255;
    }
}
