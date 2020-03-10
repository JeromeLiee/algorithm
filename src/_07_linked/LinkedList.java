package _07_linked;

import java.util.Stack;

public class LinkedList {

    public static void main(String[] args) {
        LinkedList linked = new LinkedList();
        System.out.println("------reverse------");
        ListNode node1 = new ListNode(1);
        ListNode cur1 = node1;
        for (int i = 2; i < 11; i++) {
            ListNode temp = new ListNode(i);
            cur1.next = temp;
            cur1 = temp;
        }
        ListNode reverse = linked.reverse2(node1);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
        System.out.println("------reverse------");

        System.out.println("------isCircle------");
        ListNode node2 = new ListNode(1);
        ListNode cur2 = node2;
        for (int i = 2; i < 11; i++) {
            ListNode temp = new ListNode(i);
            cur2.next = temp;
            cur2 = temp;
        }
        cur2.next = node2.next.next.next;
        System.out.println(linked.isCircle(node2));
        System.out.println("------isCircle------");

        System.out.println("------combine------");
        ListNode node3 = new ListNode(1);
        ListNode cur3 = node3;
        for (int i = 3; i < 11; i += 2) {
            ListNode temp = new ListNode(i);
            cur3.next = temp;
            cur3 = temp;
        }

        ListNode node4 = new ListNode(2);
        ListNode cur4 = node4;
        for (int i = 4; i < 12; i += 2) {
            ListNode temp = new ListNode(i);
            cur4.next = temp;
            cur4 = temp;
        }
        ListNode combine = linked.combine(node3, node4);
        while (combine != null) {
            System.out.println(combine.val);
            combine = combine.next;
        }
        System.out.println("------combine------");
        System.out.println("------deleteNode------");
        ListNode node5 = new ListNode(1);
        ListNode cur5 = node5;
        for (int i = 2; i < 10; i++) {
            ListNode temp = new ListNode(i);
            cur5.next = temp;
            cur5 = temp;
        }

        ListNode deleteNode = linked.deleteNode(node5, 5);
        while (deleteNode != null) {
            System.out.println(deleteNode.val);
            deleteNode = deleteNode.next;
        }
        System.out.println("------deleteNode------");
        System.out.println("------getMiddleNode------");
        ListNode node6 = new ListNode(1);
        ListNode cur6 = node6;
        for (int i = 2; i < 10; i++) {
            ListNode temp = new ListNode(i);
            cur6.next = temp;
            cur6 = temp;
        }
        ListNode middleNode = linked.getMiddleNode(node6);
        if (middleNode != null) {
            System.out.println("middleNode=" + middleNode.val);
        } else {
            System.out.println("middleNode=null");
        }

        System.out.println("------getMiddleNode------");

        System.out.println("------printImmutableLinked-----");
        ListNode node7 = new ListNode(1);
        ListNode cur7 = node7;
        for (int i = 2; i < 10; i++) {
            ListNode temp = new ListNode(i);
            cur7.next = temp;
            cur7 = temp;
        }
//        linked.printImmutableLinked1(node7);
//        linked.printImmutableLinked2(node7);
        linked.printImmutableLinked3(node7);
        System.out.println("------printImmutableLinked-----");
    }

    /**
     * 1.1 单链表反转 循环实现
     * <p>
     * LeetCode 206
     *
     * @param list
     * @return
     */
    public ListNode reverse(ListNode list) {
        ListNode cur = list;
        ListNode head = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }

    /**
     * 1.2 单链表反转 递归实现
     *
     * @param list
     * @return
     */
    public ListNode reverse2(ListNode list) {
        if (list == null || list.next == null) return list;
        ListNode p = reverse2(list.next);
        list.next.next = list;
        list.next = null;
        return p;
    }


    /**
     * 2.链表中环的检测
     * 通过快慢指针来实现
     * <p>
     * LeetCode 141
     *
     * @param list
     * @return
     */
    public boolean isCircle(ListNode list) {
        if (list == null) return false;
        ListNode fast = list;
        ListNode slow = list;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow.val == fast.val) return true;
        }
        return false;
    }


    /**
     * 3.两个有序链表合并
     * <p>
     * LeetCode 21
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode combine(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode head;
        if (cur1.val < cur2.val) {
            head = cur1;
            cur1 = cur1.next;
        } else {
            head = cur2;
            cur2 = cur2.next;
        }

        ListNode cur = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
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
        return head;
    }

    /**
     * 4.删除链表倒数第n个结点
     * <p>
     * LeetCode 19
     *
     * @param list
     * @param index
     * @return
     */
    public ListNode deleteNode(ListNode list, int index) {
        if (list == null || index <= 0) return list;
        ListNode cur = list;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
            if (count == index) break;
        }

        if (count < index) {
            return null;
        }

        if (cur == null) return list.next;

        ListNode temp = list;
        while (cur.next != null) {
            temp = temp.next;
            cur = cur.next;
        }
        temp.next = temp.next.next;
        return list;
    }

    /**
     * 5.求链表的中间节点
     * <p>
     * LeetCode 876
     *
     * @param list
     * @return
     */
    public ListNode getMiddleNode(ListNode list) {
        if (list == null) return null;
        ListNode fast = list;
        ListNode slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 6. 是否为回文链表
     * <p>
     * LeetCode 234
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        ListNode newHead = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = newHead;
            newHead = slow;
            slow = next;
        }

        if (fast.next == null) {
            slow = slow.next;
        } else {
            ListNode next = slow.next;
            slow.next = newHead;
            newHead = slow;
            slow = next;
        }

        while (newHead != null && slow != null) {
            if (newHead.val != slow.val) return false;
            newHead = newHead.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 7. 旋转链表
     * <p>
     * LeetCode 61
     * <p>
     * eg. 1->2->3->4
     * k=1,则返回 4->1->2->3
     * k=2,则返回 3->4->1->2
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        ListNode cur = head;
        int count = 1;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        cur.next = head;
        int rotateCount = k % count;
        for (int i = 0; i < count - rotateCount; i++) {
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = null;
        return next;
    }

    /**
     * 8. 移除链表元素
     * <p>
     * LeetCode 203
     * <p>
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode first = new ListNode(-1);
        ListNode pre = first;
        pre.next = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return first.next;
    }

    /**
     * 9. 反转链表
     * <p>
     * LeetCode 92
     * <p>
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * <p>
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     * 示例:
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;
        ListNode cur = head;
        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
            n--;
        }
        ListNode temp = null;
        ListNode end = cur;
        for (int i = 0; i < n; i++) {
            ListNode next = cur.next;
            cur.next = temp;
            temp = cur;
            cur = next;
        }
        pre.next = temp;
        end.next = cur;
        return first.next;
    }

    /**
     * 10. 删除链表中的结点
     * <p>
     * LeetCode 237
     * <p>
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     * <p>
     * 示例 1:
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * <p>
     * 示例 2:
     * 输入: head = [4,5,1,9], node = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     * <p>
     * 说明:
     * 链表至少包含两个节点。
     * 链表中所有节点的值都是唯一的。
     * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     * 不要从你的函数中返回任何结果。
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 11.1 逆序打印一个单链表
     * 反转链表，会破坏原有链表的结构
     *
     * @param header
     */
    public void printImmutableLinked1(ListNode header) {
        if (header == null) return;
        ListNode pre = null;
        ListNode cur = header;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        while (pre != null) {
            System.out.println(pre.val);
            pre = pre.next;
        }
    }

    /**
     * 11.2 逆序打印一个单链表
     * 使用栈实现
     */
    public void printImmutableLinked2(ListNode header) {
        if (header == null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = header;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().val);
        }
    }

    /**
     * 11.3 逆序打印一个单链表
     * 递归实现，需要注意当链表太长可能会导致栈溢出
     *
     * @param header
     */
    public void printImmutableLinked3(ListNode header) {
        if (header == null) return;
        printImmutableLinked3(header.next);
        System.out.println(header.val);
    }

    /**
     * 12. 链表中倒数第k个节点
     * <p>
     * LeetCode 22
     * <p>
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = 0;
        ListNode first = head;
        while (first != null) {
            first = first.next;
            count++;
            if (count == k)
                break;
        }
        if (first == null) return head;
        ListNode second = head;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
