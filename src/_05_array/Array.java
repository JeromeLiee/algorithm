package _05_array;

public class Array {
    private static int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size;
    private int[] arr;

    public Array() {
        capacity = DEFAULT_CAPACITY;
        arr = new int[DEFAULT_CAPACITY];
    }

    public Array(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must > 0. Illegal capacity: " + capacity);
        }
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public boolean add(int element) {
        ensureArrSize(size + 1);
        arr[size++] = element;
        return true;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return arr[index];
    }

    public int size() {
        return size;
    }

    private void ensureArrSize(int size) {
        if (size == capacity) {
            // 扩容
            growCapacity();
        }
    }

    private void growCapacity() {
        capacity = capacity + (capacity >> 1);
        int[] newArr = new int[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}
