package _06_linked;

public class Palindrome {
    public static void main(String[] args) {

    }

    private boolean isPalindrome(Node list) {
        if (list == null) {
            return false;
        }
        Node fast = list;
        Node slow = list;
        Node pre = null;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            Node next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        if (fast.next != null) {
            Node next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        } else {
            slow = slow.next;
        }

        while (slow != null && pre != null) {
            if (slow.value == pre.value) {
                slow = slow.next;
                pre = pre.next;
            } else {
                return false;
            }
        }
        return true;
    }

    static class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
