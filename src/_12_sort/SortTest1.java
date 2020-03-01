package _12_sort;

import java.util.Arrays;

public class SortTest1 {

    public static void main(String[] args) {
        SortTest1 test = new SortTest1();
        int[] array = {5, 1, 4, 2, 3, 6, 9, 7, 8, 12, 10, 11};
        System.out.println(Arrays.toString(test.mergeSort(array)));

        int[] array2 = {5, 1, 4, 2, 3, 6, 9, 7, 8, 12, 10, 11};
        System.out.println(Arrays.toString(test.quickSort(array2)));

        int[] array3 = {3, 2, 1, 5, 6, 4};
        System.out.println(test.findKthLargest(array3, 2));

        int[] array4 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(test.findKthLargest(array4, 4));

        int[] array5 = {3, 4, 5, 1, 2};
        System.out.println(test.findSmallest(array5));
    }

    public int[] mergeSort(int[] array) {
        realMergeSort(array, 0, array.length - 1);
        return array;
    }

    private void realMergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = start + ((end - start) >> 1);
        realMergeSort(array, start, middle);
        realMergeSort(array, middle + 1, end);
        merge(array, start, middle, end);
    }

    private void merge(int[] array, int start, int middle, int end) {
        int length = end - start + 1;
        int[] tempArray = new int[length];
        int i = start;
        int j = middle + 1;
        int index = 0;
        while (i <= middle && j <= end) {
            if (array[i] < array[j]) {
                tempArray[index++] = array[i++];
            } else {
                tempArray[index++] = array[j++];
            }
        }

        int newStart = i;
        int newEnd = middle;
        if (j <= end) {
            newStart = j;
            newEnd = end;
        }
        while (newStart <= newEnd) {
            tempArray[index++] = array[newStart++];
        }

        for (int k = 0; k < length; k++) {
            array[start + k] = tempArray[k];
        }
    }

    public int[] quickSort(int[] array) {
        realQuickSort(array, 0, array.length - 1);
        return array;
    }

    private void realQuickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int pivot = partition(array, start, end);
        realQuickSort(array, start, pivot - 1);
        realQuickSort(array, pivot + 1, end);
    }

    private int partition(int[] array, int start, int end) {
        int pivotValue = array[end];
        int i = start;
        int j = start;
        for (; j < end; j++) {
            if (array[j] < pivotValue) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        array[j] = array[i];
        array[i] = pivotValue;
        return i;
    }

    /**
     * 找出第K大元素
     * <p>
     * 输入: [3,2,1,5,6,4] 和 k = 2，输出 5
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4，输出: 4
     *
     * @param array
     * @return
     */
    private int findKthLargest(int[] array, int k) {
        int index = realFindKthLargest(array, 0, array.length - 1, array.length + 1 - k);
        return array[index];
    }

    private int realFindKthLargest(int[] array, int start, int end, int k) {
        int pivotValue = array[end];
        int i = start;
        int j = start;
        for (; j < end; j++) {
            if (array[j] < pivotValue) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        array[j] = array[i];
        array[i] = pivotValue;

        if (i + 1 < k) {
            return realFindKthLargest(array, i + 1, end, k);
        } else if (i + 1 > k) {
            return realFindKthLargest(array, start, i - 1, k);
        } else {
            return i;
        }
    }

    public int findSmallest(int[] array) {

        int low = 0;
        int high = array.length - 1;
        int middle = low + ((high - low)>>1);
        while (low <= high ) {

        }
        return 0;
    }

}
