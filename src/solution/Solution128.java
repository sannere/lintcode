package solution;

import com.sun.jdi.IntegerValue;

public class Solution128 {
    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        long hash = 0;
        for (int i = 0; i < key.length; i++) {
            hash = (hash * 33 + key[i]) % HASH_SIZE;
        }

        return (int)hash;
    }
}
