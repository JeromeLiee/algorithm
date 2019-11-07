package _40_dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DynamicProgrammingTest {
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
    }

    public static void main(String[] args) {
        DynamicProgrammingTest test = new DynamicProgrammingTest();
        System.out.println("minimumTotal=" + test.minimumTotal(triangle));
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
}
