package _23_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTest {
    public static void main(String[] args) {
        TreeTest treeTest = new TreeTest();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        System.out.println(treeTest.preOrderTraversal(root));
        System.out.println(treeTest.inOrderTraversal(root));
        System.out.println(treeTest.postOrderTraversal(root));
    }

    /**
     * 1. 二叉树的前序遍历
     * <p>
     * LeetCode 144
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        realPreOrderTraversal(list, root);
        return list;
    }

    private void realPreOrderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        realPreOrderTraversal(list, root.left);
        realPreOrderTraversal(list, root.right);
    }

    /**
     * 2. 二叉树的中序遍历
     * <p>
     * LeetCode 94
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        realInOrderTraversal(list, root);
        return list;
    }

    private void realInOrderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) return;
        realInOrderTraversal(list, root.left);
        list.add(root.val);
        realInOrderTraversal(list, root.right);
    }

    /**
     * 3. 二叉树的后序遍历
     * <p>
     * leetcode 154
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        realPostOrderTraversal(list, root);
        return list;
    }

    private void realPostOrderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) return;
        realPostOrderTraversal(list, root.left);
        realPostOrderTraversal(list, root.right);
        list.add(root.val);
    }


    /**
     * 4. 二叉树的层次遍历
     * leetcode 102
     * <p>
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null) return levelList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            levelList.add(new ArrayList<>());
            int curLevelLength = queue.size();
            for (int i = 0; i < curLevelLength; i++) {
                TreeNode node = queue.remove();
                levelList.get(level).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return levelList;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
