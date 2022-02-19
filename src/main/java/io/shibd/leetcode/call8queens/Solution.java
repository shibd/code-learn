package io.shibd.leetcode.call8queens;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * @author baozi
 */
public class Solution {

    private List<List<String>> ret = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 结果集，每一个Integer代表一种解法
        int[] result = new int[n];
        callNQueens(result, n, 0);
        return ret;
    }

    /**
     *
     * @param result 放置后的数据, 下标代表行，结果代表列
     * @param n
     * @param row 行
     */
    private void callNQueens(int[] result, int n, int row) {
        if (row == n) {
            List<String> trans = trans(result);
            ret.add(trans);
            return;
        }

        for (int column = 0; column < n; column++) {
            if (isOk(result, n, row, column)) {
                result[row] = column;
                callNQueens(result, n, row + 1);
            }
        }
    }

    /**
     * 判断第row行放置第column列是否合适。
     * 1. 由于我们是从第一行开始放的，所以不用考察row行中是否有皇后
     * 2. 我们需要每次考察column列中，上面所有行是否有棋子，所以只需要row慢慢减，判断ret[row]是否等于column就可以。
     * 3. 左对角线
     * 4. 右对角线
     * @param result
     * @param n
     * @param row
     * @param column
     * @return
     */
    private boolean isOk(int[] result, int n, int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;
        for (int currentRow = row - 1; currentRow >= 0; currentRow--) {
            //column列中是否有皇后(currentRow是否等于column)
            if (result[currentRow] == column) {
                return false;
            }
            // 左上是否有皇后
            if (leftUp >= 0 && result[currentRow] == leftUp) {
                return false;
            }
            // 右上是否有皇后
            if (rightUp < n && result[currentRow] == rightUp) {
                return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    private List<String> trans(int[] result ) {
        List<String> ret = new ArrayList<>();
        for(int row = 0; row < result.length; row++) {
            StringBuilder rowRet = new StringBuilder();
            for (int column = 0; column < result.length; column++) {
                if (result[row] == column) {
                    rowRet.append("Q");
                } else {
                    rowRet.append(".");
                }
            }
            ret.add(rowRet.toString());
        }
        return ret;
    }


    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("\n\n");
        }
    }


}
