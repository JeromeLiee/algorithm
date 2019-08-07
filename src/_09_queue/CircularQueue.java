package _09_queue;

import java.util.NoSuchElementException;

/**
 * 通过数组实现的循环队列，避免数组尾部空间已满导致数据需要迁移
 */
public class CircularQueue {
    private int[] arr;
    private int head;
    private int tail;
    private int size;

    public CircularQueue() {
        arr = new int[10];
    }

    public CircularQueue(int capacity) {
        if (capacity <= 0) {
            capacity = 10;
        }
        arr = new int[capacity];
    }

    public boolean enqueue(int element) {
        // 数组空间已满
        if (size == arr.length) return false;
        arr[tail] = element;
        if (tail == arr.length - 1) {
            tail = 0;
        } else {
            tail++;
        }
        size++;
        return true;
    }

    public int dequeue() {
        if (size == 0) throw new NoSuchElementException();
        int remove = arr[head];
        if (head == arr.length - 1) {
            head = 0;
        } else {
            head++;
        }
        size--;
        return remove;
    }

    public int size() {
        return size;
    }
}







