package _42_other;

public class OtherTest {

    public static void main(String[] args) {
        OtherTest otherTest = new OtherTest();
//        int num = 0b10001;
        int num = 0b11111111111111111111111111111101;
        int num2 = 7;
        System.out.println("num=" + num + ", count=" + otherTest.hammingWeight(num));
        System.out.println("num=" + num2 + ", count=" + otherTest.hammingWeight(num2));
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

}
