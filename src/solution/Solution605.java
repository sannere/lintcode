package solution;


public class Solution605 {
    /**
     * @param org:  a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    //给org排序
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (org == null || seqs == null || seqs.length == 0) {
            return false;
        }

        // org为从1到n的n个数，get n,即org的length, n为org中number的上限
        int n = org.length;
        //初始化order，用来存放每个number出现的次序，从1~n，所以order的使用范围为1~n，order[0]无意义
        int[] order = new int[n + 1];
        boolean[] match = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            order[org[i]] = i;
        }
        boolean emptySeq = false;
        int count = 0;
        for (int i = 0; i < seqs.length; i++) {
            if (seqs[i].length == 0) {
                emptySeq = true;
                continue;
            }
            if (seqs[i][0] > n || seqs[i][0] <= 0) {
                return false;
            }
            for (int j = 1; j < seqs[i].length; j++) {
                int num = seqs[i][j];
                int prenum = seqs[i][j - 1];
                if (num > n || num <= 0 ) {
                    return false;
                }
                if (order[num] <= order[prenum]) {
                    return false;
                }
                if (match[num] == false && order[num] == order[prenum] + 1) {
                    match[num] = true;
                    count++;
                }
            }
        }

        if (emptySeq && org.length == 0) {
            return false;
        }

        return org.length == count;
    }
}








