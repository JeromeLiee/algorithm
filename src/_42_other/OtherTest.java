package _42_other;

import java.util.Arrays;

public class OtherTest {

    public static void main(String[] args) {
        OtherTest otherTest = new OtherTest();
//        int num = 0b10001;
        int num = 0b11111111111111111111111111111101;
        int num2 = 7;
        System.out.println("num=" + num + ", count=" + otherTest.hammingWeight(num));
        System.out.println("num=" + num2 + ", count=" + otherTest.hammingWeight(num2));
        double x = 2.0;
        int n = -3;
        System.out.println("x=" + x + ", n=" + n + ", result=" + otherTest.myPow(x, n));

        int n1 = 1;
        System.out.println("n=" + n1 + ", nums=" + Arrays.toString(otherTest.printNumbers(n1)));
    }

    /**
     * 1.1 位1的个数
     * <p>
     * LeetCode 191
     * <p>
     * 与1做与运算，大于1则说明最低位为1，count++，否则为0，不做任何操作
     * 然后对n做右移1位操作
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) > 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    /**
     * 1.2 位1的个数
     * <p>
     * LeetCode 191
     * <p>
     * 减去1后，再进行与运算，这样低位1会变成0。例如：
     * 1111 & 1110 = 1110
     * 1110 & 1101 = 1100；
     * 1100 & 1011 = 1000；
     * 1000 & 0111 = 0000；
     * 共循环4次，而1.1解法需要循环32次
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }

    /**
     * 2. 数值的整数次方
     * <p>
     * LeetCode 16、50
     * <p>
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double result = 1.0;
        boolean negative = n < 0;
        if (negative) {
            n *= -1;
        }
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        if (negative) {
            result = 1.0 / result;
        }
        return result;
    }

    /**
     * 3. 打印从1到最大的n位数
     * <p>
     * leetcode 17
     * <p>
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * <p>
     * 用返回一个整数列表来代替打印
     * n 为正整数
     *
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            count *= 10;
        }
        System.out.println(count);
        int[] nums = new int[count - 1];
        for (int i = 0; i < count - 1; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }

}
