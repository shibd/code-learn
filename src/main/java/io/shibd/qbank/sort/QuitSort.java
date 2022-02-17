package io.shibd.qbank.sort;

/**
 * @Auther: baozi
 * @Date: 2019/4/8 22:14
 * @Description:
 */
public class QuitSort {

    public static void swap(int A[], int left, int right) {
        int num = A[left];
        A[left] = A[right];
        A[right] = num;
    }

    public static int pation(int A[], int left, int right) {
        int priovt = A[right];
        int i = left;
        for (int j = left; j <= right; j++) {
            // 注意这里不能等于,不然就是不稳定排序了
            if (A[j] < priovt) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, i, right);
        return i;
    }

    public static void quickSort(int A[], int left, int right) {
        if (left < right) {
            int pation = pation(A, left, right);
            quickSort(A, left, pation - 1);
            quickSort(A, pation + 1, right);
        }
    }

    public static void print(int A[]) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int A[] = { 5, 2, 9, 4, 7, 6, 1, 10, 3, 8 };// 从小到大堆排序
        quickSort(A, 0, A.length - 1);
        print(A);
    }
}
