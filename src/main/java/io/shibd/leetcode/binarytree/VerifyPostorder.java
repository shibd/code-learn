package io.shibd.leetcode.binarytree;

import java.util.Stack;

/**
 * 剑指 Offer 33. 校验二叉搜索树的后序遍历序列
 *
 * @author baozi
 */
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    // 递归方式处理
    boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int root = postorder[j];
        int p = i;
        while (postorder[p] < root) p++;
        int m = p;
        while (postorder[p] > root) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    //单调栈方式处理 - 还未很理解
    public boolean stack(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }

}
