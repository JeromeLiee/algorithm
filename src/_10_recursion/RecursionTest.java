package _10_recursion;

import java.util.HashMap;
import java.util.Map;

public class RecursionTest {

    public static void main(String[] args) {
        RecursionTest recursionTest = new RecursionTest();
        long start = System.currentTimeMillis();
        System.out.println(recursionTest.climbStairs2(1000));
        System.out.println("spent time " + (System.currentTimeMillis() - start));
    }

    /**
     * 爬楼梯
     * <p>
     * LeetCode 70
     * <p>
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     * <p>
     * 示例 1：
     * <p>
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     * <p>
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     * <p>
     * 递推公式为 f(n) = f(n-1) + f(n-2)
     * 终止条件为 f(1) = 1, f(2) = 2
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (countMap.containsKey(n)) {
            return countMap.get(n);
        }
        int count = climbStairs(n - 1) + climbStairs(n - 2);
        countMap.put(n, count);
        return count;
    }

    private Map<Integer, Integer> countMap = new HashMap<>();

    public int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int count = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; i++) {
            count = pre + prepre;
            prepre = pre;
            pre = count;
        }
        return count;
    }
}
