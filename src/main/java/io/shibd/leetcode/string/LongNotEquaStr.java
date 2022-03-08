package io.shibd.leetcode.string;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * @author baozi
 */
public class LongNotEquaStr {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];
        dp[0] = 1;
        System.out.print(dp[0] + " ");

        int max = dp[0];
        for (int j = 1; j < str.length; j++) {

            int i = findLastEqusStr(str, j);
            if (dp[j - 1] < j - i) {
                dp[j] = dp[j - 1] + 1;
            } else {
                dp[j] = j - i;
            }
            if (dp[j] > max) {
                max = dp[j];
            }
            System.out.print(dp[j] + " ");
        }
        System.out.println();
        return max;
    }

    public int findLastEqusStr(char[] str, int j) {
        for (int i = j - 1; i >= 0; i--) {
            if (str[i] == str[j]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LongNotEquaStr longNotEquaStr = new LongNotEquaStr();
        System.out.println(longNotEquaStr.lengthOfLongestSubstring(" "));
    }
}
