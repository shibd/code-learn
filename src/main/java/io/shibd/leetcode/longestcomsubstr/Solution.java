package io.shibd.leetcode.longestcomsubstr;

/**
 * 1143. 最长公共子序列（运行main函数查看动态二维表）
 * 看这个解释，配合状动态状态二维表：https://leetcode-cn.com/problems/longest-common-subsequence/solution/zui-chang-gong-gong-zi-xu-lie-tu-jie-dpz-6mvz/
 * @author baozi
 */
public class Solution {

    /**
     * 最长公共子序列
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] a = text1.toCharArray();
        char[] b = text2.toCharArray();
        int an = a.length;
        int bn = b.length;

        // dep[i][j] 表示 test1[0:i] 和 test2[0:j]最长公共子序列的长度
        int[][] dep = new int[an + 1][bn + 1];

        for (int i = 1; i <= an; i++) {
            int ai = i - 1;
            for (int j = 1; j <= bn; j++) {
                int bj = j - 1;
                // 如果这个数据相等，那么就从 dep[i - 1][j - 1]中增加1
                if (a[ai] == b[bj]) {
                    dep[i][j] = 1 + dep[i - 1][j - 1];
                } else {
                    // 如果不等于，就看是那个左和上哪个大了
                    dep[i][j] = Math.max(dep[i - 1][j], dep[i][j - 1]);
                }
            }
        }

        // 下面代码为输出为动态二维表数据,不用管
        System.out.print("  ");
        for (int bi = 0; bi < bn; bi++) {
            System.out.print(b[bi]);
        }
        System.out.println();
        for (int i = 0; i <= an; i++) {
            if (i == 0) {
                System.out.print(" ");
            }
            for (int j = 0; j <= bn; j++) {
                if (j == 0 && i != 0) {
                    System.out.print(a[i - 1]);
                }
                System.out.print(dep[i][j]);
            }
            System.out.println();
        }

        return dep[an][bn];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
        System.out.println(new Solution().longestCommonSubsequence("abcde", "ace"));
    }


}
