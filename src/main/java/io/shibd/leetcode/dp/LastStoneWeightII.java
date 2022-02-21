package io.shibd.leetcode.dp;

/**
 * 1049. 最后一块石头的重量 II
 *
 * @author baozi
 */
public class LastStoneWeightII {

    //转换成01背包问题，求两堆石头的最小差值。由于石头总和为sum.则问题转换成了
    //背包最多装sum / 2的石头,
    //stones数组里有一大堆石头。求如何装能装下最多重量石头。
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int num : stones) {
            sum += num;
        }

        int num = sum / 2;
        int length = stones.length;
        // 多new一列，利用哨兵来优化处理，统一处理逻辑
        boolean dp[][] = new boolean[length][num + 1];

        // 处理第一行
        dp[0][0] = true;
        if (stones[0] <= num) {
            dp[0][stones[0]] = true;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= num; j++) {
                // 放不下的情况
                if (j < stones[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i]];
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= num; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        for (int j = num; j >= 0; j--) {
            if (dp[length - 1][j]) {
                return sum - 2 * j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new LastStoneWeightII().lastStoneWeightII(new int[]{1, 2});
        System.out.println(i);
    }
}
