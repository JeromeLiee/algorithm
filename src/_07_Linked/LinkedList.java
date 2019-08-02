package _07_Linked;

public class LinkedList {

    public static void main(String[] args) {
        LinkedList linked = new LinkedList();
        System.out.println("------reverse------");
        Node node1 = new Node(1);
        Node cur1 = node1;
        for (int i = 2; i < 11; i++) {
            Node temp = new Node(i);
            cur1.next = temp;
            cur1 = temp;
        }
        Node reverse = linked.reverse(node1);
        while (reverse != null) {
            System.out.println(reverse.value);
            reverse = reverse.next;
        }
        System.out.println("------reverse------");

        System.out.println("------isCircle------");
        Node node2 = new Node(1);
        Node cur2 = node2;
        for (int i = 2; i < 11; i++) {
            Node temp = new Node(i);
            cur2.next = temp;
            cur2 = temp;
        }
        cur2.next = node2.next.next.next;
        System.out.println(linked.isCircle(node2));
        System.out.println("------isCircle------");

        System.out.println("------combine------");
        Node node3 = new Node(1);
        Node cur3 = node3;
        for (int i = 3; i < 11; i += 2) {
            Node temp = new Node(i);
            cur3.next = temp;
            cur3 = temp;
        }

        Node node4 = new Node(2);
        Node cur4 = node4;
        for (int i = 4; i < 12; i += 2) {
            Node temp = new Node(i);
            cur4.next = temp;
            cur4 = temp;
        }
        Node combine = linked.combine(node3, node4);
        while (combine != null) {
            System.out.println(combine.value);
            combine = combine.next;
        }
        System.out.println("------combine------");
        System.out.println("------deleteNode------");
        Node node5 = new Node(1);
        Node cur5 = node5;
        for (int i = 2; i < 10; i++) {
            Node temp = new Node(i);
            cur5.next = temp;
            cur5 = temp;
        }

        Node deleteNode = linked.deleteNode(node5, 5);
        while (deleteNode != null) {
            System.out.println(deleteNode.value);
            deleteNode = deleteNode.next;
        }
        System.out.println("------deleteNode------");
        System.out.println("------getMiddleNode------");
        Node node6 = new Node(1);
        Node cur6 = node6;
        for (int i = 2; i < 10; i++) {
            Node temp = new Node(i);
            cur6.next = temp;
            cur6 = temp;
        }
        Node middleNode = linked.getMiddleNode(node6);
        if (middleNode != null) {
            System.out.println("middleNode=" + middleNode.value);
        } else {
            System.out.println("middleNode=null");
        }

        System.out.println("------getMiddleNode------");
    }

    /**
     * 1.单链表反转
     * <p>
     * LeetCode 206
     *
     * @param list
     * @return
     */
    public Node reverse(Node list) {
        if (list == null) return null;
        Node cur = list;
        Node head = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
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
    public boolean isCircle(Node list) {
        if (list == null) return false;
        Node fast = list;
        Node slow = list;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow.value == fast.value) return true;
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
    public Node combine(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        Node cur1 = list1;
        Node cur2 = list2;
        Node head;
        if (cur1.value < cur2.value) {
            head = cur1;
            cur1 = cur1.next;
        } else {
            head = cur2;
            cur2 = cur2.next;
        }

        Node cur = head;
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
    public Node deleteNode(Node list, int index) {
        if (list == null || index <= 0) return null;
        Node cur = list;
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

        Node temp = list;
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
    public Node getMiddleNode(Node list) {
        if (list == null) return null;
        Node fast = list;
        Node slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
