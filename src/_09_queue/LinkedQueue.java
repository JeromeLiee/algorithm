package _09_queue;

import java.util.NoSuchElementException;

/**
 * 通过链表实现的链式队列
 */
public class LinkedQueue {
    private Node head;
    private Node tail;

    public LinkedQueue() {
    }

    public boolean enqueue(int element) {
        Node node = new Node(element);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        return true;
    }

    public int dequeue() {
        if (head == null) throw new NoSuchElementException();
        int value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
