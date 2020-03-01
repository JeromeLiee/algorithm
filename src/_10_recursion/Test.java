package _10_recursion;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.climbStairs(50);
    }

    public long climbStairs(int n) {
        long start1 = System.currentTimeMillis();
        long count1 = climbStairs1(n);
        System.out.println("Spent time by recursion without cache is " + (System.currentTimeMillis() - start1));

        long start3 = System.currentTimeMillis();
        long count3 = climbStairs3(n);
        System.out.println("Spent time by circulation is " + (System.currentTimeMillis() - start3));

        long start2 = System.currentTimeMillis();
        long count2 = climbStairs2(n);
        System.out.println("Spent time by recursion is " + (System.currentTimeMillis() - start2));

        System.out.println("Count1 is " + count1 + ", count2 is " + count2 + ", count3 is " + count3);
        return count1;
    }

    private Map<Integer, Long> map = new HashMap<>();

    public long climbStairs1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n)) {
            return map.get(n);
        }
        long count = climbStairs1(n - 1) + climbStairs1(n - 2);
        map.put(n, count);
        return count;
    }

    public long climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    public long climbStairs3(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        long pre = 2;
        long prepre = 1;
        long count = 0;
        for (int i = 3; i <= n; i++) {
            count = pre + prepre;
            prepre = pre;
            pre = count;
        }
        return count;
    }
}
