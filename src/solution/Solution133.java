package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution133 {
    /*
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    public List<String> longestWords(String[] dictionary) {
        int length = 0;
        ArrayList<String> list= new ArrayList<String>();

        for (int i = 0; i < dictionary.length; i++) {
            if (list.isEmpty()) {
                length = dictionary[i].length();
                list.add(dictionary[i]);
            }
            else if (dictionary[i].length() == length) {
                list.add(dictionary[i]);
            }
            else if (dictionary[i].length() > length) {
                list.clear();
                length = dictionary[i].length();
                list.add(dictionary[i]);
            }
        }
        return list;
    }
}
