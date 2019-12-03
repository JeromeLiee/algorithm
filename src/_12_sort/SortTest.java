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
        System.out.println("------------------");
//        int[] arr2 = {3, 2, 1, 5, 6, 4};
        int[] arr2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(sortTest.findKthLargest(arr2, 4));
    }

    /**
     * 2.1 归并排序算法
     * <p>
     * 把数组[p...r]分成两个区间，分别对其进行排序，然后合并，采用分治思想。
     * <p>
     * 递推公式：
     * merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
     * <p>
     * 终止条件：
     * p >= r 不用再继续分解
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
     * 2.2 快速排序
     * <p>
     * 一个数组[p...r]，找一个分区点q，小于该分区点的元素放在左边，大于则放在右边，递归去分区
     * <p>
     * 递归公式为：
     * quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1… r)
     * <p>
     * 终止条件为：
     * p >= r
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
        realQuickSort(a, start, pivot - 1);
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

    /**
     * 3. 数组中的第K个最大元素
     * <p>
     * LeetCode 215
     * <p>
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 示例 1:
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * <p>
     * 示例 2:
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * <p>
     * 说明:
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     */
    public int findKthLargest(int[] nums, int k) {
        return nums[partitionArr(nums, 0, nums.length - 1, nums.length + 1 - k)];
    }

    private int partitionArr(int[] a, int start, int end, int k) {
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
        if (i + 1 == k) return i;
        if (i + 1 < k) {
            return partitionArr(a, i + 1, end, k);
        } else {
            return partitionArr(a, start, i - 1, k);
        }
    }
}
