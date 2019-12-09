import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {2, 7, 11, 15};
        int target = 13;
        System.out.println("twoSum: " + Arrays.toString(solution.twoSum(nums1, target)));

        int[][] num2 = new int[][]{{1, 2, 8, 9,}, {2, 4, 9, 1, 2}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target2 = 3;
        System.out.println("findTarget: " + solution.searchMatrix(num2, target2));

        String s = "I love you.";
        System.out.println("replaceSpace: " + solution.replaceSpace(s));

        Node cur = new Node(0);
        Node head = cur;
        for (int i = 1; i <= 10; i++) {
            Node node = new Node(i);
            cur.next = node;
            cur = node;
        }
        solution.printListReverse3(head);

        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
//        TreeNode treeNode = solution.rebuildBinaryTree(preOrder, inOrder);
//        List<Integer> list = solution.inOrderTraversal(treeNode);
//        System.out.println(list);
        System.out.println("-------------");
        StackQueue stackQueue = new StackQueue();
        stackQueue.enqueue(1);
        stackQueue.enqueue(2);
        stackQueue.enqueue(3);
        stackQueue.enqueue(4);
        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue.dequeue());
//        System.out.println(stackQueue.dequeue());
        System.out.println("numberOf1: " + solution.numberOfOne2(-1));

        System.out.println("power:" + solution.power(2, 9));
        solution.print2MaxNumber(1);
        Node header = new Node(1);
        Node header1 = new Node(2);
        Node header2 = new Node(3);
        Node header3 = new Node(4);
        Node header4 = new Node(5);
        Node header5 = new Node(6);
        Node header6 = new Node(7);
        header.next = header1;
        header1.next = header2;
        header2.next = header3;
        header3.next = header4;
        header4.next = header5;
        header5.next = header6;
//        Node newHeader = header;
        Node newHeader = solution.removeNode(header, head);
        while (newHeader != null) {
            System.out.println("list: " + newHeader.value);
            newHeader = newHeader.next;
        }

        System.out.println(Arrays.toString(solution.rebuildArray3(new int[]{32, 21, 41, 6, 13, 56, 61, 2})));
        System.out.println("----------------------");
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
//        System.out.println("mirror before: " + solution.inOrderTraversal(treeNode1));
        solution.mirrorTree(treeNode1);
//        System.out.println("mirror after : " + solution.inOrderTraversal(treeNode1));
        System.out.println("-----------------");
        int[][] matrix = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        solution.printMatrixClockwise(matrix);
        System.out.println("isPopOrder: " + solution.isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2}));
        solution.printTreeFromTop2Bottom(treeNode1);
        System.out.println("---------------------");
        System.out.println("" + solution.moreThanHalfNumber2(new int[]{1, 2, 2, 2, 1}));

        char x = 'X';
        int i = 0;
        System.out.println(true ? x : 0);
        System.out.println(false ? i : x);
    }

    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return nums;
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (hashMap.containsKey(num)) {
                return new int[]{hashMap.get(num), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    /**
     * 二维数组中的查找
     * <p>
     * 1 2 8 9
     * 2 4 9 12
     * 4 7 10 13
     * 6 8 11 15
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int x = matrix[0].length - 1;
        int y = 0;
        while (x >= 0 && y <= matrix.length - 1) {
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] < target) {
                y++;
            } else {
                x--;
            }
        }
        return false;
    }

    /**
     * 空格替换
     *
     * @param str
     * @return
     */
    public String replaceSpace(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        int index1 = str.length() - 1;
        for (int i = 0; i <= index1; i++) {
            if (str.charAt(i) == ' ') {
                stringBuilder.append("  ");
            }
        }
        int index2 = stringBuilder.length() - 1;
        while (index1 >= 0 && index2 >= 0) {
            char c = str.charAt(index1--);
            if (c == ' ') {
                stringBuilder.setCharAt(index2--, '0');
                stringBuilder.setCharAt(index2--, '2');
                stringBuilder.setCharAt(index2--, '%');
            } else {
                stringBuilder.setCharAt(index2--, c);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 逆序打印单向链表元素
     * 反转链表，会改变链表结构
     *
     * @param list
     */
    public void printListReverse(Node list) {
        Node cur = list;
        Node pre = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        Node newCur = pre;
        while (newCur != null) {
            System.out.println(newCur.value);
            newCur = newCur.next;

        }
    }

    /**
     * 逆序打印单向链表元素
     * 使用栈配合
     *
     * @param list
     */
    public void printListReverse2(Node list) {
        Stack<Node> stack = new Stack<>();
        Node cur = list;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop.value);
        }
    }

    /**
     * 逆序打印单向链表元素
     * 递归调用，当链表较长会产生栈溢出
     *
     * @param list
     */
    public void printListReverse3(Node list) {
        if (list == null) {
            return;
        }
        printListReverse3(list.next);
        System.out.println(list.value);
    }

    public TreeNode rebuildBinaryTree(int[] preOrder, int[] inOrder) {
        TreeNode root = new TreeNode(preOrder[0]);
        int rootIndexInOrder = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == preOrder[0]) {
                rootIndexInOrder = i;
                break;
            }
        }
        System.out.println("rootIndexInOrder:" + rootIndexInOrder);

        TreeNode left = realRebuildBinaryTree(preOrder, 1, rootIndexInOrder, inOrder, 0, rootIndexInOrder - 1);
        TreeNode right = realRebuildBinaryTree(preOrder, rootIndexInOrder + 1, preOrder.length - 1, inOrder, rootIndexInOrder + 1, inOrder.length - 1);
        root.left = left;
        root.right = right;
        return root;
    }
//    int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
//    int[] inOrder  = {4, 2, 5, 1, 6, 3, 7};
//
//    int[] preOrder = {2, 4, 5};
//    int[] inOrder  = {4, 2, 5};

    public TreeNode realRebuildBinaryTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int rootIndexInOrder = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == preOrder[preStart]) {
                rootIndexInOrder = i;
                break;
            }
        }
        TreeNode left = realRebuildBinaryTree(preOrder, preStart + 1, rootIndexInOrder, inOrder, inStart, rootIndexInOrder - 1);
        TreeNode right = realRebuildBinaryTree(preOrder, rootIndexInOrder + 1, preEnd, inOrder, rootIndexInOrder + 1, inEnd);
        root.left = left;
        root.right = right;
        return root;

    }

    /**
     * 二叉树的中序遍历
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

    static class StackQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void enqueue(int value) {
            stack1.push(value);
        }

        public int dequeue() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    /**
     * 判断一个数字的二进制包含1的个数
     *
     * @param num
     * @return
     */
    public int numberOfOne(int num) {
        if (num < 0) {
            num = 0 - num;
        }
        int count = 0;
        while (num > 0) {
            if ((num & 1) > 0) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

    public int numberOfOne2(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

    public double power(double base, int exponent) {
        System.out.println("power");
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double result = power(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) != 0)
            result = result * base;
        return isNegative ? 1 / result : result;
    }

    public void print2MaxNumber(int num) {
        if (num <= 0) return;
        int max = 1;
        while (max <= num) {
            max *= 10;
        }
        for (int i = 1; i < max; i++) {
            System.out.println(i);
        }
    }

    public Node removeNode(Node header, Node deleteNode) {
        if (header == null || deleteNode == null) return header;
        Node next = deleteNode.next;
        if (next != null) {
            deleteNode.value = next.value;
            deleteNode.next = next.next;
        } else {
            if (header == deleteNode) {
                return header.next;
            }
            Node cur = header;
            while (cur != null && cur.next != deleteNode) {
                cur = cur.next;
            }
            if (cur == null) return header;
            cur.next = cur.next.next;
        }
        return header;
    }

    public int[] rebuildArray(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        int slowIndex = 0;
        int fastIndex = 1;
        while (slowIndex <= fastIndex && fastIndex < arr.length) {
            if (arr[slowIndex] % 2 == 0) {
                if (arr[fastIndex] % 2 == 0) {
                    fastIndex++;
                } else {
                    int temp = arr[slowIndex];
                    arr[slowIndex] = arr[fastIndex];
                    arr[fastIndex] = temp;
                    slowIndex++;
                    fastIndex++;
                }
            } else {
                slowIndex++;
                fastIndex++;
            }
        }
        return arr;
    }

    public int[] rebuildArray2(int[] arr) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex < endIndex) {
            if (arr[startIndex] % 2 == 0) {
                if (arr[endIndex] % 2 == 1) {
                    int temp = arr[startIndex];
                    arr[startIndex] = arr[endIndex];
                    arr[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                } else {
                    endIndex--;
                }
            } else {
                if (arr[endIndex] % 2 == 1) {
                    startIndex++;
                } else {
                    endIndex--;
                }
            }
        }
        return arr;
    }

    public int[] rebuildArray3(int[] arr) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex < endIndex) {
            while (startIndex < endIndex && (arr[startIndex] & 1) == 1) {
                startIndex++;
            }
            while (startIndex < endIndex && (arr[endIndex] & 1) == 0) {
                endIndex--;
            }
            if (startIndex < endIndex) {
                int temp = arr[startIndex];
                arr[startIndex] = arr[endIndex];
                arr[endIndex] = temp;
            }
        }
        return arr;
    }

    public Node removeLastKNode(Node header, int k) {
        int count = 0;
        Node cur = header;
        while (cur != null) {
            count++;
            cur = cur.next;
            if (count == k) {
                break;
            }
        }

        if (count < k) return header;
        if (cur == null) return header.next;

        Node temp = header;
        while (cur.next != null) {
            cur = cur.next;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return header;
    }

    public Node combineTwoList(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        Node header;
        Node cur1 = list1;
        Node cur2 = list2;
        if (list1.value < list2.value) {
            header = list1;
            cur1 = list1.next;
        } else {
            header = list2;
            cur2 = list2.next;
        }
        Node cur = header;
        while (cur1 != null && cur2 != null) {
            if (cur1.value < cur2.value) {
                cur.next = cur1;
                cur = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur = cur2;
                cur2 = cur2.next;
            }
        }
        if (cur1 != null) {
            cur.next = cur1;
        } else {
            cur.next = cur2;
        }
        return header;
    }

    /**
     * 树的子结构
     * 解法1
     *
     * @param mainTree
     * @param subtree
     * @return
     */
    public boolean hasSubtree(TreeNode mainTree, TreeNode subtree) {
        boolean result = false;
        if (mainTree != null && subtree != null) {
            if (mainTree.val == subtree.val) {
                result = doesTreeHaveSubtree(mainTree, subtree);
            }
            if (!result) {
                result = hasSubtree(mainTree.left, subtree);
            }
            if (!result) {
                result = hasSubtree(mainTree.right, subtree);
            }
        }
        return result;
    }

    /**
     * 树的子结构
     * 解法2
     *
     * @param mainTree
     * @param subtree
     * @return
     */
    public boolean hasSubtree2(TreeNode mainTree, TreeNode subtree) {
        if (mainTree == null || subtree == null) {
            return false;
        }
        return doesTreeHaveSubtree(mainTree, subtree) || hasSubtree2(mainTree.left, subtree) || hasSubtree2(mainTree.right, subtree);
    }

    private boolean doesTreeHaveSubtree(TreeNode mainTree, TreeNode subtree) {
        if (subtree == null) return true;
        if (mainTree == null) return false;
        if (mainTree.val != subtree.val) {
            return false;
        }
        return doesTreeHaveSubtree(mainTree.left, subtree.left) && doesTreeHaveSubtree(mainTree.right, subtree.right);
    }

    public void mirrorTree(TreeNode tree) {
        if (tree == null) return;
        TreeNode right = tree.right;
        tree.right = tree.left;
        tree.left = right;
        mirrorTree(tree.left);
        mirrorTree(tree.right);
    }

    /**
     * 顺时针打印二维数组
     *
     * @param matrix
     */
    public void printMatrixClockwise(int[][] matrix) {
        if (matrix == null) return;
        int height = matrix.length;
        int width = matrix[0].length;
        realPrintMatrixClockwise(matrix, 0, 0, width - 1, height - 1);
    }

    private void realPrintMatrixClockwise(int[][] matrix, int startX, int startY, int endX, int endY) {
        if (matrix == null || startX > endX || startY > endY) return;
        for (int i = startX; i < endX; i++) {
            System.out.println(matrix[startY][i]);
        }
        for (int i = startY; i < endY; i++) {
            System.out.println(matrix[i][endX]);
        }
        for (int i = endX; i > startX; i--) {
            System.out.println(matrix[endY][i]);
        }
        for (int i = endY; i > startY; i--) {
            System.out.println(matrix[i][startX]);
        }
        realPrintMatrixClockwise(matrix, startX + 1, startY + 1, endX - 1, endY - 1);
    }

    public boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        Stack<Integer> stack = new Stack<>();
        int popOrderIndex = 0;
        for (int i = 0; i < pushOrder.length; i++) {
            stack.push(pushOrder[i]);
            while (!stack.isEmpty() && stack.peek() == popOrder[popOrderIndex]) {
                stack.pop();
                popOrderIndex++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 二叉树层级遍历
     *
     * @param node
     */
    public void printTreeFromTop2Bottom(TreeNode node) {
        if (node == null) return;
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(node);
        while (!treeNodes.isEmpty()) {
            TreeNode head = treeNodes.poll();
            if (head != null) {
                treeNodes.add(head.left);
                treeNodes.add(head.right);
                System.out.println(head.val);
            }
        }
    }

    /**
     * 根据后序遍历判断是否为二叉搜索树
     *
     * @param postOrderList
     * @return
     */
    public boolean verifyBinarySearchTree(int[] postOrderList) {
        if (postOrderList == null || postOrderList.length == 0) return false;
        return realVerifyBinarySearchTree(postOrderList, 0, postOrderList.length - 1);
    }

    private boolean realVerifyBinarySearchTree(int[] postOrderList, int start, int end) {
        int root = postOrderList[end];
        int curIndex = start;
        for (int i = start; i <= end; i++) {
            if (postOrderList[i] > root) {
                break;
            }
            curIndex++;
        }
        for (int i = curIndex + 1; i <= end; i++) {
            if (postOrderList[i] < root) return false;
        }
        boolean left = false;
        if (start <= curIndex) {
            left = realVerifyBinarySearchTree(postOrderList, start, curIndex);
        }

        boolean right = false;
        if (curIndex + 1 <= end) {
            right = realVerifyBinarySearchTree(postOrderList, curIndex + 1, end);
        }
        return left & right;
    }

    /**
     * 找出数组中超过一半的数字
     * 快排分区思想
     *
     * @param nums
     * @return
     */
    public int moreThanHalfNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int middle = nums.length >> 1;
        int start = 0;
        int end = nums.length - 1;
        int partition = partition(nums, start, end);
        while (partition != middle) {
            if (partition > middle) {
                end = partition - 1;
            } else {
                start = partition + 1;
            }
            partition = partition(nums, start, end);
        }

        int number = nums[partition];
        if (checkMoreThanHalfNumber(nums, number)) {
            return number;
        }
        return 0;
    }

    private int partition(int[] nums, int start, int end) {
        if (start >= end) {
            return start;
        }
        int partition = nums[end];
        int i = start;
        int j = start;
        for (; j < end; j++) {
            if (nums[j] < partition) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        nums[end] = nums[i];
        nums[i] = partition;
        return i;
    }

    /**
     * 找出数组中超过一半的数字
     * 多数投票问题
     *
     * @param nums
     * @return
     */
    public int moreThanHalfNumber2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        int major = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
            }
            if (major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        if (checkMoreThanHalfNumber(nums, major)) {
            return major;
        }
        return 0;
    }

    private boolean checkMoreThanHalfNumber(int[] nums, int major) {
        int numberCount = 0;
        for (int num : nums) {
            if (num == major) {
                numberCount++;
            }
            if (numberCount > (nums.length >> 1)) {
                return true;
            }
        }
        return false;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.val = value;
        }
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    static class StackWithMin {
        Stack<Integer> stack, minStack;

        public StackWithMin() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int value) {
            stack.push(value);
            if (minStack.isEmpty()) {
                minStack.push(value);
            }
            if (value <= minStack.peek()) {
                minStack.push(value);
            }
        }

        public int pop() {
            int pop = stack.pop();
            if (pop == minStack.peek()) {
                minStack.pop();
            }
            return pop;
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}

























































































































