package io.shibd.leetcode.binarytree;

/**
 *
 * 剑指 Offer 55 - I. 二叉树的深度
 * @author baozi
 */
public class MaxDepthBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int nLeft = maxDepth(root.left);
        int right = maxDepth(root.right);
        return nLeft > right ? nLeft + 1 : right + 1;
    }

}
