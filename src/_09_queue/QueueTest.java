package _09_queue;

public class QueueTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println("pop=" + myStack.pop());
        System.out.println("top=" + myStack.top());
        System.out.println("empty=" + myStack.empty());
        System.out.println("---------------------------");
        ArrayQueue arrayQueue = new ArrayQueue();
        for (int i = 1; i <= 100; i++) {
            arrayQueue.enqueue(i);
        }
        System.out.println("arrayQueue.size(): " + arrayQueue.size());
        for (int i = 0; i < 20; i++) {
            arrayQueue.dequeue();
        }
        System.out.println("arrayQueue.size(): " + arrayQueue.size());
        for (int i = 1; i <= 10; i++) {
            arrayQueue.enqueue(i);
        }
        System.out.println("arrayQueue.size(): " + arrayQueue.size());
        for (int i = 0; i < 90; i++) {
            System.out.println("element: "+ arrayQueue.dequeue());
        }
        System.out.println("arrayQueue.size(): " + arrayQueue.size());
        int[] aa = new int[10];
        System.out.println(aa.length);
        System.out.println("--------------------------------------------");
        CircularQueue circularQueue = new CircularQueue();
        for (int i = 1; i <= 10; i++) {
            circularQueue.enqueue(i);
        }
        System.out.println("circularQueue.size()="+circularQueue.size());
        System.out.println("enqueue: "+ circularQueue.enqueue(11));
        System.out.println("circularQueue.size()="+circularQueue.size());
        System.out.println("dequeue: " + circularQueue.dequeue());
        System.out.println("dequeue: " + circularQueue.dequeue());
        System.out.println("dequeue: " + circularQueue.dequeue());
        System.out.println("circularQueue.size()="+circularQueue.size());
        circularQueue.enqueue(12);
        circularQueue.enqueue(13);
        System.out.println("circularQueue.size()="+circularQueue.size());
        for (int i = 0; i < 9; i++) {
            System.out.println("element: " + circularQueue.dequeue());
        }
    }
}
