package _39_backtracking;

import java.util.LinkedList;
import java.util.List;

public class BacktrackingTest {

    public static void main(String[] args) {
        BacktrackingTest backtrackingTest = new BacktrackingTest();
        backtrackingTest.cal8queens(0);
    }

    int[] result = new int[8];// 全局或成员变量, 下标表示行, 值表示 queen 存储在哪一列

    /**
     * 1. 8皇后问题
     *
     * @param row
     */
    public void cal8queens(int row) { // 调用方式：cal8queens(0);
        if (row == 8) { // 8 个棋子都放置好了，打印结果
            printQueens(result);
            return; // 8 行棋子都放好了，已经没法再往下递归了，所以就 return
        }
        for (int column = 0; column < 8; ++column) { // 每一行都有 8 中放法
            if (isOk(row, column)) { // 有些放法不满足要求
                result[row] = column; // 第 row 行的棋子放到了 column 列
                cal8queens(row + 1); // 考察下一行
            }
        }
    }

    private boolean isOk(int row, int column) {// 判断 row 行 column 列放置是否合适
        int leftup = column - 1, rightup = column + 1;
        for (int i = row - 1; i >= 0; --i) { // 逐行往上考察每一行
            if (result[i] == column) return false; // 第 i 行的 column 列有棋子吗？
            if (leftup >= 0) { // 考察左上对角线：第 i 行 leftup 列有棋子吗？
                if (result[i] == leftup) return false;
            }
            if (rightup < 8) { // 考察右上对角线：第 i 行 rightup 列有棋子吗？
                if (result[i] == rightup) return false;
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    private void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q  ");
                else System.out.print("*  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 2. 二叉树中和为某一值的路径
     *
     * leetcode 面试题34
     *
     * @param root
     * @param sum
     * @return
     */
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        realPathSum(root, sum);
        return res;
    }

    private void realPathSum(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        realPathSum(root.left, target);
        realPathSum(root.right, target);
        path.removeLast();
    }


    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

}
