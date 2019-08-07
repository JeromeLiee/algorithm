package _09_queue;

public class QueueTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println("pop=" + myStack.pop());
        System.out.println("top=" + myStack.top());
        System.out.println("empty=" + myStack.empty());
    }
}
