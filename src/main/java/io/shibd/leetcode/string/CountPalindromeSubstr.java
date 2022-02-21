package io.shibd.leetcode.string;

/**
 * 647. 回文子串数量
 * @author baozi
 */
public class CountPalindromeSubstr {

    public int countSubstrings(String s) {
        int length = s.length();
        int[][] dep = new int[length][length];
        char[] str = s.toCharArray();

        int allSubNum = 0;

        // 遍历设置dep, 从左上到右下的中线开始，依次向右上遍历.
        // 遍历方式:  ["00 11 22 33 44", "01 12 23 34", "02 13 24", "03, 14", 04"]
        for (int n = 0; n < length; n++) {
            for (int i = 0, j = n; i < length - n; i++,j++) {

                // 相同位置的一定是回文串
                if (i == j) {
                    dep[i][j] = 1;
                }

                // 如果两个数相同
                if (i != j && str[i] == str[j]) {
                    // 如果是相邻的两个数,那么一定是回文串
                    if (i + 1 == j) {
                        dep[i][j] = 1;
                    } else {
                        dep[i][j] = dep[i + 1][j - 1];
                    }
                }

                // 记录所有回文子串数量
                if (dep[i][j] == 1) {
                    allSubNum++;
                }
            }
        }

        return allSubNum;
    }
}
