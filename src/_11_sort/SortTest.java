package _11_sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        SortTest sortTest = new SortTest();
        int[] a = {3, 6, 2, 5, 4, 1};
//        System.out.println(Arrays.toString(sortTest.bubbleSort(a)));
//        System.out.println(Arrays.toString(sortTest.insertionSort(a)));
        System.out.println(Arrays.toString(sortTest.selectionSort(a)));
    }

    public int[] bubbleSort(int[] a) {
        int length = a.length;
        if (length <= 1) return a;
        for (int i = 0; i < length; i++) {
            boolean hasExchange = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    hasExchange = true;
                }
            }
            if (!hasExchange) break;
        }
        return a;
    }

    public int[] insertionSort(int[] a) {
        int length = a.length;
        if (length <= 1) return a;
        for (int i = 1; i < length; i++) {
            int value = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 由于会走 for 循环的 j-- 操作，所以此处应该是 j+1
            a[j + 1] = value;
        }
        return a;
    }

    public int[] selectionSort(int[] a) {
        int length = a.length;
        if (length <= 1) return a;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        return a;
    }
}
