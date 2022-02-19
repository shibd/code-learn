package io.shibd.leetcode.binarytree;


import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * @author baozi
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = midOrder(root);
        return res.get(k - 1);
    }


    // 先按顺遍历
    public List<Integer> midOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        midOrder(root, res);
        return res;
    }


    public void midOrder(TreeNode root, List<Integer> ret) {
        if (root.left != null) {
            midOrder(root.left, ret);
        }
        ret.add(root.val);
        if (root.right != null) {
            midOrder(root.right, ret);
        }
    }

}
