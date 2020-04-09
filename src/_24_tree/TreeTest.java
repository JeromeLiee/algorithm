package _24_tree;

import java.util.ArrayList;
import java.util.HashMap;
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

        System.out.println("---rebuildTree---");
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        int[] postOrder = {9, 15, 7, 20, 3};
        TreeNode treeNode1 = treeTest.rebuildTree(preOrder, inOrder);
        System.out.println(treeTest.inOrderTraversal(treeNode1).toString());
        TreeNode treeNode2 = treeTest.rebuildTree2(inOrder, postOrder);
        System.out.println(treeTest.inOrderTraversal(treeNode2).toString());
        System.out.println("---rebuildTree---");

        TreeNode rootA = new TreeNode(2);
        TreeNode rootA1 = new TreeNode(3);
        TreeNode rootA2 = new TreeNode(2);
        TreeNode rootA3 = new TreeNode(1);
        rootA.left = rootA1;
        rootA.right = rootA2;
        rootA1.left = rootA3;
        TreeNode rootB = new TreeNode(1);
        System.out.println("isSubStructure=" + treeTest.isSubStructure(rootA, rootB));
    }

    /**
     * 5.1 二叉树查找，递归方式
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
     * 5.2 二叉树查找，循环方式
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
     * 6. 二叉树的插入
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
     * 7. 二叉树的最大深度
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

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int leftMaxDepth = maxDepth2(root.left);
        int rightMaxDepth = maxDepth2(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
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
     * 8. 验证二叉搜索树
     * <p>
     * LeetCode 98
     * <p>
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if (max != null && node.val >= max) return false;
        if (min != null && node.val <= min) return false;
        boolean leftIsValidBST = isValidBSTHelper(node.left, min, node.val);
        boolean rightIsValidBST = isValidBSTHelper(node.right, node.val, max);
        return leftIsValidBST & rightIsValidBST;
    }

    /**
     * 9. 从前序与中序遍历序列构造二叉树
     *
     * leetcode 105
     *
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode rebuildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return realRebuildTree(0, inorder.length - 1);
    }

    private int rootIndex;
    private int[] preorder;
    private HashMap<Integer, Integer> indexMap = new HashMap<>();

    // 分成左右子树然后用递归去进行重建
    private TreeNode realRebuildTree(int start, int end) {
        if (start > end) return null;
        int rootValue = preorder[rootIndex++];
        TreeNode root = new TreeNode(rootValue);

        int index = indexMap.get(rootValue);
        root.left = realRebuildTree(start, index - 1);
        root.right = realRebuildTree(index + 1, end);
        return root;
    }

    /**
     * 10. 从中序与后序遍历序列构造二叉树
     *
     * leetcode 106
     *
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode rebuildTree2(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }

        this.postorder = postorder;
        rootIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return realRebuildTree2(0, inorder.length - 1);
    }

    private int[] postorder;

    private TreeNode realRebuildTree2(int start, int end) {
        if (start > end) {
            return null;
        }
        int rootValue = postorder[rootIndex--];
        TreeNode root = new TreeNode(rootValue);

        int index = indexMap.get(rootValue);
        root.right = realRebuildTree2(index + 1, end - 1);
        root.left = realRebuildTree2(start, index - 1);
        return root;
    }

    /**
     * 11. 树的子结构
     *
     * leetcode 26
     *
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     *
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        boolean result = false;
        if (A.val == B.val) {
            result = realIsSubStructure(A, B);
        }
        if (!result) {
            result = isSubStructure(A.left, B);
        }
        if (!result) {
            result = isSubStructure(A.right, B);
        }
        return result;
    }

    private boolean realIsSubStructure(TreeNode treeA, TreeNode treeB) {
        if (treeB == null) {
            return true;
        }
        if (treeA == null) {
            return false;
        }
        if (treeA.val != treeB.val) {
            return false;
        }
        boolean leftResult = realIsSubStructure(treeA.left, treeB.left);
        boolean rightResult = realIsSubStructure(treeA.right, treeB.right);
        return leftResult && rightResult;
    }

    /**
     * 12. 二叉树的镜像，又称翻转二叉树
     *
     * leetcode 27、226
     *
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * 例如输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) return root;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    /**
     * 13. 二叉搜索树的后序遍历序列
     *
     * leetcode 面试题33
     *
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     * 参考以下这颗二叉搜索树：
     *
     *      5
     *     / \
     *    2   6
     *   / \
     *  1   3
     *
     * 示例 1：
     *
     * 输入: [1,6,3,2,5]
     * 输出: false
     *
     * 示例 2：
     *
     * 输入: [1,3,2,6,5]
     * 输出: true
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) return false;
        int endIndex = postorder.length - 1 ;
        return realVerifyPostorder(postorder, 0, endIndex);
    }

    private boolean realVerifyPostorder(int[] postorder, int start, int end) {
        if (start > end) return true;
        int i = start;
        for ( ;i < end ; i++) {
            if (postorder[i] > postorder[end]) break;
        }
        for (; i < end; i++) {
            if (postorder[i] < postorder[end]) return false;
        }
        return realVerifyPostorder(postorder, start, i -1) && realVerifyPostorder(postorder, i, end - 1);
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















