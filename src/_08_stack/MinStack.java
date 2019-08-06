package _08_stack;

import java.util.Stack;

/**
 * 2.最小栈
 * <p>
 * LeetCode 155
 * <p>
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minValueStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minValueStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minValueStack.isEmpty()){
            minValueStack.push(x);
            return;
        }
        if (x <= minValueStack.peek()){
            minValueStack.push(x);
        }
    }



    public void pop() {
        int pop = stack.pop();
        if (pop == minValueStack.peek()){
            minValueStack.pop();
        }
    }


    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minValueStack.peek();
    }

}
