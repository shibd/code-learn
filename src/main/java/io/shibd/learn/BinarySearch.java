package io.shibd.learn;

/**
 * 在一个没有重复元素的有序数组中，查找小于等于给定值的最大元素
 *
 * [10 33 50 80]
 *
 * 44
 *
 * 二分查找
 * @author baozi
 */
public class BinarySearch {

    public static int find(int[] nums, int f, int left, int right) {
        int mind = (right - left) / 2;
        if (nums[mind] == f) {
            return nums[mind - 1];
        }
        if (nums[mind] > f) {
            find(nums, f, left, mind);
        }
        if (nums[mind] < f) {
            if (mind == 0 || nums[mind + 1] > f) {
                return nums[mind];
            }
            find(nums, f, mind - 1, right);
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{10, 33, 50, 80};

        System.out.println(find(nums, 44, 0, nums.length - 1));

    }
}
