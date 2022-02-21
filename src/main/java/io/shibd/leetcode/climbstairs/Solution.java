package io.shibd.leetcode.climbstairs;

/**
 * 70. 爬楼梯问题
 *
 * 典型的动态规划问题: https://leetcode-cn.com/problems/climbing-stairs/solution/cong-zhi-jue-si-wei-fen-xi-dong-tai-gui-hua-si-lu-/
 *
 * @author baozi
 */
public class Solution {
    public int climbStairs(int n) {
        return solution2(n);
    }


    /**
     * 解法1: 使用递归的思路去做
     * 递归树：假设要爬5个楼梯，下面为递归树，重复的走法有很多。
     *                    5
     *               3         4
     *             1   2    2     3
     *                0 1  0 1  1  2
     *                            0  1
     * <img src="./climb5.jpg"/>
     *
     * 递归解法由于会有重复我路径，所以会超时
     *
     * @param n
     * @return
     */
    public int solution1(int n) {
        if (n <= 2) {
            return n;
        }
        return solution1(n - 1) + solution1(n - 2);
    }


    /**
     * 解法2: 动态规划的解题思路:
     *
     * 楼梯层数:              1  2  3  4  5
     * 到达该层数的可能步数dp:【1  2  3  5  8】
     *
     * 可推导:
     * dp[0] = 0;
     * dp[1] = 1;
     * dp[2] = 2;
     * dp[n] = dp[n - 1] + dp[n - 2];
     *
     * @param n
     * @return
     */
    public int solution2(int n) {
        if (n <= 2) {
            return n;
        }
        int [] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n - 1];
    }
}
