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

    /**
     * 1.1 冒泡排序
     * <p>
     * 只会操作两个相邻的数据进行比较，较大的往后移，一次冒泡至少会让一个元素移动到它该在的地方
     * <p>
     * 时间复杂度：最好O(n)，最坏O(n^2)，平均O(n^2)
     * 空间复杂度：O(1)，原地排序算法
     * 稳定性：是，因为只有当两个元素不相等时才进行交换
     *
     * @param a
     * @return
     */
    public int[] bubbleSort(int[] a) {
        int length = a.length;
        if (length <= 1) return a;
        for (int i = 0; i < length; i++) {
            // 提前退出冒泡循环的标志位
            boolean hasExchange = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    // 交换
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    // 表示有数据进行交换
                    hasExchange = true;
                }
            }
            // 没有数据交换，则退出
            if (!hasExchange) break;
        }
        return a;
    }

    /**
     * 1.2 插入排序
     * <p>
     * 分成未排序区间和已排序区间，从未排序区间取数据，插入到已排序区间中合适的位置，保证已排序区间是有序的
     *
     * 时间复杂度：最好O(n)，最坏O(n^2)，平均O(n^2)
     * 空间复杂度：O(1)，原地排序算法
     * 是否稳定排序算法：是，只有元素不相等才进行移动
     *
     * @param a
     * @return
     */
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

    /**
     * 1.2.1 插入排序 比较好理解的实现方式
     *
     * @param array
     * @return
     */
    public int[] insertSort(int[] array) {
        if (array == null || array.length < 2) return array;
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return array;
    }

    /**
     * 1.3 选择排序
     * <p>
     * 也分为已排序区间和无排序区间，从无排序区间中找到最小的数据，插入到已排序区间的末尾
     *
     * @param a
     * @return
     */
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
