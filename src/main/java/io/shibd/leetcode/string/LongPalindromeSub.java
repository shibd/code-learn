package io.shibd.leetcode.string;

/**
 * 5. 最长回文子串
 *
 * @author baozi
 */
public class LongPalindromeSub {

    /**
     * 该实现只需要判断动态规划表的右上部分即可.参考图
     * <img src="./longsplindrome.jpg"/>
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        int length = s.length();
        int[][] dep = new int[length][length];
        char[] str = s.toCharArray();

        int maxLen = 0;
        int begin = 0;
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

                // 记录最长的回文串
                int tmpLen = j - i + 1;
                if (dep[i][j] == 1 && tmpLen > maxLen) {
                    maxLen = tmpLen;
                    begin = i;
                }
            }
        }

//        print(length, dep);
        return s.substring(begin, begin + maxLen);
    }

    private void print(int length, int[][] dep) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(dep[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        System.out.println(new LongPalindromeSub().longestPalindrome("babad"));
        System.out.println();
        System.out.println(new LongPalindromeSub().longestPalindrome("a"));
        System.out.println();
        System.out.println(new LongPalindromeSub().longestPalindrome("aaaa"));
        System.out.println();
    }

}
