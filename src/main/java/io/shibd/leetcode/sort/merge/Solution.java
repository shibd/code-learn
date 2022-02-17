package io.shibd.leetcode.sort.merge;

/**
 * @author baozi
 */
public class Solution {

    int[] tmp;

    public int[] sortArray(int[] a) {
        tmp = new int[a.length];
        mergeSort(a, 0, a.length - 1);
        return a;
    }

    public void mergeSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    public void merge(int[] a, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int cnt = 0;
        // 合并两个子数组
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                tmp[cnt++] = a[i++];
            } else {
                tmp[cnt++] = a[j++];
            }
        }
        // 前面合并完之后，两个子数组可能剩下一个数组的数据都是大于前面你的数据，然后下面两个代码暴力的搬运即可
        while (i <= mid) {
            tmp[cnt++] = a[i++];
        }
        while (j <= right) {
            tmp[cnt++] = a[j++];
        }
        // 把排序后的数据放到原数组当中
        for (int k = 0; k < right - left + 1; ++k) {
            a[k + left] = tmp[k];
        }
    }
}
