package io.shibd.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * @author baozi
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            preorderTraversal(root, result);
        }
        return result;
    }

    public void preorderTraversal(TreeNode root, List<Integer> result) {
        result.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left, result);
        }
        if (root.right != null) {
            preorderTraversal(root.right, result);
        }
    }

}