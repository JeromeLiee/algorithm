package _12_sort;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {
        SortTest sortTest = new SortTest();
//        int[] arr = {3, 2, 5, 8, 4, 1, 6, 7};
        int[] arr = {3, 1, 6, 4, 5, 2};
//        sortTest.mergeSort(arr);
        sortTest.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * // 归并排序算法, A 是数组，n 表示数组大小
     * merge_sort(A, n) {
     * merge_sort_c(A, 0, n-1)
     * }
     * <p>
     * // 递归调用函数
     * merge_sort_c(A, p, r) {
     * // 递归终止条件
     * if p >= r  then return
     * <p>
     * // 取 p 到 r 之间的中间位置 q
     * q = (p+r) / 2
     * // 分治递归
     * merge_sort_c(A, p, q)
     * merge_sort_c(A, q+1, r)
     * // 将 A[p...q] 和 A[q+1...r] 合并为 A[p...r]
     * merge(A[p...r], A[p...q], A[q+1...r])
     * }
     * <p>
     * // 合并
     * merge(A[p...r], A[p...q], A[q+1...r]) {
     * var i := p，j := q+1，k := 0 // 初始化变量 i, j, k
     * var tmp := new array[0...r-p] // 申请一个大小跟 A[p...r] 一样的临时数组
     * while i<=q AND j<=r do {
     * if A[i] <= A[j] {
     * tmp[k++] = A[i++] // i++ 等于 i:=i+1
     * } else {
     * tmp[k++] = A[j++]
     * }
     * }
     * <p>
     * // 判断哪个子数组中有剩余的数据
     * var start := i，end := q
     * if j<=r then start := j, end:=r
     * <p>
     * // 将剩余的数据拷贝到临时数组 tmp
     * while start <= end do {
     * tmp[k++] = A[start++]
     * }
     * <p>
     * // 将 tmp 中的数组拷贝回 A[p...r]
     * for i:=0 to r-p do {
     * A[p+i] = tmp[i]
     * }
     * }
     */
    public void mergeSort(int[] a) {
        realMergeSort(a, 0, a.length - 1);
    }

    private void realMergeSort(int[] a, int start, int end) {
        if (start >= end) return;
        int middle = start + ((end - start) >> 1);
        System.out.println("realMergeSort--start:" + start + ", middle:" + middle + ", end:" + end);
        realMergeSort(a, start, middle);
        realMergeSort(a, middle + 1, end);
        merge(a, start, middle, end);
    }

    private void merge(int[] a, int start, int middle, int end) {
        System.out.println("merge----------start:" + start + ", middle:" + middle + ", end:" + end);
        int length = end - start + 1;
        int[] temp = new int[length];
        int i = start;
        int j = middle + 1;
        int index = 0;
        while (i <= middle && j <= end) {
            if (a[i] < a[j]) {
                temp[index] = a[i];
                i++;
            } else {
                temp[index] = a[j];
                j++;
            }
            index++;
        }

        int newStart = i;
        int newEnd = middle;
        if (j <= end) {
            newStart = j;
            newEnd = end;
        }
        while (newStart <= newEnd) {
            temp[index] = a[newStart];
            index++;
            newStart++;
        }

        for (int k = 0; k < length; k++) {
            a[k + start] = temp[k];
        }
        System.out.println("merge----------" + Arrays.toString(temp));
    }

    /**
     * 快速排序
     * 递推公式：
     * quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1, r)
     * <p>
     * 终止条件：
     * p >= r
     * <p>
     * // 快速排序，A 是数组，n 表示数组的大小
     * quick_sort(A, n) {
     * quick_sort_c(A, 0, n-1)
     * }
     * // 快速排序递归函数，p,r 为下标
     * quick_sort_c(A, p, r) {
     * if p >= r then return
     * <p>
     * q = partition(A, p, r) // 获取分区点
     * quick_sort_c(A, p, q-1)
     * quick_sort_c(A, q+1, r)
     * }
     * <p>
     * // 原地分区函数
     * partition(A, p, r) {
     * pivot := A[r]
     * i := p
     * for j := p to r-1 do {
     * if A[j] < pivot {
     * swap A[i] with A[j]
     * i := i+1
     * }
     * }
     * swap A[i] with A[r]
     * return i
     *
     * @param a
     */
    public void quickSort(int[] a) {
        realQuickSort(a, 0, a.length - 1);
    }

    private void realQuickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(a, start, end);
        realQuickSort(a, start, pivot-1);
        realQuickSort(a, pivot + 1, end);
    }

    private int partition(int[] a, int start, int end) {
        int pivotValue = a[end];
        int i = start;
        int j = start;
        for (; j < end; j++) {
            if (a[j] < pivotValue) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        a[j] = a[i];
        a[i] = pivotValue;
        return i;
    }
}
