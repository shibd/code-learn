package io.shibd.leetcode.dp;

/**
 * <pre>
 *
 * 0-1背包求最大价值问题
 *
 * 其他两题都是0-1背包求最值是否能达到，该题要加上价值，求最大价值。
 *
 * 问：有一个背包，最大承重为bagW，有一组物品，每个物品重量为w[], 价值为value[]，求可装的最大价值。
 *
 * bagW = 4
 * w[] =    {1 3 4}
 * value = {15 20 30}
 *
 * 推导动态方法表
 *            [0]  [1]  [2]  [3]  [4]
 * 1(15) [0]   0   15   15   15   15
 * 3(20) [1]   0   15   15   20   35
 * 4(30) [2]   0   15   15   20   35
 *
 * 动态转移方程:
 * 1. 当背包放不下：第 i - 1个的最大价值
 * 2. 当背包放得下: 背包容量足够拿第i个物品,可拿可不拿：
 * - 拿了最大价值是前i-1个物品扣除第i个物品的 重量的最大价值加上i个物品的价值
 * - 不拿就是前i-1个物品的最大价值,两者进行比较取较大的
 *
 * 背包放不下: dp[i][j] = dp[i - 1][j];
 * 背包放的下: dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
 *
 * </pre>
 *
 * @author baozi
 */
public class Knapsack01 {

    public int solution(int bagW, int[] w, int[] value) {

        int[][] dp = new int[w.length][bagW + 1];

        // 处理第一行
        for (int j = w[0]; j <= bagW; j++) {
            dp[0][j] = value[0];
        }

        for (int i = 1; i < w.length; i++) {
            for (int j = 0; j <= bagW; j++) {
                // 背包放不下
                if (j < w[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 比较放还是不放的最大价值(注意，这里不会数组越界，j - w[i]，因为当j < w[i]的时候，不会进到这个分支)
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - w[i]]);
                }
            }
        }

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j <= bagW; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[w.length - 1][bagW];
    }

    public static void main(String[] args) {
        new Knapsack01().solution(4, new int[]{1, 3, 4}, new int[]{15, 20, 30});
    }
}
