package _09_queue;

import java.util.NoSuchElementException;

/**
 * 通过数组实现的顺序队列
 */
public class ArrayQueue {
    private int[] arr;
    private int head;
    private int tail;

    public ArrayQueue() {
        arr = new int[10];
    }

    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            capacity = 10;
        }
        arr = new int[capacity];
    }

    public boolean enqueue(int element) {
        // 数组尾部无空闲位置可插入数据
        if (tail == arr.length) {
            // 数组元素满了，需要扩容
            // 否则把元素迁移至首部
            if (head == 0) {
                ensureCapacity();
            } else {
                moveToHead();
            }
        }
        arr[tail] = element;
        tail++;
        return true;
    }

    public int dequeue() {
        if (head == tail) throw new NoSuchElementException();
        int remove = arr[head];
        head++;
        return remove;
    }

    public int size() {
        return tail - head;
    }

    private void moveToHead() {
        int count = tail - head;
        for (int i = 0; i < count; i++) {
            arr[i] = arr[i + head];
        }
        head = 0;
        tail = count;
    }

    private void ensureCapacity() {
        int length = arr.length;
        int newLength = length + (length >> 2);
        int[] newArr = new int[newLength];
        for (int i = 0; i < length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}
