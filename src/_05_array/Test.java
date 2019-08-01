package _05_array;

public class Test {

    public static void main(String[] args) {
        Array array = new Array();
        for (int i = 0; i < 100; i++) {
            array.add(i);
        }
        int size = array.size();
        for (int i = 0; i < size; i++) {
            System.out.println("element: " + array.get(i));
        }
    }


    // 全局变量，大小为 10 的数组 array，长度 len，下标 i。
    private int[] array = new int[10];
    private int len = 10;
    private int i = 0;

    // 最好时间复杂度为O(1)：数组空间足够，只需要执行添加操作
    // 最坏时间复杂度为O(n)：数组空间不足，需要扩容且遍历复制
    // 均摊时间复杂度为O(1)：n-1次的O(1)和1次的O(n)
    // 往数组中添加一个元素
    void add(int element) {
        if (i >= len) { // 数组空间不够了
            // 重新申请一个 2 倍大小的数组空间
            int[] new_array = new int[len * 2];
            // 把原来 array 数组中的数据依次 copy 到 new_array
            for (int j = 0; j < len; ++j) {
                new_array[j] = array[j];
            }
            // new_array 复制给 array，array 现在大小就是 2 倍 len 了
            array = new_array;
            len = 2 * len;
        }
        // 将 element 放到下标为 i 的位置，下标 i 加一
        array[i] = element;
        ++i;
    }

}
