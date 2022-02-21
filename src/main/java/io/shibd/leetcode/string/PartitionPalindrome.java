package io.shibd.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * @author baozi
 */
public class PartitionPalindrome {

    public static void main(String[] args) {
        System.out.println(new PartitionPalindrome().partition("aab"));
    }

    public List<List<String>> partition(String s) {
        int length = s.length();
        int[][] dep = new int[length][length];

        // 构建动态规划方法表数据
        exeDep(s, length, dep);

        // 深度搜索该数据,返回所有可以分割后的回文串
        List<List<String>> ret = new ArrayList<>();
        List<String> tmpRet = new ArrayList<>();
        dfs(dep, ret, tmpRet, 0, s);
        return ret;
    }


    private void dfs(int[][] dep, List<List<String>> ret, List<String> tmpRet, int i, String str) {
        int length = str.length();
        if (i == length) {
            ret.add(new ArrayList<>(tmpRet));
            return;
        }

        for (int j = i; j < length; j++) {
            if (dep[i][j] == 1) {
                tmpRet.add(str.substring(i, j + 1));
                dfs(dep, ret, tmpRet, j + 1, str);
                // 递归出的时候,移除tmpRet的末尾数据
                tmpRet.remove(tmpRet.size() - 1);
            }
        }
    }

    private void exeDep(String s, int length, int[][] dep) {
        // 遍历设置dep, 从左上到右下的中线开始，依次向右上遍历.
        // 遍历方式:  ["00 11 22 33 44", "01 12 23 34", "02 13 24", "03, 14", 04"]
        char[] str = s.toCharArray();
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
            }
        }
    }


}
