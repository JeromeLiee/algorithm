package _06_linked;


/**
 * 基于单链表实现的LRU缓存
 * <p>
 * 1.此数据已经缓存在链表中，则遍历链表得到该节点，并将其从原来的位置删除掉，然后插入到链表头
 * 2.此数据没有缓存在链表中：
 * 2.1 缓存未满，则直接插到链表头
 * 2.2 缓存已满，则删除链表尾结点，然后将新的数据插入到链表头
 */
public class LRULinked {

    private int capacity = 10;
    private Node head;
    private int size;

    public LRULinked() {

    }

    public LRULinked(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must > 0. Illegal capacity: " + capacity);
        }
        this.capacity = capacity;
    }

    public boolean add(Node node){
        if (head == null){}
        Node pre = findPreNode(node);
        return true;
    }

    private Node findPreNode(Node node) {
        return null;
    }


    class Node {

        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
