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

        Test test = new Test();
        int[][] arrays = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] arrays2 = {{1, 1}};
        System.out.println("1-searchMatrix:" + test.searchMatrix(arrays, 3));
        System.out.println("1-searchMatrix:" + test.searchMatrix(arrays, 30));
        System.out.println("1-searchMatrix:" + test.searchMatrix(arrays2, 2));

//        int[] array3 = {4, 5, 6, 7, 0, 1, 2};
        int[] array3 = {1,3,5};
        System.out.println(test.search(array3, 3));
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

    /**
     * 1. 搜索二维数组Ⅰ
     * m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * * 每行中的整数从左到右按升序排列。
     * * 每行的第一个整数大于前一行的最后一个整数。
     * <p>
     * 1 2 3 4
     * 5 6 7 8
     * 9 10 11 12
     * 13 14 15 16
     * <p>
     * leetcode 74
     * <p>
     * 有序数组，使用二分查找
     * 时间复杂度：O(log(m*n))
     * 空间复杂度：O(1)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;
        int middle;

        int y;
        int x;
        while (start <= end) {
            middle = start + ((end - start) >> 1);
            y = middle / n;
            x = middle % n;
            System.out.println("start=" + start + ", end=" + end);
            System.out.println("middle=" + middle);
            System.out.println("x=" + x + ", y=" + y);

            if (target < matrix[y][x]) {
                end = middle - 1;
            } else if (target > matrix[y][x]) {
                start = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 2. 搜索二维数组Ⅱ
     * <p>
     * 矩阵的特点如下：
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * <p>
     * 1 2 8 9
     * 2 4 9 12
     * 4 7 10 13
     * 6 8 11 15
     * <p>
     * LeetCode 240
     * <p>
     * 左上角或右下角找个点
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int x = matrix[0].length - 1;
        int y = 0;
        while (x >= 0 && y <= matrix.length - 1) {
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] < target) {
                y++;
            } else {
                x--;
            }
        }
        return false;
    }

    /**
     * 搜索旋转排序数组
     * <p>
     * LeetCode 33
     * <p>
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * <p>
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * <p>
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * <p>
     * 你可以假设数组中不存在重复的元素。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return realSearch(nums, 0, nums.length - 1, target);
    }

    private int realSearch(int[] nums, int low, int high, int target) {
        if (low > high) return -1;
        int middle = low + ((high - low) >> 1);
        if (nums[middle] >= nums[low]) { // low ~ middle 是有序的
            if (target >= nums[low] && target <= nums[middle]) { // target在low ~ middle这个有序区间内
                return binarySearch(nums, low, middle, target);
            } else { // 在middle + 1 ~ high这个旋转数组里
                return realSearch(nums, middle + 1, high, target);
            }
        } else { // middle ~ high 是有序的
            if (target <= nums[high] && target >= nums[middle]) { // target在middle ~ high这个有序区间内
                return binarySearch(nums, middle, high, target);
            } else {
                return realSearch(nums, low, middle - 1, target);
            }
        }
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        int middle;
        while (low <= high) {
            middle = low + ((high - low) >> 1);
            if (target > nums[middle]) {
                low = middle + 1;
            } else if (target < nums[middle]) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
