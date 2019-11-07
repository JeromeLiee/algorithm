package _40_dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DynamicProgrammingTest {
    private static Integer[][] all = new Integer[4][];
    private static Integer[] first = {2};
    private static Integer[] second = {3, 4};
    private static Integer[] third = {6, 5, 7};
    private static Integer[] fourth = {4, 1, 8, 3};
    private static List<List<Integer>> triangle = new ArrayList<>(4);
    private static List<Integer> firstList = new ArrayList<>(Arrays.asList(first));
    private static List<Integer> secondList = new ArrayList<>(Arrays.asList(second));
    private static List<Integer> thirdList = new ArrayList<>(Arrays.asList(third));
    private static List<Integer> fourthList = new ArrayList<>(Arrays.asList(fourth));

    static {
        triangle.add(firstList);
        triangle.add(secondList);
        triangle.add(thirdList);
        triangle.add(fourthList);
        all[0] = first;
        all[1] = second;
        all[2] = third;
        all[3] = fourth;
    }

    public static void main(String[] args) {
        DynamicProgrammingTest test = new DynamicProgrammingTest();
        System.out.println("minimumTotal=" + test.minimumTotal(triangle));
        int[] items = {2, 2, 4, 6, 3};
        System.out.println("maxWeight=" + test.maxWeight(items, 9));
    }

    /**
     * leetcode 120
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     *
     * 例如，给定三角形：
     *
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * 说明：
     * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        System.out.println("triangle=" + triangle.toString());
        int size = triangle.size();
        int[] min = new int[size + 1];
        for (int i = size - 1; i >= 0; i--) {
            List<Integer> rowList = triangle.get(i);
            int rowSize = rowList.size();
            for (int j = 0; j < rowSize; j++) {
                min[j] = Math.min(min[j], min[j + 1]) + rowList.get(j);
            }
            System.out.println("min=" + Arrays.toString(min));
        }
        return min[0];
    }

    /**
     * 背包问题
     * 对于一组重量不同且不可分割的物品，放在限制重量的背包里，能放入最大的重量值是多少？
     *
     * @param items
     * @param weight
     * @return
     */
    public int maxWeight(int[] items, int weight) {
        int length = items.length;
        int[] max = new int[weight + 1];
        // 不放第一个物品
        max[0] = 1;
        // 放第一个物品
        if (items[0] <= weight) {
            max[items[0]] = 1;
        }
        System.out.println("  [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
        System.out.println(items[0] + " " + Arrays.toString(max));
        for (int i = 1; i < length; i++) {
            for (int j = weight - items[i]; j >= 0; j--) {
                if (max[j] == 1) {
                    max[j + items[i]] = 1;
                }
            }
            System.out.println(items[i] + " " + Arrays.toString(max));
        }
        for (int i = weight; i >= 0; i--) {
            if (max[i] == 1) return i;
        }
        return 0;
    }

    /**
     * 背包问题升级版
     * 对于一组重量不同、不同价值且不可分割的物品，放在限制重量的背包里，能放入最大的价值是多少？
     *
     * @param items
     * @param values
     * @param weight
     * @return
     */
    public int maxValue(int[] items, int[] values, int weight) {

        return 0;
    }



}
































