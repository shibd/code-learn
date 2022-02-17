package io.shibd.leetcode.findk;

/**
 * @author baozi
 * 215. 数组中的第K个最大元素
 */
public class Solution {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int partition(int[] nums, int left, int right) {
        int i = left;
        int pivot = nums[right];
        for (int j = left; j <= right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }


    public int findKth(int[] nums, int k, int left, int right) {
        int pivot = partition(nums, left, right);
        // 第K大
        int pk = nums.length - pivot;
        // 分区后如果分区是第K个元素，说明就是第K大
        if (pk == k) {
            return nums[pivot];
        } else if (pk > k) {
            return findKth(nums, k, pivot + 1, right);
        } else {
            return findKth(nums, k, left, pivot - 1);
        }

    }

    public int findKthLargest(int[] nums, int k) {
        return findKth(nums, k, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 6, 8, 5, 10};
        System.out.println(solution.findKthLargest(nums, 3));
    }

}
