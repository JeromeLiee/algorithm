package _15_search;

public class SearchTest {

    public static void main(String[] args) {
        SearchTest searchTest = new SearchTest();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        System.out.println(searchTest.binarySearch(arr, 3));
        System.out.println(searchTest.binarySearch2(arr, 3));
        System.out.println(2147395599 + " sqrt is " + searchTest.mySqrt(2147395599));
    }

    /**
     * 1.1 二分查找，循环的实现方式
     *
     * @param arr
     * @param value
     * @return
     */
    public int binarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (arr[middle] == value) {
                return middle;
            } else if (arr[middle] < value) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 1.2 二分查找，递归的实现方式
     *
     * @param arr
     * @param value
     * @return
     */
    public int binarySearch2(int[] arr, int value) {
        return realBinarySearch(arr, 0, arr.length - 1, value);
    }

    private int realBinarySearch(int[] arr, int low, int high, int value) {
        if (low > high) return -1;
        int middle = low + ((high - low) >> 1);
        if (arr[middle] == value) {
            return middle;
        } else if (arr[middle] < value) {
            return realBinarySearch(arr, middle + 1, high, value);
        } else {
            return realBinarySearch(arr, low, middle - 1, value);
        }
    }

    /**
     * 2. x 的平方根
     * <p>
     * leetcode 69
     * <p>
     * <p>
     * 通过牛顿迭代法完成
     * <p>
     * 实现 int sqrt(int x) 函数。
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * <p>
     * 示例 1:
     * 输入: 4
     * 输出: 2
     * <p>
     * 示例 2:
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        s = x;
        if (x == 0) return 0;
        return ((int) (sqrt(x)));
    }

    private int s;

    private double sqrt(double x) {
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrt(res);
        }
    }

    /**
     * 3. 求一个数的平方根，要求精确到小数点后6位
     *
     * @param x
     * @return
     */
    public double mySqrt2(int x) {
        return 0;
    }

}




















