package _24_tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {
    public static void main(String[] args) {
        TreeTest treeTest = new TreeTest();
        TreeNode root = new TreeNode(33);
        TreeNode node17 = new TreeNode(17);
        TreeNode node50 = new TreeNode(50);
        TreeNode node13 = new TreeNode(13);
        TreeNode node18 = new TreeNode(18);
        TreeNode node34 = new TreeNode(34);
        TreeNode node58 = new TreeNode(58);
        TreeNode node16 = new TreeNode(16);
        TreeNode node25 = new TreeNode(25);
        TreeNode node51 = new TreeNode(51);
        TreeNode node66 = new TreeNode(66);
        TreeNode node19 = new TreeNode(19);
        TreeNode node27 = new TreeNode(27);
        root.left = node17;
        root.right = node50;
        node17.left = node13;
        node17.right = node18;
        node50.left = node34;
        node50.right = node58;
        node13.right = node16;
        node18.right = node25;
        node58.left = node51;
        node58.right = node66;
        node25.left = node19;
        node25.right = node27;
        System.out.println(treeTest.find1(root, 25).val);
        System.out.println(treeTest.find2(root, 25).val);
        System.out.println(treeTest.inOrderTraversal(root));
        treeTest.insert(root, 15);
        System.out.println(treeTest.inOrderTraversal(root));

        System.out.println(treeTest.maxDepth(root));
    }

    /**
     * 二叉树查找，递归方式
     *
     * @param root
     * @param value
     * @return
     */
    public TreeNode find1(TreeNode root, int value) {
        if (root == null) return null;
        if (root.val > value) {
            return find1(root.left, value);
        } else if (root.val < value) {
            return find1(root.right, value);
        } else {
            return root;
        }
    }

    /**
     * 二叉树查找，循环方式
     *
     * @param root
     * @param value
     * @return
     */
    public TreeNode find2(TreeNode root, int value) {
        TreeNode node = root;
        while (node != null) {
            if (node.val > value) {
                node = node.left;
            } else if (node.val < value) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    /**
     * 二叉树的插入
     *
     * @param root
     * @param value
     */
    public void insert(TreeNode root, int value) {
        TreeNode node = root;
        while (node != null) {
            if (node.val > value) {
                if (node.left == null) {
                    node.left = new TreeNode(value);
                    return;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(value);
                    return;
                }
                node = node.right;
            }
        }
    }

    /**
     * 二叉树的最大深度
     * <p>
     * LeetCode 104
     * <p>
     * 给定一个二叉树，找出其最大深度。
     * <p>
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return maxDepth(root.right) + 1;
        if (root.right == null) return maxDepth(root.left) + 1;
        return Math.max(maxDepth(root.right) + 1, maxDepth(root.left) + 1);
    }

    /**
     * 二叉树中序遍历
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
     * 验证二叉搜索树
     * <p>
     * LeetCode 98
     * <p>
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        return false;
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
