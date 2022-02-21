package io.shibd.leetcode.dp;

/**
 * 416. 分割等和子集
 * <p>
 * 0-1背包最基础版
 *
 * @author baozi
 */
public class CallPartition {

    public boolean canPartition(int[] nums) {
        return solution2(nums);
    }


    /**
     * <pre>
     * 背包问题：看数组中是否存在加起来为sum/2的数.
     * 背包容量（V） = sum/2
     * 每一个物品只能装一次,如果出现背包中重量等于sum/2则为true else false
     * dp[i]表示能否填满容量为i的背包
     * 状态转移方程为 dp[i] = dp[i-1] || nums[i]+dp[i-nums[j]]
     * 举例:v = sum/2 = 11   nums = [1,5,11,5]  1是true 0 是false
     * 哨兵
     *            0  1  2  3  4  5  6  7  8  9  10  11
     * 哨兵nums[0] 1  0  0  0  0  0  0  0  0  0   0   0
     * 1  nums[1] 1  1  0  0  0  0  0  0  0  0   0   0
     * 5  nums[2] 1  1  0  0  0  1  1  0  0  0   0   0
     * 11 nums[3] 1  1  0  0  0  1  1  0  0  0   0   1
     * 5  nums[4] 1  1  0  0  0  1  1  0  0  0   0   1
     * 二维表格处理问题
     * </pre>
     *
     * @param nums
     * @return
     */
    public boolean solution1(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 奇数一定不能划分
        if (sum % 2 != 0) {
            return false;
        }

        int num = sum / 2;
        int length = nums.length;
        // 多new一行和一列，利用哨兵来优化处理，统一处理逻辑
        boolean dp[][] = new boolean[length + 1][num + 1];

        // 哨兵的第一行第一列设置为true
        dp[0][0] = true;

        for (int i = 1; i <= length; i++) {

            // 该物品不放入计算
            for (int j = 0; j <= num; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }

            // 该物品放入计算.重点: 这里j < num-nums[i]，说明，当i这个物品放入之后,也不会超过num
            // i最大不能装超过上一个装过后的 + num[i]，一方面防止了数组越界，另一方面也映射了业务需求。
            for (int j = 0; j <= num - nums[i - 1]; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j + nums[i - 1]] = true;
                }
            }
        }

        return dp[length][num];
    }

    /**
     * <pre>
     * 利用一维数组存放动态规划表
     *            哨兵
     *             0  1  2  3  4  5  6  7  8  9  10  11
     * 哨兵 nums[0] 1  0  0  0  0  0  0  0  0  0   0   0
     *  1  nums[1] 1  1  0  0  0  0  0  0  0  0   0   0
     *  5  nums[2] 1  1  0  0  0  1  1  0  0  0   0   0
     *  11 nums[3] 1  1  0  0  0  1  1  0  0  0   0   1
     *  5  nums[4] 1  1  0  0  0  1  1  0  0  0   0   1
     *
     *  根据这个表推演，后面放入的时候，如果第i个物品放了能到重量5，那么第i + 1的物品肯定可以通过不放到达i + 5
     *  也就是说，可以省去存储不放的即可。
     *  可以看上面二维数组，实际上是可以打平的。
     *
     *
     *  在处理第i个物品时, 我们可以倒着处理，只处理需要放的情况（不放的情况，在 i - 1个物品已经设置可以到达）
     *
     *  dp[i] = dp[i] + dp[i - num]
     *  dp[i] 表示到达了该重量多少次
     *
     *             0  1  2  3  4  5  6  7  8  9  10  11
     *     nums[0] 1  0  0  0  0  0  0  0  0  0   0   0
     * </pre>
     *
     * @param nums
     * @return
     */
    public boolean solution2(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) return false;//整数相加不可能得小数
        int W = sum / 2;//相当于背包总承重
        int[] dp = new int[W + 1];
        dp[0] = 1;


        for (int i = 0; i < nums.length; i++) {
            for (int j = W; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[W] != 0;
    }

    public static void main(String[] args) {
        System.out.println(new CallPartition().canPartition(new int[]{1, 5, 11, 5}));
    }

}
