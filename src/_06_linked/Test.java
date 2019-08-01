package _06_linked;

public class Test {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node cur = reverse(node1);
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }

        Node node6 = new Node(1);
        Node node7 = new Node(2);
        Node node8 = new Node(3);
        node6.next = node7;
        node7.next = node8;
        node8.next = node6;
        System.out.println(isCircle(node6));
    }

    public static Node reverse(Node node) {
        if (node == null) {
            return null;
        }
        Node cur = node;
        Node head = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }

    static boolean isCircle(Node node) {
        if (node == null) return false;
        Node slow = node;
        Node fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.value == fast.value) return true;
        }
        return false;
    }

    static class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
