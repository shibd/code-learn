package io.shibd.leetcode.dp;

/**
 * 322. 零钱兑换
 *
 * 可以转换为完全背包问题
 * 钱币金额：价值
 * 钱币数量：无穷个
 * 总金额：重量
 * dp[j] = 置换j钱币所需要的最小数量
 *
 * @author baozi
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int length = coins.length;

        int[] dp = new int[amount + 1];

        // 初始化dp为最大, 第0个位置还是0
        int maxValue = 99999999;
        dp[0] = 0;
        for (int j = 1; j <= amount; j++) {
            dp[j] = maxValue;
        }

        for (int i = 0; i < length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
//            for (int j = 0; j <= amount; j++) {
//                System.out.print("s"+ dp[j] + " ");
//            }
//            System.out.println();
        }
        if (dp[amount] != maxValue) {
            return dp[amount];
        } else {
            return  -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{2}, 3));
    }

}
